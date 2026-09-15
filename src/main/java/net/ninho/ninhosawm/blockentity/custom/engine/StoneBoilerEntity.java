package net.ninho.ninhosawm.blockentity.custom.engine;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.ninho.ninhosawm.block.ModBlocks;
import net.ninho.ninhosawm.blockentity.ModBlockEntities;

public class StoneBoilerEntity extends BlockEntity {

    private static final int MAX_ENERGY = 1000;
    private static final int TICKS_PER_ENERGY = 20;

    private int energy = 0;
    private int tickCounter = 0;

    // Fuel Slot
    private ItemStack fuel = ItemStack.EMPTY;

    public StoneBoilerEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STONE_BOILER.get(), pos, state);
    }

    public static void tick(
            net.minecraft.world.level.Level level,
            BlockPos pos,
            BlockState state,
            StoneBoilerEntity engine
    ) {
        if (level.isClientSide()) { return; }
        //water resevours count
        int water = engine.waterCount();

        if (water <= 0) {                   //No Water
            engine.tickCounter = 0;
            return;
        }
        if (engine.energy >= MAX_ENERGY) {  //Energy Full
            return;
        }
        if (engine.fuel.isEmpty()) {        //No Fuel
            engine.tickCounter = 0;
            return;
        }

        engine.tickCounter++;

        if (engine.tickCounter >= TICKS_PER_ENERGY) {   //Clock
            engine.tickCounter = 0;                     //Reset Clock

            engine.energy = Math.min(                   //Limits Energy earn to MAX
                    MAX_ENERGY,
                    engine.energy + water
            );

            engine.setChanged();
        }
    }

    private int waterCount() {
        if (level == null) { return 0; }

        int count = 0;

        for (int i = 1; i <= 3; i++) {                      //Count Water Source until 3 above it
            BlockPos waterPos = worldPosition.above(i);     //Scan above 1 - 3 blocks

            if (level.getBlockState(waterPos).is(ModBlocks.COPPER_WATER_RESERVOIR.get())) {
                count++;                                    //Count a Reservoir
            } else { break;}
        }
        return count;                                       //Return the "water level"
    }

    //Global stats return functions
    public int getEnergy() { return energy; }
    public int getMaxEnergy() { return MAX_ENERGY; }
    public ItemStack getFuel() { return fuel; }
    public boolean isActive() {
        return waterCount() > 0 && !fuel.isEmpty();
    }
    public void setFuel(ItemStack stack) {      //Manual Fuel-Items giver
        fuel = stack;
        setChanged();
    }
}