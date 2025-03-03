package net.tomsaw31.elementalfruits.event;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tomsaw31.elementalfruits.ElementalFruitsMod;
import net.tomsaw31.elementalfruits.effect.ModEffects;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = ElementalFruitsMod.MOD_ID)
    public static class ForgeEvents {
        @SubscribeEvent(priority= EventPriority.LOWEST)
        public static void onLivingJump(LivingEvent.LivingJumpEvent event) {
            if (event.getEntity().hasEffect(ModEffects.STUNNED.get()) && !event.getEntity().level().isClientSide) {
                event.getEntity().setDeltaMovement(0,0,0);
                event.getEntity().teleportTo(event.getEntity().position().x,event.getEntity().position().y,event.getEntity().position().z);
                event.getEntity().lerpMotion(0,0,0);
            }
        }
    }
}
