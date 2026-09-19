package net.ninho.ninhosawm.datagen.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.ninho.ninhosawm.block.ModBlocks;

public class AwesomeWorldRecipes extends RecipeProvider {

    public AwesomeWorldRecipes(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }
    @Override
    public void buildRecipes() {
//=======================================================================================================
//                                      Minecraft Recipes
//=======================================================================================================
        //Soil
        shapeless(RecipeCategory.BUILDING_BLOCKS, Items.GRASS_BLOCK)
                .requires(Items.DIRT)
                .requires(Items.WHEAT_SEEDS)
                .requires(Items.BONE_MEAL)
                .unlockedBy(getHasName(Items.GRASS_BLOCK), has(Items.DIRT))
                .group("building_blocks")
                .save(output);
        slabRecipe(Items.GRASS_BLOCK, ModBlocks.GRASS_SLAB,3);
        slabRecipe(Items.GRASS_BLOCK, ModBlocks.GRASS_STAIRS,6);
        shaped(RecipeCategory.BUILDING_BLOCKS, Items.DIRT,5)
                .pattern("CBC")
                .pattern("BAB")
                .pattern("CBC")
                .define('A', Items.MUD)
                .define('B', Items.GRAVEL)
                .define('C', Items.CHARCOAL)
                .unlockedBy(getHasName(Items.DIRT), has(Items.DIRT))
                .group("building_blocks")
                .save(output);
        slabRecipe(Items.DIRT, ModBlocks.DIRT_SLAB,3);
        stairRecipe(Items.DIRT, ModBlocks.DIRT_STAIRS,6);
        slabRecipe(Items.COARSE_DIRT, ModBlocks.COARSE_SLAB,3);
        stairRecipe(Items.COARSE_DIRT, ModBlocks.COARSE_STAIRS,6);
        slabRecipe(Items.DIRT_PATH, ModBlocks.PATH_SLAB,3);
        stairRecipe(Items.DIRT_PATH, ModBlocks.PATH_STAIRS,6);
        //Minerals
        compacter(RecipeCategory.MISC, Items.CHARCOAL, Blocks.COAL_BLOCK);
        shaped(RecipeCategory.BUILDING_BLOCKS, Items.CALCITE)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.BONE_MEAL)
                .define('B', Items.COAL_BLOCK)
                .unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE))
                .group("building_blocks")
                .save(output);
        slabRecipe(Items.CALCITE, ModBlocks.CALCITE_SLAB);
        stairRecipe(Items.CALCITE, ModBlocks.CALCITE_STAIRS);
        wallRecipe(Items.CALCITE, ModBlocks.CALCITE_WALL);
    }
    //======================================= Quick Recipes ===================================================
    private void slabRecipe(ItemLike material, ItemLike slab) {
        slabRecipe(material, slab, 6);
    }
    private void slabRecipe(ItemLike material, ItemLike slab, int result) {
        shaped(RecipeCategory.BUILDING_BLOCKS, slab, result)
                .pattern("###")
                .define('#', material)
                .group("building_blocks")
                .unlockedBy(getHasName(material), has(material))
                .save(output, NinhosAwesomeMod.MOD_ID + ":" + getItemName(slab) + "_slab");
    }
    private void stairRecipe( ItemLike material, ItemLike stair) {
        slabRecipe(material, stair, 4);
    }
    private void stairRecipe(ItemLike material, ItemLike stair, int result) {
        shaped(RecipeCategory.BUILDING_BLOCKS, stair, result)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', material)
                .group("building_blocks")
                .unlockedBy(getHasName(material), has(material))
                .save(output, NinhosAwesomeMod.MOD_ID + ":" + getItemName(stair) + "_stairs");
    }

    private void wallRecipe(ItemLike material, ItemLike wall) {
        shaped(RecipeCategory.BUILDING_BLOCKS, wall,6)
                .pattern("###")
                .pattern("###")
                .define('#', material)
                .group("building_blocks")
                .unlockedBy(getHasName(material), has(material))
                .save(output, NinhosAwesomeMod.MOD_ID + ":" + getItemName(wall) + "_wall");
    }
    private  void compacter(RecipeCategory category, ItemLike item, ItemLike block){
        shapeless(category, block)
                .requires(item, 9)
                .unlockedBy(getHasName(item), has(item))
                .save(output);
        shapeless(category, item,9)
                .requires(item)
                .unlockedBy(getHasName(item), has(item))
                .save(output);
    }
}
