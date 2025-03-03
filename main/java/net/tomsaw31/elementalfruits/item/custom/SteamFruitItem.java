package net.tomsaw31.elementalfruits.item.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.tomsaw31.elementalfruits.entity.custom.FireFruitProjectile;
import net.tomsaw31.elementalfruits.entity.custom.SteamFruitProjectile;
import net.tomsaw31.elementalfruits.item.ElementalFruitItem;
import net.tomsaw31.elementalfruits.particle.ModParticles;

public class SteamFruitItem extends ElementalFruitItem {
    public SteamFruitItem(Properties properties) {
        super(properties);
    }


    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if(level.isClientSide) {
            for (int i = 0; i < 360; i++) {
                if (i % 20 == 0) {
                    level.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,
                            livingEntity.position().x, livingEntity.position().y, livingEntity.position().z,
                            Math.cos(i) * 0.15d, 0.25d, Math.sin(i) * 0.15d);
                }
            }
        }
        if(!livingEntity.hasEffect(MobEffects.LEVITATION)) {
            if (!level.isClientSide) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100));
            }
        }
        return super.finishUsingItem(itemStack, level, livingEntity);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        return useFruit(new SteamFruitProjectile(player.level(),player), SoundEvents.SNOWBALL_THROW,interactionHand,player);
    }
}
