package com.naturaldisasters.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

// Partícula genérica para todos os outros tipos
@Environment(EnvType.CLIENT)
public class GenericParticle extends SpriteBillboardParticle {
    
    private final DefaultParticleType type;
    private final SpriteProvider spriteProvider;
    
    public GenericParticle(ClientWorld world, double x, double y, double z,
                           double velocityX, double velocityY, double velocityZ,
                           SpriteProvider spriteProvider, DefaultParticleType type) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        
        this.spriteProvider = spriteProvider;
        this.type = type;
        this.velocityMultiplier = 0.9f;
        this.gravityStrength = 0.05f;
        
        this.maxAge = 40 + random.nextInt(30);
        this.scale = 0.5f + random.nextFloat() * 1.0f;
        this.alpha = 0.5f + random.nextFloat() * 0.3f;
        this.setSpriteForAge(spriteProvider);
    }
    
    @Override
    public void tick() {
        super.tick();
        this.setSpriteForAge(spriteProvider);
    }
    
    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }
    
    @Environment(EnvType.CLIENT)
    public static class Provider implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;
        
        public Provider(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }
        
        @Override
        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld,
                                       double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new GenericParticle(clientWorld, x, y, z, velocityX, velocityY, velocityZ, this.spriteProvider, defaultParticleType);
        }
    }
}
