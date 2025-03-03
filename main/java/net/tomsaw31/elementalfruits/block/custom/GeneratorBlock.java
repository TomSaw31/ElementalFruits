package net.tomsaw31.elementalfruits.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.tomsaw31.elementalfruits.particle.ModParticles;

import static net.minecraft.world.level.block.DoublePlantBlock.HALF;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.POWERED;

public class GeneratorBlock extends Block {
    public final Integer type;

    public GeneratorBlock(Integer type, Properties p_49795_) {
        super(p_49795_);
        this.type = type;
    }

    public void onProjectileHit(Level level, BlockState state, BlockHitResult blockHitResult, Projectile projectile) {
        this.generateField(level, new Vec3i(blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ()));


    }

    public void generateField(Level level, Vec3i position) {
        switch (type) {
            case 0: {
                if (level.isClientSide) {
                    spawnSphere(5, level, ModParticles.ELECTRIC_PARTICLE.get(), position.getX(), position.getY(), position.getZ(), 50);
                    for (int i = 0; i < 360; i++) {
                        if (i % 20 == 0) {
                            level.addParticle(ModParticles.ELECTRIC_FRUIT_PARTICLE.get(), position.getX(), position.getY(), position.getZ(),
                                    Math.cos(i) * 0.15d, 0.15d, Math.sin(i) * 0.15d);
                        }
                    }
                }

                AABB aabb = new AABB(new BlockPos(position));
                aabb.inflate(10.0D, 10.0D, 10.0D);
                for (LivingEntity livingentity : level.getEntitiesOfClass(LivingEntity.class, aabb)) {
                    double d0 = aabb.distanceToSqr(new Vec3(position.getX(), position.getY(), position.getZ()));
                    if (d0 < 32.0D) {
                        livingentity.hurt(level.damageSources().magic(), 3.0F);
                        livingentity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 3));
                    }
                }
            }
            break;
            case 1:
            default:
                if (level.isClientSide) {
                    spawnSphere(5, level, ModParticles.PLASMA_PARTICLE.get(), position.getX(), position.getY(), position.getZ(), 50);
                    spawnSphere(1, level, ModParticles.PLASMA_FRUIT_PARTICLE.get(), position.getX(), position.getY(), position.getZ(), 25);
                    for (int i = 0; i < 360; i++) {
                        if (i % 20 == 0) {
                            level.addParticle(ModParticles.PLASMA_FRUIT_PARTICLE.get(), position.getX(), position.getY(), position.getZ(),
                                    Math.cos(i) * 0.15d, 0.15d, Math.sin(i) * 0.15d);
                        }
                    }
                }
                AABB aabb = new AABB(new BlockPos(position.getX(), position.getY(), position.getZ()));
                aabb.inflate(10.0D, 10.0D, 10.0D);
                for (LivingEntity livingentity : level.getEntitiesOfClass(LivingEntity.class, aabb)) {
                    double d0 = aabb.distanceToSqr(new Vec3((int) position.getX(), (int) position.getY(), (int) position.getZ()));
                    if (d0 < 32.0D) {
                        livingentity.setSecondsOnFire(3);
                        livingentity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 3));
                    }
                }
        }
    }

    public void spawnSphere(Integer radius, Level level, ParticleOptions particle, double centerX, double centerY, double centerZ, int numParticles) {
        double phi = Math.PI * (Math.sqrt(5.) - 1.);
        for (int i = 0; i < numParticles; i++) {
            Float y = 1 - (i / (float) (numParticles - 1)) * 2;
            double rad = Math.sqrt(1 - y * y);
            double theta = phi * i;
            double x = Math.cos(theta) * rad;
            double z = Math.sin(theta) * rad;

            level.addParticle(particle, x * radius + centerX, y * radius + centerY, z * radius + centerZ, 0, 0, 0);
        }
    }
}

