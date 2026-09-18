package net.ninho.ninhosawm.menu;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.ninho.ninhosawm.menu.engines.StoneBoilerMenu;
import net.ninho.ninhosawm.menu.machines.CobblestoneGeneratorMenu;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, NinhosAwesomeMod.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<StoneBoilerMenu>> STONE_BOILER_MENU =
            MENUS.register("stone_boiler_menu",
                    () -> IMenuTypeExtension.create(StoneBoilerMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<CobblestoneGeneratorMenu>> COBBLESTONE_GENERATOR_MENU =
            MENUS.register("cobblestone_generator_menu",
                    () -> IMenuTypeExtension.create(CobblestoneGeneratorMenu::new));

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}