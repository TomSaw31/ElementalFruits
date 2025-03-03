package net.tomsaw31.elementalfruits.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.registries.ForgeRegistries;

public class WarpedProtectionEffect extends MobEffect {
    public WarpedProtectionEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if ((pLivingEntity.level().getBiome((new BlockPos((int) pLivingEntity.position().x, (int) pLivingEntity.position().y, (int) pLivingEntity.position().z))).is(new ResourceLocation("warped_forest")))) {
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 1, (false), (false)));
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 0, (false), (false)));
        }
    }
        @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }



}
