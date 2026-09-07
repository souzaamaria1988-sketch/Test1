package com.naturaldisasters.item;

import com.naturaldisasters.NaturalDisastersMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    
    // Itens relacionados a desastres naturais
    public static final Item TORNADO_SEED = registerItem("tornado_seed",
            new Item(new Item.Settings()));
    
    public static final Item VOLCANO_ERUPTION_TRIGGER = registerItem("volcano_eruption_trigger",
            new Item(new Item.Settings()));
    
    public static final Item FLOOD_SPAWN_EGG = registerItem("flood_spawn_egg",
            new Item(new Item.Settings()));
    
    public static final Item EARTHQUAKE_CHARGE = registerItem("earthquake_charge",
            new Item(new Item.Settings()));
    
    public static final Item TSUNAMI_WARNING_DEVICE = registerItem("tsunami_warning_device",
            new Item(new Item.Settings()));
    
    public static final Item WILDFIRE_STARTER = registerItem("wildfire_starter",
            new Item(new Item.Settings()));
    
    public static final Item HAILSTONE_SPAWNER = registerItem("hailstone_spawner",
            new Item(new Item.Settings()));
    
    public static final Item DUST_STORM_GENERATOR = registerItem("dust_storm_generator",
            new Item(new Item.Settings()));
    
    public static final Item LIGHTNING_STRIKER = registerItem("lightning_striker",
            new Item(new Item.Settings()));
    
    public static final Item WEATHER_CONTROL_UNIT = registerItem("weather_control_unit",
            new Item(new Item.Settings().maxCount(1)));
    
    private static Item registerItem(String name, Item item) {
        Identifier id = new Identifier(NaturalDisastersMod.MOD_ID, name);
        Registry.register(Registries.ITEM, id, item);
        return item;
    }
    
    public static void register() {
        NaturalDisastersMod.LOGGER.info("Registrando itens do Natural Disasters Mod");
    }
}
