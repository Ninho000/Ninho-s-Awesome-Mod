package net.ninho.ninhosawm.datagen;

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
    }


    private void addItems(TagKey<Item> tag, ItemLike... items) {
        for (ItemLike item : items) {
            tag(tag).add(item.asItem().builtInRegistryHolder().key());
        }
    }
}