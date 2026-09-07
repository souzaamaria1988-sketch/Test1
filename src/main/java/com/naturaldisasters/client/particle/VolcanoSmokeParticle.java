package com.naturaldisasters.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

// Partícula de fumaça de vulcão
@Environment(EnvType.CLIENT)
public class VolcanoSmokeParticle extends SpriteBillboardParticle {
    
    public VolcanoSmokeParticle(ClientWorld world, double x, double y, double z,
                                 double velocityX, double velocityY, double velocityZ,
                                 SpriteProvider spriteProvider) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        
        this.velocityX = velocityX + (random.nextFloat() - 0.5f) * 0.05f;
        this.velocityY = velocityY + 0.1f + random.nextFloat() * 0.1f;
        this.velocityZ = velocityZ + (random.nextFloat() - 0.5f) * 0.05f;
        this.velocityMultiplier = 0.95f;
        this.gravityStrength = -0.02f;
        
        this.maxAge = 100 + random.nextInt(80);
        this.scale = 2.0f + random.nextFloat() * 3.0f;
        this.alpha = 0.2f + random.nextFloat() * 0.3f;
        this.setSpriteForAge(spriteProvider);
    }
    
    @Override
    public void tick() {
        super.tick();
        this.scale += 0.02f;
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
            return new VolcanoSmokeParticle(clientWorld, x, y, z, velocityX, velocityY, velocityZ, this.spriteProvider);
        }
    }
}
