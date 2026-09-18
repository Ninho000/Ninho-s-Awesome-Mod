package net.ninho.ninhosawm.datagen.recipes;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.ninho.ninhosawm.block.ModBlocks;
import net.ninho.ninhosawm.item.ModItems;
import net.ninho.ninhosawm.tags.ModTags;

public class MagMachinesRecipes extends RecipeProvider {

    public MagMachinesRecipes(RecipeOutput output) {
        super(null, output);
    }

    @Override
    public void buildRecipes() {
        shaped(RecipeCategory.MISC, ModBlocks.I_BEAM.get(),6)
                .pattern("AAA")
                .pattern(" A ")
                .pattern("AAA")
                .define('A', Items.IRON_INGOT)
                .unlockedBy(getHasName(ModBlocks.I_BEAM.get()), has(Items.IRON_INGOT))
                .group("machine ingres")
                .save(output);
//=======================================================================================================
//                                            TOOLS
//=======================================================================================================
        shaped(RecipeCategory.MISC, ModBlocks.IRON_MINER.get())
                .pattern("ABB")
                .pattern("CCC")
                .pattern("DDD")
                .define('A', Items.LAPIS_LAZULI)
                .define('B', ModBlocks.I_BEAM.get())
                .define('C', Items.STONE)
                .define('D', Items.IRON_PICKAXE)
                .unlockedBy(getHasName(ModBlocks.IRON_MINER.get()), has( ModBlocks.I_BEAM.get()))
                .unlockedBy(getHasName(ModBlocks.IRON_MINER.get()), has(Items.IRON_PICKAXE))
                .group("machine tools")
                .save(output);
        shaped(RecipeCategory.MISC, ModBlocks.DIAMOND_MINER.get())
                .pattern("CB ")
                .pattern("AAA")
                .define('A', Items.DIAMOND)
                .define('B', ModBlocks.IRON_MINER.get())
                .define('C', Items.REDSTONE_BLOCK)
                .unlockedBy(getHasName(ModBlocks.DIAMOND_MINER.get()), has(ModBlocks.IRON_MINER.get()))
                .group("machine tools")
                .save(output);
        shaped(RecipeCategory.MISC, ModBlocks.NETHERITE_MINER.get())
                .pattern("ABC")
                .define('A', Items.GOLD_BLOCK)
                .define('B', ModBlocks.DIAMOND_MINER.get())
                .define('C', Items.NETHERITE_INGOT)
                .unlockedBy(getHasName(ModBlocks.NETHERITE_MINER.get()), has(ModBlocks.DIAMOND_MINER.get()))
                .group("machine tools")
                .save(output);
    }
}
