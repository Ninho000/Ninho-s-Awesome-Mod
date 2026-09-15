package net.ninho.ninhosawm.block.custom.engine;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.ninho.ninhosawm.blockentity.ModBlockEntities;
import net.ninho.ninhosawm.blockentity.custom.engine.StoneBoilerEntity;

import javax.annotation.Nullable;

public class StoneBoiler extends BaseEntityBlock {

    public static final MapCodec<StoneBoiler> CODEC =
            simpleCodec(StoneBoiler::new);

    public StoneBoiler(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends StoneBoiler> codec() {
        return CODEC;
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