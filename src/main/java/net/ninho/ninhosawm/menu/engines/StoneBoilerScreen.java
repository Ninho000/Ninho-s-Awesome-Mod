package net.ninho.ninhosawm.menu.engines;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class StoneBoilerScreen extends AbstractContainerScreen<StoneBoilerMenu> {

    //Creates the interactable Screen of Menu and Inventory
    public StoneBoilerScreen(StoneBoilerMenu menu,
                             Inventory playerInventory,
                             Component title){
        super(menu, playerInventory, title);
    }

    //Function that reads the Mouse of the User
    @Override
    public void extractBackground(
            GuiGraphicsExtractor graphics,
            int mouseX, int mouseY,
            float partialTick){
        super.extractBackground(graphics, mouseX, mouseY, partialTick);
    }
}