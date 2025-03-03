package net.tomsaw31.elementalfruits.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.tomsaw31.elementalfruits.entity.custom.PlasmaFruitProjectile;
import net.tomsaw31.elementalfruits.item.ElementalFruitItem;
import net.tomsaw31.elementalfruits.particle.ModParticles;

import javax.annotation.Nullable;

public class PlasmaFruitItem extends ElementalFruitItem {
    public PlasmaFruitItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if(level.isClientSide) {
            spawnSphere(5,level,ModParticles.PLASMA_PARTICLE.get(), livingEntity.position().x, livingEntity.position().y,livingEntity.position().z, 50);
            spawnSphere(1,level,ModParticles.PLASMA_FRUIT_PARTICLE.get(), livingEntity.position().x, livingEntity.position().y,livingEntity.position().z, 25);
            for(int i = 0; i < 360; i++) {
                if(i % 20 == 0) {
                    level.addParticle(ModParticles.PLASMA_FRUIT_PARTICLE.get(), livingEntity.position().x, livingEntity.position().y,livingEntity.position().z,
                            Math.cos(i) * 0.15d, 0.15d, Math.sin(i) * 0.15d);
                }
            }}
        AABB aabb = new AABB(new BlockPos((int) livingEntity.position().x, (int) livingEntity.position().y, (int) livingEntity.position().z));
        aabb.inflate(10.0D, 10.0D, 10.0D);
        for(LivingEntity livingentity : level.getEntitiesOfClass(LivingEntity.class, aabb)) {
            double d0 = aabb.distanceToSqr(new Vec3((int) livingEntity.position().x, (int) livingEntity.position().y, (int) livingEntity.position().z));
            if (d0 < 32.0D) {
                livingentity.setSecondsOnFire(3);
                livingentity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,2,3));
            }
        }
        return super.finishUsingItem(itemStack, level, livingEntity);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        return useFruit(new PlasmaFruitProjectile(player.level(),player),SoundEvents.SNOWBALL_THROW,interactionHand,player);
    }

    public void spawnSphere(Integer radius,Level level,ParticleOptions particle,double centerX, double centerY, double centerZ, int numParticles) {
        double phi = Math.PI * (Math.sqrt(5.) - 1.);
        for(int i = 0; i < numParticles; i++) {
            Float y = 1 - (i / (float)(numParticles - 1)) * 2;
            double rad = Math.sqrt(1 - y * y);
            double theta = phi * i;
            double x = Math.cos(theta) * rad;
            double z = Math.sin(theta) * rad;

            level.addParticle(particle, x*radius+centerX, y*radius+centerY, z*radius+centerZ,0,0,0);
        }
    }
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 700;
    }
}


