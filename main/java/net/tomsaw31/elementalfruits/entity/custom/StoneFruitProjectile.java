package net.tomsaw31.elementalfruits.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.tomsaw31.elementalfruits.effect.ModEffects;
import net.tomsaw31.elementalfruits.entity.ElementalFruitProjectile;
import net.tomsaw31.elementalfruits.entity.ModEntities;
import net.tomsaw31.elementalfruits.item.ModItems;

public class StoneFruitProjectile extends ElementalFruitProjectile {
    public StoneFruitProjectile(EntityType<? extends StoneFruitProjectile> p_37391_, Level p_37392_) {
        super(p_37391_, p_37392_);
    }

    public StoneFruitProjectile(Level p_37399_, LivingEntity p_37400_) {
        super(ModEntities.STONE_FRUIT_PROJECTILE.get(), p_37400_, p_37399_);
    }

    public StoneFruitProjectile(Level p_37394_, double p_37395_, double p_37396_, double p_37397_) {
        super(ModEntities.STONE_FRUIT_PROJECTILE.get(), p_37395_, p_37396_, p_37397_, p_37394_);
    }

    protected Item getDefaultItem() {
        return ModItems.STONE_FRUIT.get();
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

    @Override
    protected void onHit(HitResult p_37260_) {
        if (!hit) {
            if (!this.level().isClientSide) {
            AABB aabb = this.getBoundingBox().inflate(3.0D, 3.0D, 3.0D);
            for (LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, aabb)) {
                double d0 = this.distanceToSqr(livingentity);
                if (d0 < 32.0D) {
                            livingentity.addEffect(new MobEffectInstance(ModEffects.STUNNED.get(), 100));
                            livingentity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100,10,false,false));
                    }
                }
            } else {
                this.level().addParticle(ParticleTypes.EXPLOSION,this.position().x,this.position().y,this.position().z,0,0,0);
                this.level().playSound(this.getOwner(),new BlockPos((int) this.position().x, (int) this.position().y, (int) this.position().z), SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS,1f,1f/ (this.getOwner().level().getRandom().nextFloat() * 0.4F + 0.8F));
            }
        }
        hit = true;
        super.onHit(p_37260_);
        this.level().broadcastEntityEvent(this, (byte) 3);
    }
}