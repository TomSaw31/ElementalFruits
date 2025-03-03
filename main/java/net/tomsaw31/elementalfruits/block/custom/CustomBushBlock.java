package net.tomsaw31.elementalfruits.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.IPlantable;
import net.tomsaw31.elementalfruits.item.ModItems;

public class CustomBushBlock extends SweetBerryBushBlock implements IPlantable {
    public final Integer fruit_id;
    public CustomBushBlock(Integer fruit_id,Properties p_57249_) {
        super(p_57249_);
        this.fruit_id =fruit_id;
    }
    public ItemStack getCloneItemStack(BlockGetter p_57256_, BlockPos p_57257_, BlockState p_57258_) {
        return new ItemStack(getSeeds());
    }
    protected boolean mayPlaceOn(BlockState p_51042_, BlockGetter p_51043_, BlockPos p_51044_) {
        if(fruit_id==0 || fruit_id==1) {
            return p_51042_.is(BlockTags.SAND);
        }else {
            return p_51042_.is(BlockTags.DIRT);
        }
    }

    public Item getFruit() {
        switch (fruit_id) {
            case 1:
                return ModItems.PLASMA_FRUIT.get();
            default:
                return ModItems.ELECTRO_FRUIT.get();
        }
    }
    public Item getSeeds() {
        switch (fruit_id) {
            case 1:
                return ModItems.PLASMA_FRUIT_SEEDS.get();
            default:
                return ModItems.ELECTRO_FRUIT_SEEDS.get();
        }
    }

    public InteractionResult use(BlockState p_57275_, Level p_57276_, BlockPos p_57277_, Player p_57278_, InteractionHand p_57279_, BlockHitResult p_57280_) {
        int i = p_57275_.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && p_57278_.getItemInHand(p_57279_).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + p_57276_.random.nextInt(2);
            popResource(p_57276_, p_57277_, new ItemStack(getFruit(), j + (flag ? 1 : 0)));
            p_57276_.playSound((Player) null, p_57277_, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + p_57276_.random.nextFloat() * 0.4F);
            BlockState blockstate = p_57275_.setValue(AGE, Integer.valueOf(1));
            p_57276_.setBlock(p_57277_, blockstate, 2);
            p_57276_.gameEvent(GameEvent.BLOCK_CHANGE, p_57277_, GameEvent.Context.of(p_57278_, blockstate));
            return InteractionResult.sidedSuccess(p_57276_.isClientSide);
        } else {
            return super.use(p_57275_, p_57276_, p_57277_, p_57278_, p_57279_, p_57280_);
        }
    }
    }
