package net.ninho.ninhosawm.item;

import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.ninho.ninhosawm.function.ToolTip;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NinhosAwesomeMod.MOD_ID);
//=============================================================================================================
//                                           Items and Components
//=============================================================================================================
    public static final DeferredItem<Item> RAW_STEEL = ITEMS.registerItem("raw_steel",
            properties -> new ToolTip(properties, "raw_steel"));
    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.registerItem("steel_ingot",
            properties -> new ToolTip(properties, "steel_ingot"));
    //Gears
    public static final DeferredItem<Item> BASIC_GEARS = ITEMS.registerItem("basic_gears",
            properties -> new ToolTip(properties, "basic_gears"));
    //Containers
    public static final DeferredItem<Item> FLUID_CONTAINER = ITEMS.registerItem("fluid_container",
            properties -> new ToolTip(properties, "fluid_container"));
    //Motors
    public static final DeferredItem<Item> BOILER = ITEMS.registerItem("boiler",
            properties -> new ToolTip(properties, "boiler"));
    //Machine Tools
    public static final DeferredItem<Item> IRON_DRILL = ITEMS.registerItem("iron_drill",
            properties -> new ToolTip(properties, "iron_drill"));
    //Storage-Types
    public static final DeferredItem<Item> BASIC_STORAGE = ITEMS.registerItem("basic_storage",
            properties -> new ToolTip(properties, "basic_storage"));

    //================================================= TOOLS =================================================
    public static final DeferredItem<Item> STEEL_PICKAXE = ITEMS.registerItem("steel_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolTiers.STEEL, 1, -2.8f)));
    public static final DeferredItem<Item> STEEL_SHOVEL = ITEMS.registerItem("steel_shovel",
            properties -> new ShovelItem(ModToolTiers.STEEL, 1.5f, -3.0f, properties));
    public static final DeferredItem<Item> STEEL_AXE = ITEMS.registerItem("steel_axe",
            properties -> new AxeItem(ModToolTiers.STEEL, 6, -3.2f, properties));
    public static final DeferredItem<Item> STEEL_HOE = ITEMS.registerItem("steel_hoe",
            properties -> new HoeItem(ModToolTiers.STEEL, 0, -3.0f, properties));

//=============================================================================================================
//                                         Mineable Factory Machinery
//=============================================================================================================

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}