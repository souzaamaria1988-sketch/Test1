package com.naturaldisasters.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

// Partícula de detritos de tornado
@Environment(EnvType.CLIENT)
public class TornadoDebrisParticle extends SpriteBillboardParticle {
    
    private final SpriteProvider spriteProvider;
    private float angle;
    private float angularVelocity;
    
    public TornadoDebrisParticle(ClientWorld world, double x, double y, double z, 
                                  double velocityX, double velocityY, double velocityZ,
                                  SpriteProvider spriteProvider) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        
        this.spriteProvider = spriteProvider;
        this.velocityMultiplier = 0.9f;
        this.gravityStrength = 0.1f;
        this.angle = random.nextFloat() * 360.0f;
        this.angularVelocity = (random.nextFloat() - 0.5f) * 0.2f;
        
        this.maxAge = 40 + random.nextInt(20);
        this.scale = 0.5f + random.nextFloat() * 0.5f;
        this.setSpriteForAge(spriteProvider);
    }
    
    @Override
    public void tick() {
        super.tick();
        this.angle += this.angularVelocity;
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
            return new TornadoDebrisParticle(clientWorld, x, y, z, velocityX, velocityY, velocityZ, this.spriteProvider);
        }
    }
}
