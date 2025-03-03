package net.tomsaw31.elementalfruits.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.elementalfruits.ElementalFruitsMod;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ElementalFruitsMod.MOD_ID);


    public static final RegistryObject<MobEffect> NETHER_RESISTANCE = MOB_EFFECTS.register("nether_resistance",
            () -> new NetherProtectionEffect(MobEffectCategory.BENEFICIAL, 3992525));
    public static final RegistryObject<MobEffect> AQUA_RESISTANCE = MOB_EFFECTS.register("aqua_resistance",
            () -> new AquaProtectionEffect(MobEffectCategory.BENEFICIAL, 3005050));
    public static final RegistryObject<MobEffect> ELECTRO_RESISTANCE = MOB_EFFECTS.register("electro_resistance",
            () -> new ElectroProtectionEffect(MobEffectCategory.BENEFICIAL, 3999900));
    public static final RegistryObject<MobEffect> WARPED_RESISTANCE = MOB_EFFECTS.register("warped_resistance",
            () -> new WarpedProtectionEffect(MobEffectCategory.NEUTRAL, 3402751));
    public static final RegistryObject<MobEffect> CRIMSON_RESISTANCE = MOB_EFFECTS.register("crimson_resistance",
            () -> new CrimsonProtectionEffect(MobEffectCategory.BENEFICIAL, 16262179));
    public static final RegistryObject<MobEffect> STUNNED = MOB_EFFECTS.register("stunned",
            () -> new BasicEffect(MobEffectCategory.NEUTRAL, 16185078).addAttributeModifier(Attributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", (double)-1F, AttributeModifier.Operation.MULTIPLY_TOTAL).addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "845DB27C-C624-495F-8C9F-6020A9A58B6B", 10, AttributeModifier.Operation.ADDITION));



    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
