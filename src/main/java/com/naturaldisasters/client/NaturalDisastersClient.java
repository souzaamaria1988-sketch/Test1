package com.naturaldisasters.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.render.RenderLayer;

import com.naturaldisasters.NaturalDisastersMod;
import com.naturaldisasters.block.ModBlocks;
import com.naturaldisasters.particle.ModParticles;
import com.naturaldisasters.client.particle.*;

public class NaturalDisastersClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        NaturalDisastersMod.LOGGER.info("Inicializando cliente do Natural Disasters Mod");
        
        // Registrar fábricas de partículas
        registerParticles();
        
        // Configurar camadas de renderização para blocos
        setupBlockRenderLayers();
    }
    
    private void registerParticles() {
        // Partículas de tornado
        ParticleFactoryRegistry.getInstance().register(ModParticles.TORNADO_DEBRIS, TornadoDebrisParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.TORNADO_DUST, TornadoDustParticle.Provider::new);
        
        // Partículas de vulcão
        ParticleFactoryRegistry.getInstance().register(ModParticles.VOLCANO_ASH, VolcanoAshParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.VOLCANO_SMOKE, VolcanoSmokeParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LAVA_BUBBLE, LavaBubbleParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.VOLCANO_SPARK, VolcanoSparkParticle.Provider::new);
        
        // Partículas de terremoto
        ParticleFactoryRegistry.getInstance().register(ModParticles.EARTHQUAKE_DUST, EarthquakeDustParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.CRACK_EFFECT, CrackEffectParticle.Provider::new);
        
        // Partículas de tsunami e inundação
        ParticleFactoryRegistry.getInstance().register(ModParticles.TSUNAMI_FOAM, TsunamiFoamParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.FLOOD_SPLASH, FloodSplashParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.WATER_DROP, WaterDropParticle.Provider::new);
        
        // Partículas de incêndio
        ParticleFactoryRegistry.getInstance().register(ModParticles.WILDFIRE_EMBER, WildfireEmberParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SMOKE_PLUME, SmokePlumeParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.FIRE_SPARK, FireSparkParticle.Provider::new);
        
        // Partículas de granizo
        ParticleFactoryRegistry.getInstance().register(ModParticles.HAILSTONE_PARTICLE, HailstoneParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ICE_CRYSTAL, IceCrystalParticle.Provider::new);
        
        // Partículas de tempestade de areia
        ParticleFactoryRegistry.getInstance().register(ModParticles.DUST_CLOUD, DustCloudParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SAND_PARTICLE, SandParticle.Provider::new);
        
        // Partículas de relâmpago
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIGHTNING_BOLT, LightningBoltParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ELECTRIC_SPARK, ElectricSparkParticle.Provider::new);
        
        // Partícula de alerta
        ParticleFactoryRegistry.getInstance().register(ModParticles.WARNING_FLASH, WarningFlashParticle.Provider::new);
    }
    
    private void setupBlockRenderLayers() {
        // Configurar renderização transparente para alguns blocos
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLOOD_WATER_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LAVA_FLOW_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TSUNAMI_WARNING, RenderLayer.getCutout());
    }
}
