package net.tomsaw31.elementalfruits.entity.custom;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.tomsaw31.elementalfruits.entity.ElementalFruitProjectile;
import net.tomsaw31.elementalfruits.entity.ModEntities;
import net.tomsaw31.elementalfruits.item.ModItems;
import net.tomsaw31.elementalfruits.particle.ModParticles;

public class ElectroFruitProjectile extends ElementalFruitProjectile {
    public ElectroFruitProjectile(EntityType<? extends ElectroFruitProjectile> p_37391_, Level p_37392_) {
        super(p_37391_, p_37392_);
    }

    public ElectroFruitProjectile(Level p_37399_, LivingEntity p_37400_) {
        super(ModEntities.ELECTRO_FRUIT_PROJECTILE.get(), p_37400_, p_37399_);
    }

    public ElectroFruitProjectile(Level p_37394_, double p_37395_, double p_37396_, double p_37397_) {
        super(ModEntities.ELECTRO_FRUIT_PROJECTILE.get(), p_37395_, p_37396_, p_37397_, p_37394_);
    }

    protected Item getDefaultItem() {
        return ModItems.ELECTRO_FRUIT.get();
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItem();
        return new ItemParticleOption(ParticleTypes.ITEM, itemstack);
    }

    public void handleEntityEvent(byte p_37402_) {
        if (p_37402_ == 3) {
            ParticleOptions particleoptions = this.getParticle();
            for(int i = 0; i < 8; ++i) {
                this.level().addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    protected void onHit(HitResult hitResult) {
        if(this.level().isClientSide) {
            if (!hit) {
                spawnSphere(5,ModParticles.ELECTRIC_PARTICLE.get(), hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z, 50);
                spawnParticlesCircle(this.position(),ModParticles.ELECTRIC_FRUIT_PARTICLE.get());
            }
        }
        hit=true;
        super.onHit(hitResult);
        if (!this.level().isClientSide) {
            applyElectricity();
            this.level().broadcastEntityEvent(this, (byte) 3);
        }
    }
    private void applyElectricity() {
        AABB aabb = this.getBoundingBox().inflate(10.0D, 10.0D, 10.0D);
        for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, aabb)) {
            double d0 = this.distanceToSqr(livingentity);
            if (d0 < 32.0D) {
                livingentity.hurt(damageSources().indirectMagic(this,this.getOwner()),3f);
                livingentity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,2,3));
            }
        }
    }
}