package net.ninho.ninhosawm.block.custom.machinetool;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class DiamondMiner extends HorizontalDirectionalBlock {

    public static final MapCodec<DiamondMiner> CODEC =
            simpleCodec(DiamondMiner::new);

    public DiamondMiner(Properties properties) {
        super(properties);

        registerDefaultState( stateDefinition.any()
                        .setValue(FACING, net.minecraft.core.Direction.NORTH)
        );
    }
    @Override
    protected MapCodec<? extends DiamondMiner> codec() { return CODEC; }
    @Override
    protected void createBlockStateDefinition(
            StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
    }
}