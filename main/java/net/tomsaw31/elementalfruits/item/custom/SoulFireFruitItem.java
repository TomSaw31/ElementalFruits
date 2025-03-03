package net.tomsaw31.elementalfruits.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.tomsaw31.elementalfruits.entity.custom.FireFruitProjectile;
import net.tomsaw31.elementalfruits.entity.custom.SoulFireFruitProjectile;
import net.tomsaw31.elementalfruits.item.ElementalFruitItem;

import javax.annotation.Nullable;

public class SoulFireFruitItem extends ElementalFruitItem {
    public SoulFireFruitItem(Properties properties) {
        super(properties);
    }


    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (!level.isClientSide) {
            livingEntity.setSecondsOnFire(4);
        }
        return super.finishUsingItem(itemStack, level, livingEntity);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        return useFruit(new SoulFireFruitProjectile(player.level(),player), SoundEvents.SNOWBALL_THROW,interactionHand,player);
    }
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 600;
    }
}
