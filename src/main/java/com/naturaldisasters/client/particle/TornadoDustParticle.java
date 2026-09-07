package com.naturaldisasters.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

// Partícula de poeira de tornado
@Environment(EnvType.CLIENT)
public class TornadoDustParticle extends SpriteBillboardParticle {
    
    public TornadoDustParticle(ClientWorld world, double x, double y, double z,
                                double velocityX, double velocityY, double velocityZ,
                                SpriteProvider spriteProvider) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
        this.velocityMultiplier = 0.85f;
        this.gravityStrength = 0.02f;
        
        this.maxAge = 60 + random.nextInt(40);
        this.scale = 1.0f + random.nextFloat() * 2.0f;
        this.alpha = 0.3f + random.nextFloat() * 0.4f;
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
            return new TornadoDustParticle(clientWorld, x, y, z, velocityX, velocityY, velocityZ, this.spriteProvider);
        }
    }
}
