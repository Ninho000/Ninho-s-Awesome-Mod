package net.ninho.ninhosawm.datagen;

import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.ninho.ninhosawm.item.ModItems;
import net.ninho.ninhosawm.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.recipes.SimpleCookingRecipeBuilder.blasting;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }
    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }
        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }
        @Override
        public String getName() {
            return "Ninho's Awesome Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
//=======================================================================================================
//                                        Ingredients
//=======================================================================================================
        shapeless(RecipeCategory.MISC, ModItems.RAW_STEEL.get(), 2)
                .requires(ItemTags.COALS).requires(ItemTags.COALS)
                .requires(Items.IRON_INGOT,2)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(Items.IRON_INGOT))
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ItemTags.COALS))
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

//====================================================================================================================
//====================================================================================================================


    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, NinhosAwesomeMod.MOD_ID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }
}