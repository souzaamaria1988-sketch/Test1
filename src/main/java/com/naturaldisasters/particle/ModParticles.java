package com.naturaldisasters.particle;

import com.naturaldisasters.NaturalDisastersMod;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    
    // Partículas de desastres naturais
    public static final DefaultParticleType TORNADO_DEBRIS = registerParticle("tornado_debris");
    public static final DefaultParticleType TORNADO_DUST = registerParticle("tornado_dust");
    
    public static final DefaultParticleType VOLCANO_ASH = registerParticle("volcano_ash");
    public static final DefaultParticleType VOLCANO_SMOKE = registerParticle("volcano_smoke");
    public static final DefaultParticleType LAVA_BUBBLE = registerParticle("lava_bubble");
    public static final DefaultParticleType VOLCANO_SPARK = registerParticle("volcano_spark");
    
    public static final DefaultParticleType EARTHQUAKE_DUST = registerParticle("earthquake_dust");
    public static final DefaultParticleType CRACK_EFFECT = registerParticle("crack_effect");
    
    public static final DefaultParticleType TSUNAMI_FOAM = registerParticle("tsunami_foam");
    public static final DefaultParticleType FLOOD_SPLASH = registerParticle("flood_splash");
    public static final DefaultParticleType WATER_DROP = registerParticle("water_drop");
    
    public static final DefaultParticleType WILDFIRE_EMBER = registerParticle("wildfire_ember");
    public static final DefaultParticleType SMOKE_PLUME = registerParticle("smoke_plume");
    public static final DefaultParticleType FIRE_SPARK = registerParticle("fire_spark");
    
    public static final DefaultParticleType HAILSTONE_PARTICLE = registerParticle("hailstone_particle");
    public static final DefaultParticleType ICE_CRYSTAL = registerParticle("ice_crystal");
    
    public static final DefaultParticleType DUST_CLOUD = registerParticle("dust_cloud");
    public static final DefaultParticleType SAND_PARTICLE = registerParticle("sand_particle");
    
    public static final DefaultParticleType LIGHTNING_BOLT = registerParticle("lightning_bolt");
    public static final DefaultParticleType ELECTRIC_SPARK = registerParticle("electric_spark");
    
    public static final DefaultParticleType WARNING_FLASH = registerParticle("warning_flash");
    
    private static DefaultParticleType registerParticle(String name) {
        Identifier id = new Identifier(NaturalDisastersMod.MOD_ID, name);
        DefaultParticleType particleType = FabricParticleTypes.simple();
        Registry.register(Registries.PARTICLE_TYPE, id, particleType);
        return particleType;
    }
    
    public static void register() {
        NaturalDisastersMod.LOGGER.info("Registrando partículas do Natural Disasters Mod");
    }
}
