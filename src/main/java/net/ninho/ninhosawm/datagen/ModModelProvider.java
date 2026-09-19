package net.ninho.ninhosawm.datagen;

import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.ninho.ninhosawm.block.ModBlocks;
import net.ninho.ninhosawm.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, NinhosAwesomeMod.MOD_ID);
    }

    private final Set<Block> manualBlocks = new HashSet<>();

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        itemModels.generateFlatItem(ModItems.DODO_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.NEBULA_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.RAW_STEEL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.BASIC_GEARS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.BASIC_STORAGE.get(), ModelTemplates.FLAT_ITEM);
//============================================ TOOLS ================================================
        itemModels.generateFlatItem(ModItems.STEEL_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.STEEL_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.STEEL_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.STEEL_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

//========================================== CRAFTERS ===============================================
        blockModels.createNonTemplateModelBlock(ModBlocks.CRAFTER_BLOCK.get());

//======================================== CONTRAPTIONS =============================================
        blockModels.createNonTemplateModelBlock(ModBlocks.COPPER_WATER_RESERVOIR.get());
        manualBlock(ModBlocks.STONE_BOILER.get());

        generateFacingBlock(blockModels, ModBlocks.NETHERITE_MINER.get());
        generateFacingBlock(blockModels, ModBlocks.DIAMOND_MINER.get());
        generateFacingBlock(blockModels, ModBlocks.IRON_MINER.get());

        blockModels.createNonTemplateModelBlock(ModBlocks.I_BEAM.get());

        generateFacingBlock(blockModels, ModBlocks.COBBLESTONE_GENERATOR.get());

//======================================= Minecraft Like ============================================
        blockModels.family(ModBlocks.FULL_GRASS_BLOCK.get())
                .stairs(ModBlocks.GRASS_STAIRS.get()).slab(ModBlocks.GRASS_SLAB.get());
        blockModels.family(Blocks.DIRT)
                .stairs(ModBlocks.DIRT_STAIRS.get()).slab(ModBlocks.DIRT_SLAB.get());
        blockModels.family(Blocks.COARSE_DIRT)
                .stairs(ModBlocks.COARSE_STAIRS.get()).slab(ModBlocks.COARSE_SLAB.get());
        blockModels.family(ModBlocks.FULL_PATH_BLOCK.get())
                .stairs(ModBlocks.PATH_STAIRS.get()).slab(ModBlocks.PATH_SLAB.get());
        blockModels.family(Blocks.CALCITE)
                .stairs(ModBlocks.CALCITE_STAIRS.get())
                .slab(ModBlocks.CALCITE_SLAB.get())
                .wall(ModBlocks.CALCITE_WALL.get());
    }
    //Manueal Generated BLock
    private void manualBlock(Block block) {
        manualBlocks.add(block);
    }
    //Simple Horizontal Block Function
    private void generateFacingBlock(BlockModelGenerators blockModels, Block block) {
        Identifier model = ModelLocationUtils.getModelLocation(block);

        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(block,BlockModelGenerators.plainVariant(model)
                ).with(PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING)
                                .select(Direction.NORTH, BlockModelGenerators.NOP)
                                .select(Direction.EAST, BlockModelGenerators.Y_ROT_90)
                                .select(Direction.SOUTH, BlockModelGenerators.Y_ROT_180)
                                .select(Direction.WEST, BlockModelGenerators.Y_ROT_270)
                )
        );
    }
    //New validation Method ta remove Manual Blocks from the list before execute
    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return super.getKnownBlocks()
                .filter(holder -> !manualBlocks.contains(holder.value()));
    }
}