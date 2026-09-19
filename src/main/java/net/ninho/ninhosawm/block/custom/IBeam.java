package net.ninho.ninhosawm.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class IBeam extends Block {
    public IBeam(Properties properties) {
        super(properties);
    }
    VoxelShape shape = Block.box( 3, 0, 5, 13, 16., 11);

    @Override
    public boolean isLadder(BlockState state, LevelReader level, BlockPos pos, LivingEntity entity) {
        return true;
    }
}