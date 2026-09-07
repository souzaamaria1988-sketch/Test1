package com.naturaldisasters.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

// Partícula de faísca de vulcão
@Environment(EnvType.CLIENT)
public class VolcanoSparkParticle extends SpriteBillboardParticle {
    
    public VolcanoSparkParticle(ClientWorld world, double x, double y, double z,
                                 double velocityX, double velocityY, double velocityZ,
                                 SpriteProvider spriteProvider) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        
        this.velocityX = velocityX + (random.nextFloat() - 0.5f) * 0.3f;
        this.velocityY = velocityY + random.nextFloat() * 0.5f;
        this.velocityZ = velocityZ + (random.nextFloat() - 0.5f) * 0.3f;
        this.velocityMultiplier = 0.95f;
        this.gravityStrength = 0.15f;
        
        this.maxAge = 20 + random.nextInt(15);
        this.scale = 0.1f + random.nextFloat() * 0.3f;
        this.alpha = 0.8f + random.nextFloat() * 0.2f;
        this.setSpriteForAge(spriteProvider);
    }
    
    @Override
    public void tick() {
        super.tick();
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
            return new VolcanoSparkParticle(clientWorld, x, y, z, velocityX, velocityY, velocityZ, this.spriteProvider);
        }
    }
}
