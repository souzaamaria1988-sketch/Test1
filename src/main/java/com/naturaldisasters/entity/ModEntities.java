package com.naturaldisasters.entity;

import com.naturaldisasters.NaturalDisastersMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    
    // Entidades de desastres naturais
    public static final EntityType<?> TORNADO_ENTITY = registerEntity("tornado",
            EntityType.Builder.create((type, world) -> new TornadoEntity(type, world), SpawnGroup.MISC)
                    .dimensions(2.0f, 8.0f)
                    .maxTrackingRange(64)
                    .trackingTickInterval(1));
    
    public static final EntityType<?> VOLCANO_PROJECTILE = registerEntity("volcano_projectile",
            EntityType.Builder.create((type, world) -> new VolcanoProjectileEntity(type, world), SpawnGroup.MISC)
                    .dimensions(1.0f, 1.0f)
                    .maxTrackingRange(32)
                    .trackingTickInterval(1));
    
    public static final EntityType<?> TSUNAMI_WAVE_ENTITY = registerEntity("tsunami_wave",
            EntityType.Builder.create((type, world) -> new TsunamiWaveEntity(type, world), SpawnGroup.MISC)
                    .dimensions(10.0f, 5.0f)
                    .maxTrackingRange(128)
                    .trackingTickInterval(1));
    
    private static EntityType<?> registerEntity(String name, EntityType.Builder<?> builder) {
        Identifier id = new Identifier(NaturalDisastersMod.MOD_ID, name);
        EntityType<?> entityType = builder.build(id.toString());
        Registry.register(Registries.ENTITY_TYPE, id, entityType);
        return entityType;
    }
    
    public static void register() {
        NaturalDisastersMod.LOGGER.info("Registrando entidades do Natural Disasters Mod");
    }
}

// Classe base para entidade de tornado
class TornadoEntity extends net.minecraft.entity.Entity {
    public TornadoEntity(EntityType<?> type, net.minecraft.world.World world) {
        super(type, world);
    }
    
    @Override
    protected void initDataTracker() {}
}

// Classe base para projétil de vulcão
class VolcanoProjectileEntity extends net.minecraft.entity.Entity {
    public VolcanoProjectileEntity(EntityType<?> type, net.minecraft.world.World world) {
        super(type, world);
    }
    
    @Override
    protected void initDataTracker() {}
}

// Classe base para onda de tsunami
class TsunamiWaveEntity extends net.minecraft.entity.Entity {
    public TsunamiWaveEntity(EntityType<?> type, net.minecraft.world.World world) {
        super(type, world);
    }
    
    @Override
    protected void initDataTracker() {}
}
