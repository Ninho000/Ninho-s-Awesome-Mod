package net.ninho.ninhosawm.creativemodetab;

import net.minecraft.world.item.Items;
import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.ninho.ninhosawm.block.ModBlocks;
import net.ninho.ninhosawm.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NinhosAwesomeMod.MOD_ID);

    public static final Supplier<CreativeModeTab> TOOL_WEAPONS = CREATIVE_MODE_TABS.register("tool_weapons",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEEL_AXE.get()))
                    .title(Component.translatable("creativetab.ninhosawm.tool_weapons"))
                    .withTabsBefore(CreativeModeTabs.INGREDIENTS)
                    .displayItems((itemDisplayParameters, output) -> {

                        //============= Ingredients ===============
                        output.accept(ModItems.RAW_STEEL);
                        output.accept(ModItems.STEEL_INGOT);
                        //============= Steel Tier ===============
                        output.accept(ModItems.STEEL_PICKAXE);
                        output.accept(ModItems.STEEL_AXE);
                        output.accept(ModItems.STEEL_SHOVEL);
                        output.accept(ModItems.STEEL_HOE);

                    }).build());

    public static final Supplier<CreativeModeTab> MOUNTS = CREATIVE_MODE_TABS.register("mounts",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.WOLF_SPAWN_EGG))
                    .title(Component.translatable("creativetab.ninhosawm.mounts"))
                    .withTabsBefore(Identifier.fromNamespaceAndPath(NinhosAwesomeMod.MOD_ID, "tool_weapons"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.DODO_SPAWN_EGG);
                        output.accept(ModItems.NEBULA_SPAWN_EGG);

                    }).build());

    public static final Supplier<CreativeModeTab> MAGNIFICENT_MACHINES = CREATIVE_MODE_TABS.register("magnificent_machines",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CRAFTER_BLOCK.get()))
                    .title(Component.translatable("creativetab.ninhosawm.magnificent_machines"))
                    .withTabsBefore(Identifier.fromNamespaceAndPath(NinhosAwesomeMod.MOD_ID, "mounts"))
                    .displayItems((itemDisplayParameters, output) -> {

                        //============= ENGINES ===============
                        output.accept(ModBlocks.COPPER_WATER_RESERVOIR);
                        output.accept(ModBlocks.STONE_BOILER);

                        //============= TOOLS ===============
                        output.accept(ModBlocks.IRON_MINER);
                        output.accept(ModBlocks.DIAMOND_MINER);
                        output.accept(ModBlocks.NETHERITE_MINER);

                        //============= MACHINES ===============
                        output.accept(ModBlocks.COBBLESTONE_GENERATOR);

                        //============ INGREDIENTS =============
                        output.accept(ModBlocks.I_BEAM);

                    }).build());

    public static final Supplier<CreativeModeTab> BETTER_THAN_MINECRAFT = CREATIVE_MODE_TABS.register("better_than_minecraft",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.GRASS_STAIRS.get()))
                    .title(Component.translatable("creativetab.ninhosawm.better_than_minecraft"))
                    .withTabsBefore(Identifier.fromNamespaceAndPath(NinhosAwesomeMod.MOD_ID, "magnificent_machines"))
                    .displayItems((itemDisplayParameters, output) -> {

                        //Soil
                        output.accept(ModBlocks.GRASS_SLAB);
                        output.accept(ModBlocks.DIRT_SLAB);
                        output.accept(ModBlocks.COARSE_SLAB);
                        output.accept(ModBlocks.PATH_SLAB);
                        output.accept(ModBlocks.GRASS_STAIRS);
                        output.accept(ModBlocks.DIRT_STAIRS);
                        output.accept(ModBlocks.COARSE_STAIRS);
                        output.accept(ModBlocks.PATH_STAIRS);
                        //Minerals
                        output.accept(ModBlocks.CALCITE_SLAB);
                        output.accept(ModBlocks.CALCITE_STAIRS);
                        output.accept(ModBlocks.CALCITE_WALL);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}