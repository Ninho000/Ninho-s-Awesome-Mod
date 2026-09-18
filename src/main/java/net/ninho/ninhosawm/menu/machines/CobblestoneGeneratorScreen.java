package net.ninho.ninhosawm.menu.machines;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.ninho.ninhosawm.NinhosAwesomeMod;

public class CobblestoneGeneratorScreen
        extends AbstractContainerScreen<CobblestoneGeneratorMenu> {

    private static final Identifier TEXTURE =
            Identifier.fromNamespaceAndPath(
                    NinhosAwesomeMod.MOD_ID,
                    "textures/gui/cobblestone_generator.png"
            );

    //Creates the interactable Screen of Menu and Inventory
    public CobblestoneGeneratorScreen(
            CobblestoneGeneratorMenu menu,
            Inventory playerInventory,
            Component title
    ) {
        super(menu, playerInventory, title);
    }

    //Function that reads the Mouse of the User
    @Override
    public void extractBackground(
            GuiGraphicsExtractor graphics,
            int mouseX,
            int mouseY,
            float partialTick
    ) {
        graphics.blit(
                RenderPipelines.GUI_TEXTURED,
                TEXTURE,
                this.leftPos,
                this.topPos,
                0,
                0,
                176,
                166,
                256,
                256
        );
        //super.extractBackground(graphics, mouseX, mouseY, partialTick);
    }
}