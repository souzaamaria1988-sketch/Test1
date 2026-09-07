package com.naturaldisasters.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(EnvType.CLIENT) public class EarthquakeDustParticle extends GenericParticle {
    public EarthquakeDustParticle(ClientWorld world, double x, double y, double z, double vX, double vY, double vZ, SpriteProvider provider) {
        super(world, x, y, z, vX, vY, vZ, provider, null);
    }
    @Environment(EnvType.CLIENT)
    public static class Provider implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider provider;
        public Provider(SpriteProvider provider) { this.provider = provider; }
        @Override
        public Particle createParticle(DefaultParticleType type, ClientWorld world, double x, double y, double z, double vX, double vY, double vZ) {
            return new EarthquakeDustParticle(world, x, y, z, vX, vY, vZ, this.provider);
        }
    }
}
