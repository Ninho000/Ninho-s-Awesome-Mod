package net.ninho.ninhosawm.block.custom.machinetool;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
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

public class IronMiner extends HorizontalDirectionalBlock {

    public static final MapCodec<IronMiner> CODEC =
            simpleCodec(IronMiner::new);

    public IronMiner(Properties properties) {
        super(properties);

        registerDefaultState( stateDefinition.any()
                        .setValue(FACING, net.minecraft.core.Direction.NORTH)
        );
    }
    @Override
    protected MapCodec<? extends IronMiner> codec() { return CODEC; }
    @Override
    protected void createBlockStateDefinition(
            StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
    }
}