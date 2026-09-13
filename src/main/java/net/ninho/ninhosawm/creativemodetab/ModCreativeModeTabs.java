package net.ninho.ninhosawm.creativemodetab;

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

    public static final Supplier<CreativeModeTab> MOD_PARTS = CREATIVE_MODE_TABS.register("mod_parts",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEEL_INGOT.get()))
                    .title(Component.translatable("creativetab.ninhosawm.mod_parts"))
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

    public static final Supplier<CreativeModeTab> CONTRAPTIONS = CREATIVE_MODE_TABS.register("contraptions",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CRAFTER_BLOCK.get()))
                    .title(Component.translatable("creativetab.ninhosawm.contraptions"))
                    .withTabsBefore(Identifier.fromNamespaceAndPath(NinhosAwesomeMod.MOD_ID, "mod_parts"))
                    .displayItems((itemDisplayParameters, output) -> {

                        //============= CRAFTERS ===============
                        output.accept(ModBlocks.CRAFTER_BLOCK);
                        output.accept(ModBlocks.COBBLESTONE_GENERATOR);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}