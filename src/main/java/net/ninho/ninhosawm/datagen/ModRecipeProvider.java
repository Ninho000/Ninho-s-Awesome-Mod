package net.ninho.ninhosawm.datagen;

import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.ninho.ninhosawm.datagen.recipes.AwesomeWorldRecipes;
import net.ninho.ninhosawm.datagen.recipes.MagMachinesRecipes;
import net.ninho.ninhosawm.datagen.recipes.MountRecipes;
import net.ninho.ninhosawm.datagen.recipes.SteelRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
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
        @Override
    protected void buildRecipes() {
        new AwesomeWorldRecipes(registries, output).buildRecipes();
        new MagMachinesRecipes(registries, output).buildRecipes();
        new MountRecipes(registries, output).buildRecipes();
        new SteelRecipes(registries, output).buildRecipes();
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
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, NinhosAwesomeMod.MOD_ID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }

}