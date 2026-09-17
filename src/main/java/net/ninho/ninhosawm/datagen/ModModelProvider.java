package net.ninho.ninhosawm.datagen;

import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.ninho.ninhosawm.block.ModBlocks;
import net.ninho.ninhosawm.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, NinhosAwesomeMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        itemModels.generateFlatItem(ModItems.DODO_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.NEBULA_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.RAW_STEEL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.BASIC_GEARS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.FLUID_CONTAINER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.BOILER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.IRON_DRILL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.BASIC_STORAGE.get(), ModelTemplates.FLAT_ITEM);
//============================================ TOOLS ================================================
        itemModels.generateFlatItem(ModItems.STEEL_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.STEEL_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.STEEL_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.STEEL_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

//========================================== CRAFTERS ===============================================
        blockModels.createNonTemplateModelBlock(ModBlocks.CRAFTER_BLOCK.get());

//======================================== CONTRAPTIONS =============================================
        /*blockModels.createTrivialBlock(
                ModBlocks.COPPER_WATER_RESERVOIR.get(),
                TexturedModel.createDefault(block -> new TextureMapping()
                                .put(TextureSlot.SIDE,modTexture("block/copper_water_reservoir_side"))
                                .put(TextureSlot.TOP, modTexture("block/copper_water_reservoir_axis"))
                                .put(TextureSlot.BOTTOM, modTexture("block/copper_water_reservoir_axis")),
                        ModelTemplates.CUBE_BOTTOM_TOP));*/

        blockModels.createNonTemplateModelBlock(ModBlocks.COPPER_WATER_RESERVOIR.get());
        blockModels.createNonTemplateModelBlock(ModBlocks.COBBLESTONE_GENERATOR.get());

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
    private static Material modTexture(String path) {
        return new Material(
                Identifier.fromNamespaceAndPath(
                        NinhosAwesomeMod.MOD_ID,
                        path
                )
        );
    }
}