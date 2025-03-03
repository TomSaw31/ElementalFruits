package net.tomsaw31.elementalfruits.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.tomsaw31.elementalfruits.effect.ModEffects;
import net.tomsaw31.elementalfruits.entity.custom.NetherFruitProjectile;
import net.tomsaw31.elementalfruits.entity.custom.SteamFruitProjectile;
import net.tomsaw31.elementalfruits.item.ElementalFruitItem;

public class NetherFruitItem extends ElementalFruitItem {
    public NetherFruitItem(Properties properties) {
        super(properties);
    }


    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if(!livingEntity.hasEffect(ModEffects.CRIMSON_RESISTANCE.get())) {
            if (!level.isClientSide) {
                livingEntity.addEffect(new MobEffectInstance(ModEffects.NETHER_RESISTANCE.get(), 600));
            }
        }
        return super.finishUsingItem(itemStack, level, livingEntity);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        return useFruit(new NetherFruitProjectile(player.level(),player), SoundEvents.SNOWBALL_THROW,interactionHand,player);
    }
}
