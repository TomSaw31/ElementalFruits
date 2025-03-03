package net.tomsaw31.elementalfruits.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractCandleBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.tomsaw31.elementalfruits.entity.ElementalFruitProjectile;
import net.tomsaw31.elementalfruits.item.ModItems;
import net.tomsaw31.elementalfruits.entity.ModEntities;
import net.tomsaw31.elementalfruits.particle.ModParticles;

import static net.minecraft.world.entity.projectile.ThrownPotion.WATER_SENSITIVE_OR_ON_FIRE;

public class WaterFruitProjectile extends ElementalFruitProjectile {
    public WaterFruitProjectile(EntityType<? extends WaterFruitProjectile> p_37391_, Level p_37392_) {
        super(p_37391_, p_37392_);
    }

    public WaterFruitProjectile(Level p_37399_, LivingEntity p_37400_) {
        super(ModEntities.WATER_FRUIT_PROJECTILE.get(), p_37400_, p_37399_);
    }

    public WaterFruitProjectile(Level p_37394_, double p_37395_, double p_37396_, double p_37397_) {
        super(ModEntities.WATER_FRUIT_PROJECTILE.get(), p_37395_, p_37396_, p_37397_, p_37394_);
    }

    protected Item getDefaultItem() {
        return ModItems.WATER_FRUIT.get();
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
                spawnParticlesCircle(this.position(),ModParticles.WATER_PARTICLE.get());
            }
        }
        hit =true;
        super.onHit(hitResult);
        if (!this.level().isClientSide) {
            applyWater();
            this.level().broadcastEntityEvent(this, (byte)3);
        }
    }

    private void applyWater() {
        AABB aabb = this.getBoundingBox().inflate(5.0D, 5.0D, 5.0D);
        for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, aabb, WATER_SENSITIVE_OR_ON_FIRE)) {
            double d0 = this.distanceToSqr(livingentity);
            if (d0 < 16.0D) {
                if (livingentity.isSensitiveToWater()) {
                    livingentity.hurt(this.damageSources().indirectMagic(this, this.getOwner()), 4.0F);
                }

                if (livingentity.isOnFire() && livingentity.isAlive()) {
                    livingentity.extinguishFire();
                }
            }
        }

        for(Axolotl axolotl : this.level().getEntitiesOfClass(Axolotl.class, aabb)) {
            axolotl.rehydrate();
        }
    }


    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        Direction direction = blockHitResult.getDirection();
        BlockPos blockpos = blockHitResult.getBlockPos();
        BlockPos blockpos1 = blockpos.relative(direction);
        this.dowseFire(blockpos1);
        this.dowseFire(blockpos1.relative(direction.getOpposite()));

        for(Direction direction1 : Direction.Plane.HORIZONTAL) {
            this.dowseFire(blockpos1.relative(direction1));
        }
    }

        private void dowseFire(BlockPos p_150193_) {
            BlockState blockstate = this.level().getBlockState(p_150193_);
            if (blockstate.is(BlockTags.FIRE)) {
                this.level().removeBlock(p_150193_, false);
            } else if (AbstractCandleBlock.isLit(blockstate)) {
                AbstractCandleBlock.extinguish((Player)null, blockstate, this.level(), p_150193_);
            } else if (CampfireBlock.isLitCampfire(blockstate)) {
                this.level().levelEvent((Player)null, 1009, p_150193_, 0);
                CampfireBlock.dowse(this.getOwner(), this.level(), p_150193_, blockstate);
                this.level().setBlockAndUpdate(p_150193_, blockstate.setValue(CampfireBlock.LIT, Boolean.valueOf(false)));
            }

        }
}