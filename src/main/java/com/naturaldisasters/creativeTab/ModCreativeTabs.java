package com.naturaldisasters.creativeTab;

import com.naturaldisasters.NaturalDisastersMod;
import com.naturaldisasters.block.ModBlocks;
import com.naturaldisasters.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModCreativeTabs {
    
    public static final ItemGroup NATURAL_DISASTERS_TAB = registerItemGroup(
            "natural_disasters_tab",
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.TORNADO_SPAWNER))
                    .displayName(Text.translatable("itemGroup.natural_disasters.tab"))
                    .entries((displayContext, entries) -> {
                        // Adicionar blocos
                        entries.add(ModBlocks.TORNADO_SPAWNER);
                        entries.add(ModBlocks.VOLCANO_BLOCK);
                        entries.add(ModBlocks.LAVA_FLOW_BLOCK);
                        entries.add(ModBlocks.FLOOD_WATER_BLOCK);
                        entries.add(ModBlocks.EARTHQUAKE_CRACK);
                        entries.add(ModBlocks.TSUNAMI_WARNING);
                        entries.add(ModBlocks.WILDFIRE_ASH);
                        entries.add(ModBlocks.HAILSTONE_BLOCK);
                        entries.add(ModBlocks.DUST_STORM_BLOCK);
                        entries.add(ModBlocks.LIGHTNING_ROD_ENHANCED);
                        
                        // Adicionar itens
                        entries.add(ModItems.TORNADO_SEED);
                        entries.add(ModItems.VOLCANO_ERUPTION_TRIGGER);
                        entries.add(ModItems.FLOOD_SPAWN_EGG);
                        entries.add(ModItems.EARTHQUAKE_CHARGE);
                        entries.add(ModItems.TSUNAMI_WARNING_DEVICE);
                        entries.add(ModItems.WILDFIRE_STARTER);
                        entries.add(ModItems.HAILSTONE_SPAWNER);
                        entries.add(ModItems.DUST_STORM_GENERATOR);
                        entries.add(ModItems.LIGHTNING_STRIKER);
                        entries.add(ModItems.WEATHER_CONTROL_UNIT);
                    })
                    .build()
    );
    
    private static ItemGroup registerItemGroup(String name, ItemGroup itemGroup) {
        Identifier id = new Identifier(NaturalDisastersMod.MOD_ID, name);
        return Registry.register(Registries.ITEM_GROUP, id, itemGroup);
    }
    
    public static void register() {
        NaturalDisastersMod.LOGGER.info("Registrando creative tabs do Natural Disasters Mod");
    }
}
