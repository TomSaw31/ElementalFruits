package net.tomsaw31.elementalfruits.item.custom;

import net.minecraft.core.Position;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.tomsaw31.elementalfruits.item.ModItems;

public class DualityStone extends Item {
    private Integer state=0;
    public DualityStone(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean b) {
        if(!level.isClientSide && entity instanceof Player player ) {
            if(player.getInventory().countItem(ModItems.DUALITY_STONE.get())==1) {
                if (state == 1) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 0,false,true));
                    player.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 20, 0,false,true));
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0,false,true));
                    player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20, 0,false,true));
                } else {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 0,false,true));
                    player.addEffect(new MobEffectInstance(MobEffects.LUCK, 20, 0,false,true));
                    player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 0,false,true));
                    player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 20, 0,false,true));
                }
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if(level.isClientSide) {
            if (player.getInventory().countItem(ModItems.DUALITY_STONE.get()) == 1) {
                player.getCooldowns().addCooldown(ModItems.DUALITY_STONE.get(), 20);
                if (state == 1) {
                    state = 0;
                    spawnParticlesCircle(level, player.position(), ParticleTypes.SOUL_FIRE_FLAME);

                } else if (state == 0) {
                    state = 1;
                    spawnParticlesCircle(level, player.position(), ParticleTypes.FLAME);
                }
            }
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        player.swing(interactionHand, true);
        return super.use(level, player, interactionHand);
    }

    public void spawnParticlesCircle(Level level,Position position, ParticleOptions particleOptions) {
        for(int i = 0; i < 360; i++) {
            if(i % 20 == 0) {
                level.addParticle(particleOptions,
                        position.x(), position.y(),position.z(),
                        Math.cos(i) * 0.15d, 0.15d, Math.sin(i) * 0.15d);
            }
        }
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return true;
    }
}
