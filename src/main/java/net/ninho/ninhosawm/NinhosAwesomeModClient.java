package net.ninho.ninhosawm;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.ninho.ninhosawm.entity.ModEntities;
import net.ninho.ninhosawm.entity.ModModelLayerLocations;
import net.ninho.ninhosawm.entity.dodo.DodoModel;
import net.ninho.ninhosawm.entity.dodo.DodoRenderer;
import net.ninho.ninhosawm.menu.ModMenuTypes;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = NinhosAwesomeMod.MOD_ID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = NinhosAwesomeMod.MOD_ID, value = Dist.CLIENT)
public class NinhosAwesomeModClient {
    public NinhosAwesomeModClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        //ModKeyMappings.register();
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntities.DODO.get(), DodoRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayerLocations.DODO, DodoModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        //event.register(ModMenuTypes.PEDESTAL_MENU.get(), PedestalScreen::new);
    }
}