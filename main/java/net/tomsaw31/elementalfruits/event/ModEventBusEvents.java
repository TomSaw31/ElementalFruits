package net.tomsaw31.elementalfruits.event;

import net.minecraft.client.Minecraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tomsaw31.elementalfruits.ElementalFruitsMod;
import net.tomsaw31.elementalfruits.particle.ModParticles;
import net.tomsaw31.elementalfruits.particle.custom.*;
import net.tomsaw31.elementalfruits.world.ModWorldGenProvider;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ElementalFruitsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
        @SubscribeEvent
        public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
            Minecraft.getInstance().particleEngine.register(ModParticles.ELECTRIC_PARTICLE.get(),
                    ElectricParticle.Provider::new);
            Minecraft.getInstance().particleEngine.register(ModParticles.ELECTRIC_FRUIT_PARTICLE.get(),
                    ElectricFruitParticle.Provider::new);
            Minecraft.getInstance().particleEngine.register(ModParticles.PLASMA_PARTICLE.get(),
                    PlasmaParticle.Provider::new);
            Minecraft.getInstance().particleEngine.register(ModParticles.PLASMA_FRUIT_PARTICLE.get(),
                    PlasmaFruitParticle.Provider::new);
            Minecraft.getInstance().particleEngine.register(ModParticles.WATER_PARTICLE.get(),
                    WaterParticle.Provider::new);
            Minecraft.getInstance().particleEngine.register(ModParticles.CRIMSON_PARTICLE.get(),
                    CrimsonParticle.Provider::new);
            Minecraft.getInstance().particleEngine.register(ModParticles.WARPED_PARTICLE.get(),
                    WarpedParticle.Provider::new);
        }
}
