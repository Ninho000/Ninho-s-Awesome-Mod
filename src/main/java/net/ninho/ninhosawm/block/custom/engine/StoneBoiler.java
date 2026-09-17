package net.ninho.ninhosawm.block.custom.engine;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.ninho.ninhosawm.blockentity.ModBlockEntities;
import net.ninho.ninhosawm.blockentity.custom.engine.StoneBoilerEntity;
import net.ninho.ninhosawm.function.DirectionalBaseEntityBlock;

import javax.annotation.Nullable;

public class StoneBoiler extends DirectionalBaseEntityBlock {

    public static final MapCodec<StoneBoiler> CODEC =
            simpleCodec(StoneBoiler::new);

    public static final BooleanProperty ACTIVE =
            BooleanProperty.create("active");

    public StoneBoiler(Properties properties) {
        super(properties
                .lightLevel(state -> state.getValue(ACTIVE) ? 15 : 0)
        );

        registerDefaultState(
                stateDefinition.any()
                        .setValue(FACING, net.minecraft.core.Direction.NORTH)
                        .setValue(ACTIVE, false)
        );
    }
    @Override
    protected MapCodec<? extends StoneBoiler> codec() { return CODEC; }
    @Override
    protected void createBlockStateDefinition(
            StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {

        super.createBlockStateDefinition(builder);

        builder.add(ACTIVE);
    }
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StoneBoilerEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level level,
            BlockState state,
            BlockEntityType<T> type
    ) {
        return createTickerHelper(type,
                ModBlockEntities.STONE_BOILER.get(),
                StoneBoilerEntity::tick);
    }
}