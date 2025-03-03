package net.tomsaw31.elementalfruits.item.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.tomsaw31.elementalfruits.entity.custom.WaterFruitProjectile;
import net.tomsaw31.elementalfruits.item.ElementalFruitItem;

import java.util.ArrayList;
import java.util.List;

public class WaterFruitItem extends ElementalFruitItem {
    public WaterFruitItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        livingEntity.extinguishFire();

        return super.finishUsingItem(itemStack, level, livingEntity);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        return useFruit(new WaterFruitProjectile(player.level(), player), SoundEvents.SNOWBALL_THROW, interactionHand, player);
    }
}
