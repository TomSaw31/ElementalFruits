package net.tomsaw31.elementalfruits.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.ForgeEventFactory;

public class ElectroProtectionEffect extends MobEffect {
    public ElectroProtectionEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.level().isThundering()) {
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 0, (false), (false)));
            pLivingEntity.setJumping(false);
        }
    }
        @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }



}
