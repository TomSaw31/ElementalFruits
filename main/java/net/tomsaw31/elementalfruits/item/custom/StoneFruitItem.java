package net.tomsaw31.elementalfruits.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.tomsaw31.elementalfruits.effect.ModEffects;
import net.tomsaw31.elementalfruits.entity.custom.StoneFruitProjectile;
import net.tomsaw31.elementalfruits.entity.custom.WarpedFruitProjectile;
import net.tomsaw31.elementalfruits.item.ElementalFruitItem;

public class StoneFruitItem extends ElementalFruitItem {
    public StoneFruitItem(Properties properties) {
        super(properties);
    }


    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
            if (!level.isClientSide) {
                livingEntity.addEffect(new MobEffectInstance(ModEffects.STUNNED.get(), 100));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100,10,false,false));
            }
        return super.finishUsingItem(itemStack, level, livingEntity);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        return useFruit(new StoneFruitProjectile(player.level(),player), SoundEvents.SNOWBALL_THROW,interactionHand,player);
    }
}
