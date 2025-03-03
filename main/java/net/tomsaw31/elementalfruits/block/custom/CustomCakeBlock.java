package net.tomsaw31.elementalfruits.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CustomCakeBlock extends CakeBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected static final VoxelShape[] SHAPE_BY_BITE_N = new VoxelShape[]{Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(3.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(5.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(7.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(9.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(11.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(13.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D)};
    protected static final VoxelShape[] SHAPE_BY_BITE_S = new VoxelShape[]{Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(1.0D, 0.0D, 1.0D, 13.0D, 8.0D, 15.0D), Block.box(1.0D, 0.0D, 1.0D, 11.0D, 8.0D, 15.0D), Block.box(1.0D, 0.0D, 1.0D, 9.0D, 8.0D, 15.0D), Block.box(1.0D, 0.0D, 1.0D, 7.0D, 8.0D, 15.0D), Block.box(1.0D, 0.0D, 1.0D, 5.0D, 8.0D, 15.0D), Block.box(1.0D, 0.0D, 1.0D, 3.0D, 8.0D, 15.0D)};
    protected static final VoxelShape[] SHAPE_BY_BITE_E = new VoxelShape[]{Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(1.0D, 0.0D, 3.0D, 15.0D, 8.0D, 15.0D), Block.box(1.0D, 0.0D, 5.0D, 15.0D, 8.0D, 15.0D), Block.box(1.0D, 0.0D, 7.0D, 15.0D, 8.0D, 15.0D), Block.box(1.0D, 0.0D, 9.0D, 15.0D, 8.0D, 15.0D), Block.box(1.0D, 0.0D, 11.0D, 15.0D, 8.0D, 15.0D), Block.box(1.0D, 0.0D, 13.0D, 15.0D, 8.0D, 15.0D)};
    protected static final VoxelShape[] SHAPE_BY_BITE_W = new VoxelShape[]{Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 13.0D), Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 11.0D), Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 9.0D), Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 7.0D),Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 5.0D),Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 3.0D)};
    public CustomCakeBlock(Properties p_51184_) {
        super(p_51184_);
    }
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch ((Direction)pState.getValue(FACING)) {
            case NORTH:
            default:
                return SHAPE_BY_BITE_N[pState.getValue(BITES)];
            case SOUTH:
                return SHAPE_BY_BITE_S[pState.getValue(BITES)];
            case WEST:
                return SHAPE_BY_BITE_W[pState.getValue(BITES)];
            case EAST:
                return SHAPE_BY_BITE_E[pState.getValue(BITES)];
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }
    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }
    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING,BITES);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

}
