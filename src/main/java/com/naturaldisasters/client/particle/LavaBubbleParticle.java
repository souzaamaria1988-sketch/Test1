package com.naturaldisasters.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

// Partícula de bolha de lava
@Environment(EnvType.CLIENT)
public class LavaBubbleParticle extends SpriteBillboardParticle {
    
    public LavaBubbleParticle(ClientWorld world, double x, double y, double z,
                               double velocityX, double velocityY, double velocityZ,
                               SpriteProvider spriteProvider) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        
        this.velocityX = (random.nextFloat() - 0.5f) * 0.02f;
        this.velocityY = 0.05f + random.nextFloat() * 0.05f;
        this.velocityZ = (random.nextFloat() - 0.5f) * 0.02f;
        this.velocityMultiplier = 0.9f;
        this.gravityStrength = 0.0f;
        
        this.maxAge = 30 + random.nextInt(20);
        this.scale = 0.2f + random.nextFloat() * 0.4f;
        this.alpha = 0.6f + random.nextFloat() * 0.3f;
        this.setSpriteForAge(spriteProvider);
    }
    
    @Override
    public void tick() {
        super.tick();
        this.scale += 0.01f;
        this.setSpriteForAge(this.spriteProvider);
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
            return new LavaBubbleParticle(clientWorld, x, y, z, velocityX, velocityY, velocityZ, this.spriteProvider);
        }
    }
}
