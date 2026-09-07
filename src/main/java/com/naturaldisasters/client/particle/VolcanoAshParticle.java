package com.naturaldisasters.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

// Partícula de cinza de vulcão
@Environment(EnvType.CLIENT)
public class VolcanoAshParticle extends SpriteBillboardParticle {
    
    public VolcanoAshParticle(ClientWorld world, double x, double y, double z,
                               double velocityX, double velocityY, double velocityZ,
                               SpriteProvider spriteProvider) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        
        this.velocityX = velocityX + (random.nextFloat() - 0.5f) * 0.1f;
        this.velocityY = velocityY + random.nextFloat() * 0.2f;
        this.velocityZ = velocityZ + (random.nextFloat() - 0.5f) * 0.1f;
        this.velocityMultiplier = 0.9f;
        this.gravityStrength = 0.05f;
        
        this.maxAge = 80 + random.nextInt(60);
        this.scale = 0.3f + random.nextFloat() * 0.7f;
        this.alpha = 0.4f + random.nextFloat() * 0.3f;
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
            return new VolcanoAshParticle(clientWorld, x, y, z, velocityX, velocityY, velocityZ, this.spriteProvider);
        }
    }
}
