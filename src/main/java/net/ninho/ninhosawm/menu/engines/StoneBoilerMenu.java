package net.ninho.ninhosawm.menu.engines;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.ninho.ninhosawm.blockentity.custom.StoneBoilerEntity;
import net.ninho.ninhosawm.function.customModMenu;
import net.ninho.ninhosawm.menu.ModMenuTypes;

public class StoneBoilerMenu extends customModMenu {
    private final StoneBoilerEntity blockEntity;

    //First builder direction the access to the blockEnt in "this position"
    public StoneBoilerMenu(
            int containerId,
            Inventory playerInventory,
            RegistryFriendlyByteBuf buffer) {

        this(containerId,playerInventory,
                (StoneBoilerEntity) playerInventory.player.
                        level().getBlockEntity(buffer.readBlockPos())
        );
    }
    //This one creates the Menu of this Entity
    public StoneBoilerMenu(
            int containerId,
            Inventory playerInventory,
            StoneBoilerEntity blockEntity) {
        super(ModMenuTypes.STONE_BOILER_MENU.get(), containerId);
        this.blockEntity = blockEntity;

        addSlot(new Slot(blockEntity, 0, 80, 50)); //adds fuel Slot
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