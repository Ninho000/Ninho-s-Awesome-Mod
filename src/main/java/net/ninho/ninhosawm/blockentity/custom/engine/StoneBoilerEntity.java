package net.ninho.ninhosawm.blockentity.custom.engine;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.ninho.ninhosawm.block.ModBlocks;
import net.ninho.ninhosawm.blockentity.ModBlockEntities;

import java.util.Map;

public class StoneBoilerEntity extends BlockEntity {

    private static final int MAX_ENERGY = 1000;
    private static final int TICKS_PER_ENERGY = 20;
    // Fuel accepted by this machine and its duration in ticks
    private int getFuelDuration(ItemStack stack) {
        if (stack.is(ItemTags.LOGS)) return 300;
        if (stack.is(ItemTags.COALS)) return 1600;
        return 0;
    }
    private int energy = 0;
    private int tickCounter = 0;
    private int fuelTicks = 0;

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
        if (level.isClientSide()) return;                //Server only

        int water = engine.waterCount();                 //Water reservoirs count
        if (water <= 0) return;                          //No Water Source
        if (engine.energy >= MAX_ENERGY) return;         //Energy Full
        if (engine.fuelTicks <= 0 &&  engine.fuel.isEmpty() ) return; //Get out of Fuel

        if (engine.fuelTicks > 0) engine.fuelTicks--;    //Burns Item
        else {
            int duration = engine.getFuelDuration(engine.fuel); //Gets Fuel and Duration
            if (duration > 0) {                          //If it is a valid duration
                engine.fuelTicks = duration;             //Burn duration input
                engine.fuel.shrink(1);          //Remove the ITEM from SLOT
            }
        }
        engine.tickCounter++;
        if (engine.tickCounter >= TICKS_PER_ENERGY) {   //Clock
            engine.tickCounter = 0;                     //Reset Clock

            engine.energy = Math.min(MAX_ENERGY,        //Sum 1 energy per water source
                    engine.energy + water);

            engine.setChanged();                        //Save the Operation
        }
    }

    private int waterCount() {
        if (level == null) return 0;
        int count = 0;

        for (int i = 1; i <= 3; i++) {                      //Count Water Source until 3 above it
            BlockPos waterPos = worldPosition.above(i);     //Scan above 1 - 3 blocks

            if (level.getBlockState(waterPos).is(ModBlocks.COPPER_WATER_RESERVOIR.get())) count++;
            else  break;                                    //Count a Reservoir
        }
        return count;                                       //Return the "water level"
    }

    //Global stats return functions
    public int getEnergy() { return energy; }
    public int getMaxEnergy() { return MAX_ENERGY; }
    public ItemStack getFuel() { return fuel; }
    public boolean isActive() { return waterCount() > 0 && !fuel.isEmpty(); }
    public void setFuel(ItemStack stack) {      //Manual Fuel-Items giver
        fuel = stack; setChanged();
    }
}