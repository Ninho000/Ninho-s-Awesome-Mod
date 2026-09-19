package net.ninho.ninhosawm.block;


import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.ninho.ninhosawm.block.custom.CrafterBlock;
import net.ninho.ninhosawm.block.custom.IBeam;
import net.ninho.ninhosawm.block.custom.engine.StoneBoiler;
import net.ninho.ninhosawm.block.custom.machine.CobblestoneGenerator;
import net.ninho.ninhosawm.function.FacingBlock;
import net.ninho.ninhosawm.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(NinhosAwesomeMod.MOD_ID);

//==============================================================================================================================

    public static final DeferredBlock<Block> CRAFTER_BLOCK = registerBlock("crafter_block",
            properties -> new CrafterBlock(properties.strength(1.5F).noOcclusion()));
    public static final DeferredBlock<Block> I_BEAM = registerBlock("i_beam",
            properties -> new IBeam(properties));

    //ENGINES
    public static final DeferredBlock<Block> COPPER_WATER_RESERVOIR = registerBlock("copper_water_reservoir",Block::new);
    public static final DeferredBlock<Block> STONE_BOILER = registerBlock("stone_boiler",
            properties -> new StoneBoiler(properties.strength(2F)));

    //ENGINES
    public static final DeferredBlock<Block> NETHERITE_MINER =
            registerBlock("netherite_miner", FacingBlock::new);
    public static final DeferredBlock<Block> DIAMOND_MINER =
            registerBlock("diamond_miner", FacingBlock::new);
    public static final DeferredBlock<Block> IRON_MINER =
            registerBlock("iron_miner", FacingBlock::new);

    //MACHINES
    public static final DeferredBlock<Block> COBBLESTONE_GENERATOR = registerBlock("cobblestone_generator",
            properties -> new CobblestoneGenerator(properties.strength(2F).lightLevel(state -> 15)));

//==================================================== Minecraft Like ==========================================================
    //grass-dirt
    public static final DeferredBlock<Block> FULL_GRASS_BLOCK = registerBlock("full_grass_block",Block::new);
    public static final DeferredBlock<Block> GRASS_STAIRS = registerBlock("grass_stairs",
        properties -> new StairBlock(Blocks.GRASS_BLOCK.defaultBlockState(),
                properties.sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> GRASS_SLAB = registerBlock("grass_slab",
            properties -> new SlabBlock(properties.sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> DIRT_STAIRS = registerBlock("dirt_stairs",
            properties -> new StairBlock(Blocks.DIRT.defaultBlockState(),
                    properties.sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> DIRT_SLAB = registerBlock("dirt_slab",
            properties -> new SlabBlock(properties.sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> COARSE_STAIRS = registerBlock("coarse_stairs",
            properties -> new StairBlock(Blocks.COARSE_DIRT.defaultBlockState(),
                    properties.sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> COARSE_SLAB = registerBlock("coarse_slab",
            properties -> new SlabBlock(properties.sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> FULL_PATH_BLOCK = registerBlock("full_path_block",Block::new);
    public static final DeferredBlock<Block> PATH_STAIRS = registerBlock("path_stairs",
            properties -> new StairBlock(Blocks.DIRT_PATH.defaultBlockState(),
                    properties.sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> PATH_SLAB = registerBlock("path_slab",
            properties -> new SlabBlock(properties.sound(SoundType.GRASS)));
    //Minerals
    public static final DeferredBlock<Block> CALCITE_STAIRS = registerBlock("calcite_stairs",
            properties -> new StairBlock(Blocks.CALCITE.defaultBlockState(),
                    properties.sound(SoundType.CALCITE)));
    public static final DeferredBlock<Block> CALCITE_SLAB = registerBlock("calcite_slab",
            properties -> new SlabBlock(properties.sound(SoundType.CALCITE)));
    public static final DeferredBlock<Block> CALCITE_WALL = registerBlock("calcite_wall",
            properties -> new WallBlock(properties.sound(SoundType.CALCITE)));

//==============================================================================================================================

        public static ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function, Component... components) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn, components);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, Component... components) {
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()) {
            @Override
            public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                for(var component : components) {
                    builder.accept(component);
                }
                super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
            }
        });
    }
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}