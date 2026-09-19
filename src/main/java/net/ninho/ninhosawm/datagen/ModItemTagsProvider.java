package net.ninho.ninhosawm.datagen;

import net.minecraft.world.level.block.Blocks;
import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.ninho.ninhosawm.item.ModItems;
import net.ninho.ninhosawm.tags.ModTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, NinhosAwesomeMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
//======================== Repairs ============================
        addItems(ModTags.STEEL_REPAIRABLE,
                (Items.IRON_INGOT), (ModItems.STEEL_INGOT.get()));
//========================= Tiers =============================
        addItems(ModTags.STEEL,
                (ModItems.RAW_STEEL.get()),(ModItems.STEEL_INGOT.get()),
                (ModItems.STEEL_PICKAXE.get()),(ModItems.STEEL_AXE.get()),
                (ModItems.STEEL_SHOVEL.get()),(ModItems.STEEL_HOE.get()));
//========================= Tools =============================
        addItems(ItemTags.PICKAXES, (ModItems.STEEL_PICKAXE.get()));
        addItems(ItemTags.SHOVELS, (ModItems.STEEL_SHOVEL.get()));
        addItems(ItemTags.AXES, (ModItems.STEEL_AXE.get()));
        addItems(ItemTags.HOES, (ModItems.STEEL_HOE.get()));

        addItems(ModTags.STRIPPED_LOGS_ITEMS,
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

    private void addItems(TagKey<Item> tag, ItemLike... items) {
        for (ItemLike item : items) {
            tag(tag).add(item.asItem().builtInRegistryHolder().key());
        }
    }
}