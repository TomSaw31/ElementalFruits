package net.tomsaw31.elementalfruits.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class AquaProtectionEffect extends MobEffect {
    public AquaProtectionEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.isInWaterRainOrBubble()) {
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 0, (false), (false)));
        }

    }
        @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
