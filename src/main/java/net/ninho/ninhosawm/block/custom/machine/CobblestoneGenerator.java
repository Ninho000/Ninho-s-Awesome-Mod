package net.ninho.ninhosawm.block.custom.machine;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.ninho.ninhosawm.blockentity.ModBlockEntities;
import net.ninho.ninhosawm.blockentity.custom.CobblestoneGeneratorEntity;
import net.ninho.ninhosawm.function.DirectionalBaseEntityBlock;
import net.ninho.ninhosawm.menu.machines.CobblestoneGeneratorMenu;
import org.jetbrains.annotations.Nullable;

public class CobblestoneGenerator extends DirectionalBaseEntityBlock {
//====== Rotation and VoxelShape ======\\
    public static final MapCodec<CobblestoneGenerator> CODEC = simpleCodec(CobblestoneGenerator::new);
    private static final VoxelShape SHAPE_NS = Block.box(-14.0, 0.0, 0.0, 30.0, 14.0, 16.0);
    private static final VoxelShape SHAPE_EW = Block.box(0.0, 0.0, -14.0, 16.0, 14.0, 30.0);

    public CobblestoneGenerator(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);

        if (direction == Direction.NORTH || direction == Direction.SOUTH) {
            return SHAPE_NS;
        }

        return SHAPE_EW;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos worldPosition, BlockState blockState) {
        return new CobblestoneGeneratorEntity(worldPosition, blockState);
    }
    /*@Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CobblestoneGeneratorEntity(pos, state);
    }*/

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level level,
            BlockState state,
            BlockEntityType<T> type
    ) {
        return createTickerHelper(
                type,
                ModBlockEntities.COBBLESTONE_GENERATOR_BE.get(),
                (level1, pos, state1, blockEntity) -> blockEntity.tick()
        );
    }
    @Override
    protected InteractionResult useWithoutItem(
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            BlockHitResult hitResult
    ) {
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (!(blockEntity instanceof CobblestoneGeneratorEntity generator)) {
            return InteractionResult.PASS;
        }

        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.openMenu(new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.translatable("container.ninhosawm.cobblestone_generator");
                }

                @Override
                public AbstractContainerMenu createMenu(
                        int containerId,
                        Inventory playerInventory,
                        Player player
                ) {
                    return new CobblestoneGeneratorMenu(
                            containerId,
                            playerInventory,
                            generator
                    );
                }
            }, buffer -> buffer.writeBlockPos(pos));
        }

        return InteractionResult.CONSUME;
    }
}