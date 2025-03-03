package net.tomsaw31.elementalfruits.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.tomsaw31.elementalfruits.entity.ElementalFruitProjectile;
import net.tomsaw31.elementalfruits.item.ModItems;
import net.tomsaw31.elementalfruits.entity.ModEntities;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.LIT;

public class FireFruitProjectile extends ElementalFruitProjectile {
    public FireFruitProjectile(EntityType<? extends FireFruitProjectile> p_37391_, Level p_37392_) {
        super(p_37391_, p_37392_);
    }

    public FireFruitProjectile(Level p_37399_, LivingEntity p_37400_) {
        super(ModEntities.FIRE_FRUIT_PROJECTILE.get(), p_37400_, p_37399_);
    }

    public FireFruitProjectile(Level p_37394_, double p_37395_, double p_37396_, double p_37397_) {
        super(ModEntities.FIRE_FRUIT_PROJECTILE.get(), p_37395_, p_37396_, p_37397_, p_37394_);
    }

    protected Item getDefaultItem() {
        return ModItems.FIRE_FRUIT.get();
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

    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        if (!this.level().isClientSide) {
            Entity entity = entityHitResult.getEntity();
            Entity entity1 = this.getOwner();
            int i = entity.getRemainingFireTicks();
            entity.setSecondsOnFire(3);
            if (!entity.hurt(this.damageSources().generic(), 3.0F)) {
                entity.setRemainingFireTicks(i);
            } else if (entity1 instanceof LivingEntity) {
                this.doEnchantDamageEffects((LivingEntity)entity1, entity);
            }

        }
    }

    protected void onHit(HitResult hitResult) {
        if(this.level().isClientSide) {
            if (!hit) {
                spawnParticlesCircle(this.position(),ParticleTypes.FLAME);
            }
        }
        hit =true;
        super.onHit(hitResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
        }
    }

    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        if (!this.level().isClientSide) {
            Entity entity = this.getOwner();
            if (entity instanceof Player player) {
                BlockPos blockpos = blockHitResult.getBlockPos().relative(blockHitResult.getDirection());
                BlockState blockstate = this.level().getBlockState(blockpos);
                if (CampfireBlock.canLight(blockstate) || CandleBlock.canLight(blockstate) || CandleCakeBlock.canLight(blockstate)) {
                    this.level().playSound(player, blockpos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, this.level().getRandom().nextFloat() * 0.4F + 0.8F);
                    this.level().setBlock(blockpos, blockstate.setValue(LIT, Boolean.TRUE), 11);
                    this.level().gameEvent(player, GameEvent.BLOCK_CHANGE, blockpos);
                } else {
                    if (this.level().isEmptyBlock(blockpos)) {
                        this.level().setBlockAndUpdate(blockpos, BaseFireBlock.getState(this.level(), blockpos));
                    }
                }
            }
        }
    }
}