package net.tomsaw31.elementalfruits.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class ElementalFruitItem extends Item {
    public ElementalFruitItem(Properties properties) {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> useFruit(Projectile projectile, SoundEvent soundEvent,InteractionHand interactionHand, Player player) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        if (!player.isCrouching()) {
            player.startUsingItem(interactionHand);
        } else {
            player.level().playSound(null, player.getX(), player.getY(), player.getZ(), soundEvent, SoundSource.NEUTRAL, 0.5F, 0.4F / (player.level().getRandom().nextFloat() * 0.4F + 0.8F));
            if (!player.level().isClientSide) {
                projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.0F, 0.66F);
                player.level().addFreshEntity(projectile);
                player.getCooldowns().addCooldown(this, 15);
            }
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }
        }
        return InteractionResultHolder.success(itemstack);
    }
}