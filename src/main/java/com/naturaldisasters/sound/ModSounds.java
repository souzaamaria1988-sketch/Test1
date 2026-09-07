package com.naturaldisasters.sound;

import com.naturaldisasters.NaturalDisastersMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    
    // Sons de desastres naturais
    public static final SoundEvent TORNADO_AMBIENT = registerSoundEvent("tornado.ambient");
    public static final SoundEvent TORNADO_ROAR = registerSoundEvent("tornado.roar");
    
    public static final SoundEvent VOLCANO_ERUPTION = registerSoundEvent("volcano.eruption");
    public static final SoundEvent VOLCANO_RUMBLE = registerSoundEvent("volcano.rumble");
    public static final SoundEvent LAVA_FLOW = registerSoundEvent("lava.flow");
    
    public static final SoundEvent EARTHQUAKE_RUMBLE = registerSoundEvent("earthquake.rumble");
    public static final SoundEvent EARTHQUAKE_CRACK = registerSoundEvent("earthquake.crack");
    
    public static final SoundEvent TSUNAMI_WAVE = registerSoundEvent("tsunami.wave");
    public static final SoundEvent FLOOD_WATER = registerSoundEvent("flood.water");
    
    public static final SoundEvent WILDFIRE_BURN = registerSoundEvent("wildfire.burn");
    public static final SoundEvent WILDFIRE_CRACKLE = registerSoundEvent("wildfire.crackle");
    
    public static final SoundEvent HAILSTONE_IMPACT = registerSoundEvent("hailstone.impact");
    public static final SoundEvent HAILSTORM_AMBIENT = registerSoundEvent("hailstorm.ambient");
    
    public static final SoundEvent DUST_STORM_WIND = registerSoundEvent("dust_storm.wind");
    
    public static final SoundEvent LIGHTNING_STRIKE = registerSoundEvent("lightning.strike");
    public static final SoundEvent THUNDER_BOOM = registerSoundEvent("thunder.boom");
    
    public static final SoundEvent WARNING_SIREN = registerSoundEvent("warning.siren");
    
    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(NaturalDisastersMod.MOD_ID, name);
        SoundEvent soundEvent = SoundEvent.of(id);
        Registry.register(Registries.SOUND_EVENT, id, soundEvent);
        return soundEvent;
    }
    
    public static void register() {
        NaturalDisastersMod.LOGGER.info("Registrando sons do Natural Disasters Mod");
    }
}
