package net.ninho.ninhosawm.blockentity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.ninho.ninhosawm.blockentity.ModBlockEntities;

public class StoneBoilerEntity extends BlockEntity implements Container {

    private static final int SLOT_COUNT = 5;
    private static final double PRODUCTION = 4.0;
    private static final int GENERATION_TIME = (int) Math.round(1200.0 / PRODUCTION);

    private final NonNullList<ItemStack> items =
            NonNullList.withSize(SLOT_COUNT, ItemStack.EMPTY);

    private int generationTimer = 0;

    public StoneBoilerEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.COBBLESTONE_GENERATOR_BE.get(), pos, state);
    }

    public void tick() {
        if (level == null || level.isClientSide()) {
            return;
        }

        if (isFull()) {
            generationTimer = 0;
            return;
        }

        generationTimer++;

        if (generationTimer >= GENERATION_TIME) {
            generationTimer = 0;
            generateCobblestone();
        }
    }

    private void generateCobblestone() {
        for (int i = 0; i < SLOT_COUNT; i++) {
            ItemStack stack = items.get(i);

            if (stack.isEmpty()) {
                items.set(i, new ItemStack(Items.COBBLESTONE));
                setChanged();
                return;
            }

            if (stack.is(Items.COBBLESTONE) && stack.getCount() < stack.getMaxStackSize()) {
                stack.grow(1);
                setChanged();
                return;
            }
        }
    }

    private boolean isFull() {
        for (ItemStack stack : items) {
            if (stack.isEmpty()) {
                return false;
            }

            if (stack.getCount() < stack.getMaxStackSize()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int getContainerSize() {
        return SLOT_COUNT;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : items) {
            if (!stack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getItem(int slot) {
        return items.get(slot);
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        ItemStack result = ContainerHelper.removeItem(items, slot, amount);

        if (!result.isEmpty()) {
            setChanged();
        }

        return result;
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        return ContainerHelper.takeItem(items, slot);
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        items.set(slot, stack);

        if (stack.getCount() > getMaxStackSize()) {
            stack.setCount(getMaxStackSize());
        }

        setChanged();
    }

    @Override
    public void clearContent() {
        items.clear();
        setChanged();
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        ContainerHelper.saveAllItems(output, items);
        output.putInt("GenerationTimer", generationTimer);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        ContainerHelper.loadAllItems(input, items);
        generationTimer = input.getIntOr("GenerationTimer", 0);
    }
    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }
}