package net.ninho.ninhosawm.datagen.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.ninho.ninhosawm.item.ModItems;
import net.ninho.ninhosawm.tags.ModTags;

public class SteelRecipes extends RecipeProvider {

    public SteelRecipes(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    public void buildRecipes() {
//=======================================================================================================
//                                        Ingredients
//=======================================================================================================
        shapeless(RecipeCategory.MISC, ModItems.RAW_STEEL.get(), 2)
                .requires(ItemTags.COALS).requires(ItemTags.COALS)
                .requires(Items.IRON_INGOT,2)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(Items.IRON_INGOT))
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModTags.STEEL))
                .group("steel")
                .save(output);

//=======================================================================================================
//                                            TOOLS
//=======================================================================================================
        shaped(RecipeCategory.TOOLS, ModItems.STEEL_PICKAXE.get())
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.STEEL_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModTags.STEEL))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .group("tool")
                .save(output);
        shaped(RecipeCategory.TOOLS, ModItems.STEEL_SHOVEL.get())
                .pattern("A")
                .pattern("S")
                .pattern("S")
                .define('A', ModItems.STEEL_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModTags.STEEL))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .group("tool")
                .save(output);
        shaped(RecipeCategory.TOOLS, ModItems.STEEL_AXE.get())
                .pattern("AA")
                .pattern("AS")
                .pattern(" S")
                .define('A', ModItems.STEEL_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModTags.STEEL))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .group("tool")
                .save(output);
        shaped(RecipeCategory.TOOLS, ModItems.STEEL_HOE.get())
                .pattern("AA")
                .pattern(" S")
                .pattern(" S")
                .define('A', ModItems.STEEL_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModTags.STEEL))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .group("tool")
                .save(output);
    }
}