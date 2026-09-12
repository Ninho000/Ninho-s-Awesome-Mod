package net.ninho.ninhosawm.datagen;

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
        itemModels.generateFlatItem(ModItems.COBBLESTONE_GENERATOR.get(), ModelTemplates.FLAT_ITEM);
    }
}