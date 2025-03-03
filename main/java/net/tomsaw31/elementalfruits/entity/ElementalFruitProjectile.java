package net.tomsaw31.elementalfruits.entity;

import net.minecraft.core.Position;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class ElementalFruitProjectile extends ThrowableItemProjectile {
    public Integer timer=1;
    public Boolean hit =false;
    public ElementalFruitProjectile(EntityType<? extends ThrowableItemProjectile> p_37442_, Level p_37443_) {
        super(p_37442_, p_37443_);
    }

    public ElementalFruitProjectile(EntityType<? extends ThrowableItemProjectile> p_37432_, double p_37433_, double p_37434_, double p_37435_, Level p_37436_) {
        super(p_37432_, p_37433_, p_37434_, p_37435_, p_37436_);
    }

    public ElementalFruitProjectile(EntityType<? extends ThrowableItemProjectile> p_37438_, LivingEntity p_37439_, Level p_37440_) {
        super(p_37438_, p_37439_, p_37440_);
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    @Override
    public void tick() {
        super.tick();
        if(hit) {
            if(timer<=0) {
                this.discard();
            } else {
                timer+=-1;
            }
        }

    }
    public void spawnSphere(Integer radius,ParticleOptions particle,double centerX, double centerY, double centerZ, int numParticles) {
        double phi = Math.PI * (Math.sqrt(5.) - 1.);
        for(int i = 0; i < numParticles; i++) {
            Float y = 1 - (i / (float)(numParticles - 1)) * 2;
            double rad = Math.sqrt(1 - y * y);
            double theta = phi * i;
            double x = Math.cos(theta) * rad;
            double z = Math.sin(theta) * rad;

            this.level().addParticle(particle, x*radius+centerX, y*radius+centerY, z*radius+centerZ,0,0,0);
        }
    }
    public void spawnParticlesCircle(Position position, ParticleOptions particleOptions) {
            for(int i = 0; i < 360; i++) {
                if(i % 20 == 0) {
                    this.level().addParticle(particleOptions,
                            position.x(), position.y(),position.z(),
                            Math.cos(i) * 0.15d, 0.15d, Math.sin(i) * 0.15d);
                }
            }
        }
    public void spawnParticlesCircleUpward(Position position, ParticleOptions particleOptions,Float size) {
        for(int i = 0; i < 360; i++) {
            if(i % 15 == 0) {
                this.level().addParticle(particleOptions,
                        position.x()+Math.cos(i)*size, position.y(),position.z()+Math.sin(i)*size,0
                        , 0.5d,0 );
            }
        }
    }
    public void spawnParticlesCircleDownward(Position position, ParticleOptions particleOptions,Float size) {
        for (int i = 0; i < 360; i++) {
            if (i % 15 == 0) {
                this.level().addParticle(particleOptions,
                        position.x() + Math.cos(i) * size, position.y()+2, position.z() + Math.sin(i) * size, 0
                        , -0.5d, 0);
            }
        }
    }
}
