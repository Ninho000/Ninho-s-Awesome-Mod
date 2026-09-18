package net.ninho.ninhosawm.blockentity;

import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.ninho.ninhosawm.block.ModBlocks;
import net.ninho.ninhosawm.blockentity.custom.StoneBoilerEntity;
import net.ninho.ninhosawm.blockentity.custom.CrafterBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, NinhosAwesomeMod.MOD_ID);

    public static final Supplier<BlockEntityType<CrafterBlockEntity>> CRAFTER_BLOCK_BE =
            BLOCK_ENTITIES.register("crafter_block_be", () -> new BlockEntityType<>(
                    CrafterBlockEntity::new, ModBlocks.CRAFTER_BLOCK.get()));

    public static final Supplier<BlockEntityType<net.ninho.ninhosawm.blockentity.custom.engine.StoneBoilerEntity>> STONE_BOILER =
            BLOCK_ENTITIES.register("stone_boiler_be", () -> new BlockEntityType<>(
                    net.ninho.ninhosawm.blockentity.custom.engine.StoneBoilerEntity::new, ModBlocks.STONE_BOILER.get()));

    public static final Supplier<BlockEntityType<StoneBoilerEntity>> COBBLESTONE_GENERATOR_BE =
            BLOCK_ENTITIES.register("cobblestone_generator_be", () -> new BlockEntityType<>(
                    StoneBoilerEntity::new, ModBlocks.COBBLESTONE_GENERATOR.get()));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}