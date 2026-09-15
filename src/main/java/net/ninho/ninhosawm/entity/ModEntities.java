package net.ninho.ninhosawm.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.ninho.ninhosawm.entity.dodo.DodoEntity;
import net.ninho.ninhosawm.entity.nebula.NebulaEntity;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.createEntities(NinhosAwesomeMod.MOD_ID);

    public static final ResourceKey<EntityType<?>> DODO_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(NinhosAwesomeMod.MOD_ID, "dodo"));
    public static final Supplier<EntityType<DodoEntity>> DODO = ENTITY_TYPES.register("dodo",
            () -> EntityType.Builder.of(DodoEntity::new, MobCategory.CREATURE).sized(1f, 2.5f).build(DODO_KEY));

    public static final ResourceKey<EntityType<?>> NEBULA_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(NinhosAwesomeMod.MOD_ID, "nebula"));
    public static final Supplier<EntityType<NebulaEntity>> NEBULA = ENTITY_TYPES.register("nebula",
            () -> EntityType.Builder.of(NebulaEntity::new, MobCategory.CREATURE).sized(0.8f, 0.6f).build(NEBULA_KEY));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}