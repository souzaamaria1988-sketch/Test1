package com.naturaldisasters;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.naturaldisasters.block.ModBlocks;
import com.naturaldisasters.item.ModItems;
import com.naturaldisasters.sound.ModSounds;
import com.naturaldisasters.particle.ModParticles;
import com.naturaldisasters.entity.ModEntities;

public class NaturalDisastersMod implements ModInitializer {
    public static final String MOD_ID = "natural_disasters";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Natural Disasters Mod está inicializando...");
        
        // Registrar creative tabs primeiro
        com.naturaldisasters.creativeTab.ModCreativeTabs.register();
        
        // Registrar blocos
        ModBlocks.register();
        
        // Registrar itens
        ModItems.register();
        
        // Registrar sons
        ModSounds.register();
        
        // Registrar partículas
        ModParticles.register();
        
        // Registrar entidades
        ModEntities.register();
        
        LOGGER.info("Natural Disasters Mod foi inicializado com sucesso!");
    }
}
