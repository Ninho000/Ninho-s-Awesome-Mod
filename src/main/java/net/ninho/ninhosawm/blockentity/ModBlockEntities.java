package net.ninho.ninhosawm.blockentity;


import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.ninho.ninhosawm.block.ModBlocks;
import net.ninho.ninhosawm.blockentity.custom.CompactCrafterBlockEntity;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, NinhosAwesomeMod.MOD_ID);

    public static final Supplier<BlockEntityType<CompactCrafterBlockEntity>> ComCraft_BE =
            BLOCK_ENTITIES.register("comcraft_be", () -> new BlockEntityType<>(
                    CompactCrafterBlockEntity::new, ModBlocks.COMPACT_CRAFTER_BLOCK.get()));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}