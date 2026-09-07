package com.naturaldisasters.block;

import com.naturaldisasters.NaturalDisastersMod;
import com.naturaldisasters.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    
    // Blocos de Desastres Naturais
    public static final Block TORNADO_SPAWNER = registerBlock("tornado_spawner",
            new Block(AbstractBlock.Settings.create().strength(3.0f).sounds(BlockSoundGroup.STONE)));
    
    public static final Block VOLCANO_BLOCK = registerBlock("volcano_block",
            new Block(AbstractBlock.Settings.create().strength(5.0f).sounds(BlockSoundGroup.DEEPSLATE)));
    
    public static final Block LAVA_FLOW_BLOCK = registerBlock("lava_flow_block",
            new Block(AbstractBlock.Settings.create().strength(2.0f).sounds(BlockSoundGroup.BASALT)));
    
    public static final Block FLOOD_WATER_BLOCK = registerBlock("flood_water_block",
            new Block(AbstractBlock.Settings.create().strength(1.0f).sounds(BlockSoundGroup.WET_GRASS)));
    
    public static final Block EARTHQUAKE_CRACK = registerBlock("earthquake_crack",
            new Block(AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.DEEPSLATE)));
    
    public static final Block TSUNAMI_WARNING = registerBlock("tsunami_warning",
            new Block(AbstractBlock.Settings.create().strength(2.0f).sounds(BlockSoundGroup.METAL)));
    
    public static final Block WILDFIRE_ASH = registerBlock("wildfire_ash",
            new Block(AbstractBlock.Settings.create().strength(0.3f).sounds(BlockSoundGroup.SAND)));
    
    public static final Block HAILSTONE_BLOCK = registerBlock("hailstone_block",
            new Block(AbstractBlock.Settings.create().strength(1.5f).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    
    public static final Block DUST_STORM_BLOCK = registerBlock("dust_storm_block",
            new Block(AbstractBlock.Settings.create().strength(0.8f).sounds(BlockSoundGroup.SAND)));
    
    public static final Block LIGHTNING_ROD_ENHANCED = registerBlock("lightning_rod_enhanced",
            new Block(AbstractBlock.Settings.create().strength(3.0f).sounds(BlockSoundGroup.COPPER)));
    
    private static Block registerBlock(String name, Block block) {
        Identifier id = new Identifier(NaturalDisastersMod.MOD_ID, name);
        Registry.register(Registries.BLOCK, id, block);
        registerBlockItem(name, block);
        return block;
    }
    
    private static void registerBlockItem(String name, Block block) {
        Identifier id = new Identifier(NaturalDisastersMod.MOD_ID, name);
        Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
    }
    
    public static void register() {
        NaturalDisastersMod.LOGGER.info("Registrando blocos do Natural Disasters Mod");
    }
}
