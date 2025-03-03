package net.tomsaw31.elementalfruits.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tomsaw31.elementalfruits.ElementalFruitsMod;
import net.tomsaw31.elementalfruits.block.entity.ModBlockEntities;
import net.tomsaw31.elementalfruits.block.entity.renderer.FruitSynthesizerBlockEntityRenderer;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = ElementalFruitsMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.FRUIT_SYNTHESIZER.get(),
                    FruitSynthesizerBlockEntityRenderer::new);
        }
    }
}
