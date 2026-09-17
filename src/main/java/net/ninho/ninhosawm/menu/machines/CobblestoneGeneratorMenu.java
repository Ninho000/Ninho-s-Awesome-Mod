package net.ninho.ninhosawm.menu.machines;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.ninho.ninhosawm.blockentity.custom.CobblestoneGeneratorEntity;
import net.ninho.ninhosawm.function.customModMenu;
import net.ninho.ninhosawm.menu.ModMenuTypes;

public class CobblestoneGeneratorMenu extends AbstractContainerMenu {
    private final CobblestoneGeneratorEntity blockEntity;

    //First builder direction the acess to the blockEnt in "this position"
    public CobblestoneGeneratorMenu(
            int containerId,
            Inventory playerInventory,
            RegistryFriendlyByteBuf buffer) {

        this(containerId,playerInventory,
                (CobblestoneGeneratorEntity) playerInventory.player.
                        level().getBlockEntity(buffer.readBlockPos())
        );
    }
    //This one creates the Menu of this Entity
    public CobblestoneGeneratorMenu(
            int containerId,
            Inventory playerInventory,
            CobblestoneGeneratorEntity blockEntity) {
        super(ModMenuTypes.COBBLESTONE_GENERATOR_MENU.get(), containerId);
        this.blockEntity = blockEntity;

        for (int i = 0; i < 5; i++) {           //adds five slots on y:35
            addSlot(new Slot(blockEntity, i, 44 + i * 18, 35));
        }
        customModMenu.addPlayerInventory(this, playerInventory);
    }

    //Máx Distance to continue to use it
    @Override
    public boolean stillValid(Player player) {
        return blockEntity.getBlockPos().closerToCenterThan(
                player.position(),
                8.0
        );
    }
    //Function to Shift Move items
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }
}