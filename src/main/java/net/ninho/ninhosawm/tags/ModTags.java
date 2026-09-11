package net.ninho.ninhosawm.tags;

import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
//================================================= TOOL TIERS ===================================================
    public static final TagKey<Block> NEEDS_STEEL_TOOL = createBlockTag("needs_steel_tool");
    public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = createBlockTag("incorrect_for_steel_tool");
    public static final TagKey<Item> STEEL_REPAIRABLE = createItemTag("steel_repairable");
    public static final TagKey<Item> STEEL = createItemTag("steel");

//==================================================== Items =====================================================


//=================================================== Blocks =====================================================



//================================================================================================================

    private static TagKey<Block> createBlockTag(String name) {
        return BlockTags.create(Identifier.fromNamespaceAndPath(NinhosAwesomeMod.MOD_ID, name));
    }
    private static TagKey<Item> createItemTag(String name) {
        return ItemTags.create(Identifier.fromNamespaceAndPath(NinhosAwesomeMod.MOD_ID, name));
    }
}