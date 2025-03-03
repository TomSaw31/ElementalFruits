package net.tomsaw31.elementalfruits.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.elementalfruits.ElementalFruitsMod;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ElementalFruitsMod.MOD_ID);

    public static final RegistryObject<SimpleParticleType> WATER_PARTICLE =
            PARTICLE_TYPES.register("water_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> ELECTRIC_PARTICLE =
            PARTICLE_TYPES.register("electric_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> ELECTRIC_FRUIT_PARTICLE =
            PARTICLE_TYPES.register("electric_fruit_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> PLASMA_PARTICLE =
            PARTICLE_TYPES.register("plasma_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> PLASMA_FRUIT_PARTICLE =
            PARTICLE_TYPES.register("plasma_fruit_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> WARPED_PARTICLE =
            PARTICLE_TYPES.register("warped_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> CRIMSON_PARTICLE =
            PARTICLE_TYPES.register("crimson_particle", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}