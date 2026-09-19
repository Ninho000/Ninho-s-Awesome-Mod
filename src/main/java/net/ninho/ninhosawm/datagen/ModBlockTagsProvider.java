package net.ninho.ninhosawm.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.ninho.ninhosawm.block.ModBlocks;
import net.ninho.ninhosawm.tags.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, NinhosAwesomeMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.INCORRECT_FOR_STEEL_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);

        addBlock(BlockTags.MINEABLE_WITH_AXE,
                ModBlocks.CRAFTER_BLOCK.get());

        addBlock(BlockTags.MINEABLE_WITH_PICKAXE,
                ModBlocks.COBBLESTONE_GENERATOR.get());

        addBlock(ModTags.STRIPPED_LOGS,
                Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_ACACIA_WOOD,
                Blocks.STRIPPED_BAMBOO_BLOCK,
                Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_BIRCH_WOOD,
                Blocks.STRIPPED_CHERRY_LOG, Blocks.STRIPPED_CHERRY_WOOD,
                Blocks.STRIPPED_CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_STEM,
                Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_WOOD,
                Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_WOOD,
                Blocks.STRIPPED_MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_WOOD,
                Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_OAK_WOOD,
                Blocks.STRIPPED_PALE_OAK_LOG, Blocks.STRIPPED_PALE_OAK_WOOD,
                Blocks.STRIPPED_SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_WOOD,
                Blocks.STRIPPED_WARPED_HYPHAE,  Blocks.STRIPPED_WARPED_STEM);
    }
    private void addBlock(TagKey<Block> tag, Block... blocks) {
        for (Block block : blocks) {
            tag(tag).add(block.builtInRegistryHolder().key());
        }
    }
}