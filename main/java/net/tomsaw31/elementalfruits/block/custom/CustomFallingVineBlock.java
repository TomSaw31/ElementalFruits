package net.tomsaw31.elementalfruits.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tomsaw31.elementalfruits.item.ModItems;

import javax.annotation.Nullable;

public class CustomFallingVineBlock extends Block implements BonemealableBlock, SimpleWaterloggedBlock {
    public final Integer fruit_id;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape SAPLING_SHAPE = Block.box(3.0D, 8.D, 3.0D, 13.0D, 16D, 13.0D);
    private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public CustomFallingVineBlock(Integer fruit_id,BlockBehaviour.Properties p_153337_) {
        super(p_153337_);
        this.fruit_id =fruit_id;
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    public Item getFruit() {
        switch (fruit_id) {
            case 1:
                return ModItems.NETHER_FRUIT.get();
            default:
                return ModItems.CRIMSON_FRUIT.get();
        }
    }
    public Item getSeeds() {
        switch (fruit_id) {
            case 1:
                return ModItems.NETHER_FRUIT_SEEDS.get();
            default:
                return ModItems.CRIMSON_FRUIT_SEEDS.get();
        }
    }
    public ItemStack getCloneItemStack(BlockGetter p_57256_, BlockPos p_57257_, BlockState p_57258_) {
        return new ItemStack(getSeeds());
    }
    public VoxelShape getShape(BlockState p_57291_, BlockGetter p_57292_, BlockPos p_57293_, CollisionContext p_57294_) {
        if (p_57291_.getValue(AGE) == 0) {
            return SAPLING_SHAPE;
        } else {
            return p_57291_.getValue(AGE) < 3 ? MID_GROWTH_SHAPE : super.getShape(p_57291_, p_57292_, p_57293_, p_57294_);
        }
    }


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_153358_) {
        p_153358_.add(WATERLOGGED,AGE);
    }
    public boolean isRandomlyTicking(BlockState p_57284_) {
        return p_57284_.getValue(AGE) < 3;
    }

    public void randomTick(BlockState p_222563_, ServerLevel p_222564_, BlockPos p_222565_, RandomSource p_222566_) {
        int i = p_222563_.getValue(AGE);
        if (i < 3 && p_222564_.getRawBrightness(p_222565_.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(p_222564_, p_222565_, p_222563_, p_222566_.nextInt(5) == 0)) {
            BlockState blockstate = p_222563_.setValue(AGE, Integer.valueOf(i + 1));
            p_222564_.setBlock(p_222565_, blockstate, 2);
            p_222564_.gameEvent(GameEvent.BLOCK_CHANGE, p_222565_, GameEvent.Context.of(blockstate));
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(p_222564_, p_222565_, p_222563_);
        }

    }

    public InteractionResult use(BlockState p_57275_, Level p_57276_, BlockPos p_57277_, Player p_57278_, InteractionHand p_57279_, BlockHitResult p_57280_) {
        int i = p_57275_.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && p_57278_.getItemInHand(p_57279_).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 2) {
            popResource(p_57276_, p_57277_, new ItemStack(getFruit(),1));
            p_57276_.playSound((Player)null, p_57277_, SoundEvents.WEEPING_VINES_PLACE, SoundSource.BLOCKS, 1.0F, 0.8F + p_57276_.random.nextFloat() * 0.4F);
            BlockState blockstate = p_57275_.setValue(AGE, Integer.valueOf(1));
            p_57276_.setBlock(p_57277_, blockstate, 2);
            p_57276_.gameEvent(GameEvent.BLOCK_CHANGE, p_57277_, GameEvent.Context.of(p_57278_, blockstate));
            return InteractionResult.sidedSuccess(p_57276_.isClientSide);
        } else {
            return super.use(p_57275_, p_57276_, p_57277_, p_57278_, p_57279_, p_57280_);
        }
    }

    public boolean isValidBonemealTarget(LevelReader p_256056_, BlockPos p_57261_, BlockState p_57262_, boolean p_57263_) {
        return p_57262_.getValue(AGE) < 3;
    }

    public boolean isBonemealSuccess(Level p_222558_, RandomSource p_222559_, BlockPos p_222560_, BlockState p_222561_) {
        return true;
    }

    public void performBonemeal(ServerLevel p_222553_, RandomSource p_222554_, BlockPos p_222555_, BlockState p_222556_) {
        int i = Math.min(3, p_222556_.getValue(AGE) + 1);
        p_222553_.setBlock(p_222555_, p_222556_.setValue(AGE, Integer.valueOf(i)), 2);
    }

    public FluidState getFluidState(BlockState p_153360_) {
        return p_153360_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_153360_);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_153340_) {
        BlockState blockstate = super.getStateForPlacement(p_153340_);
        if (blockstate != null) {
            FluidState fluidstate = p_153340_.getLevel().getFluidState(p_153340_.getClickedPos());
            return blockstate.setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
        } else {
            return null;
        }
    }

    public boolean canSurvive(BlockState p_153347_, LevelReader p_153348_, BlockPos p_153349_) {
        BlockPos blockpos = p_153349_.above();
        BlockState blockstate = p_153348_.getBlockState(blockpos);
        return blockstate.isFaceSturdy(p_153348_, blockpos, Direction.DOWN);
    }


    public BlockState updateShape(BlockState p_153351_, Direction p_153352_, BlockState p_153353_, LevelAccessor p_153354_, BlockPos p_153355_, BlockPos p_153356_) {
        if (p_153352_ == Direction.UP && !this.canSurvive(p_153351_, p_153354_, p_153355_)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            if (p_153351_.getValue(WATERLOGGED)) {
                p_153354_.scheduleTick(p_153355_, Fluids.WATER, Fluids.WATER.getTickDelay(p_153354_));
            }

            return super.updateShape(p_153351_, p_153352_, p_153353_, p_153354_, p_153355_, p_153356_);
        }
    }
}