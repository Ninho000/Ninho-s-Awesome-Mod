package net.ninho.ninhosawm.datagen.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.ninho.ninhosawm.block.ModBlocks;
import net.ninho.ninhosawm.item.ModItems;
import net.ninho.ninhosawm.tags.ModTags;

public class MagMachinesRecipes extends RecipeProvider {

    public MagMachinesRecipes(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    public void buildRecipes() {
        shaped(RecipeCategory.MISC, ModBlocks.I_BEAM.get(),6)
                .pattern("AAA")
                .pattern(" A ")
                .pattern("AAA")
                .define('A', Items.IRON_INGOT)
                .unlockedBy(getHasName(ModBlocks.I_BEAM.get()), has(Items.IRON_INGOT))
                .group("machine ingredients")
                .save(output);
        shaped(RecipeCategory.MISC, ModItems.BASIC_GEARS.get(),2)
                .pattern(" BA")
                .pattern("B B")
                .pattern("AB ")
                .define('A', Items.STICK)
                .define('B', ModTags.STRIPPED_LOGS_ITEMS)
                .unlockedBy(getHasName(ModBlocks.I_BEAM.get()), has(Items.IRON_INGOT))
                .group("machine ingredients")
                .save(output);

//=======================================================================================================
//                                            ENGINES
//=======================================================================================================
        shaped(RecipeCategory.MISC, ModBlocks.COPPER_WATER_RESERVOIR.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.COPPER_INGOT)
                .define('B', Items.WATER_BUCKET)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .group("machine engines")
                .save(output);
        shaped(RecipeCategory.MISC, ModBlocks.STONE_BOILER.get())
                .pattern("EDE")
                .pattern("BAB")
                .pattern("CCC")
                .define('A', Blocks.FURNACE)
                .define('B', Blocks.STONE_BRICKS)
                .define('C', Blocks.SMOOTH_STONE_SLAB)
                .define('D', Items.IRON_INGOT)
                .define('E', ModItems.BASIC_GEARS)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .group("machine engines")
                .save(output);

//=======================================================================================================
//                                             TOOLS
//=======================================================================================================
        shaped(RecipeCategory.MISC, ModBlocks.IRON_MINER)
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
//=======================================================================================================
//                                            MACHINES
//=======================================================================================================
        shaped(RecipeCategory.MISC, ModBlocks.COBBLESTONE_GENERATOR.get())
                .pattern("DDD")
                .pattern("ACB")
                .pattern("EFE")
                .define('A', Items.WATER_BUCKET)
                .define('B', Items.LAVA_BUCKET)
                .define('C', Items.HOPPER_MINECART)
                .define('D', Blocks.GLASS)
                .define('E', Blocks.STONE_BRICKS)
                .define('F', Blocks.CHEST)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .group("machine engines")
                .save(output);
    }
}
