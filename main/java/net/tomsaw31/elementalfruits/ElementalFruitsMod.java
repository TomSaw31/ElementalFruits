package net.tomsaw31.elementalfruits;

import com.mojang.logging.LogUtils;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tomsaw31.elementalfruits.block.ModBlocks;
import net.tomsaw31.elementalfruits.block.entity.ModBlockEntities;
import net.tomsaw31.elementalfruits.effect.ModEffects;
import net.tomsaw31.elementalfruits.entity.ModEntities;
import net.tomsaw31.elementalfruits.entity.client.StoneSpearRenderer;
import net.tomsaw31.elementalfruits.entity.custom.*;
import net.tomsaw31.elementalfruits.item.ModCreativeModeTabs;
import net.tomsaw31.elementalfruits.item.ModItems;
import net.tomsaw31.elementalfruits.networking.ModMessages;
import net.tomsaw31.elementalfruits.particle.ModParticles;
import net.tomsaw31.elementalfruits.recipe.ModRecipes;
import net.tomsaw31.elementalfruits.screen.ModMenuTypes;
import net.tomsaw31.elementalfruits.screen.custom.FruitSynthesizerScreen;
import net.tomsaw31.elementalfruits.world.gen.ModWorldGeneration;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ElementalFruitsMod.MOD_ID)
public class ElementalFruitsMod
{
    public static final String MOD_ID = "elemental_fruits";
    private static final Logger LOGGER = LogUtils.getLogger();


    public ElementalFruitsMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModEntities.register(modEventBus);
        ModParticles.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModEffects.register(modEventBus);


        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        DispenserBlock.registerBehavior(ModItems.FIRE_FRUIT.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123476_, Position p_123477_, ItemStack p_123478_) {
                return (Projectile) Util.make(new FireFruitProjectile(p_123476_, p_123477_.x(), p_123477_.y(), p_123477_.z()), (p_123474_) -> {
                    p_123474_.setItem(p_123478_);
                });
            }
        });
        DispenserBlock.registerBehavior(ModItems.WATER_FRUIT.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123476_, Position p_123477_, ItemStack p_123478_) {
                return (Projectile) Util.make(new WaterFruitProjectile(p_123476_, p_123477_.x(), p_123477_.y(), p_123477_.z()), (p_123474_) -> {
                    p_123474_.setItem(p_123478_);
                });
            }
        });
        DispenserBlock.registerBehavior(ModItems.PLASMA_FRUIT.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123476_, Position p_123477_, ItemStack p_123478_) {
                return (Projectile) Util.make(new PlasmaFruitProjectile(p_123476_, p_123477_.x(), p_123477_.y(), p_123477_.z()), (p_123474_) -> {
                    p_123474_.setItem(p_123478_);
                });
            }
        });
        DispenserBlock.registerBehavior(ModItems.ELECTRO_FRUIT.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123476_, Position p_123477_, ItemStack p_123478_) {
                return (Projectile) Util.make(new ElectroFruitProjectile(p_123476_, p_123477_.x(), p_123477_.y(), p_123477_.z()), (p_123474_) -> {
                    p_123474_.setItem(p_123478_);
                });
            }
        });
        DispenserBlock.registerBehavior(ModItems.STEAM_FRUIT.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123476_, Position p_123477_, ItemStack p_123478_) {
                return (Projectile) Util.make(new SteamFruitProjectile(p_123476_, p_123477_.x(), p_123477_.y(), p_123477_.z()), (p_123474_) -> {
                    p_123474_.setItem(p_123478_);
                });
            }
        });
        DispenserBlock.registerBehavior(ModItems.WARPED_FRUIT.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123476_, Position p_123477_, ItemStack p_123478_) {
                return (Projectile) Util.make(new WarpedFruitProjectile(p_123476_, p_123477_.x(), p_123477_.y(), p_123477_.z()), (p_123474_) -> {
                    p_123474_.setItem(p_123478_);
                });
            }
        });
        DispenserBlock.registerBehavior(ModItems.CRIMSON_FRUIT.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123476_, Position p_123477_, ItemStack p_123478_) {
                return (Projectile) Util.make(new CrimsonFruitProjectile(p_123476_, p_123477_.x(), p_123477_.y(), p_123477_.z()), (p_123474_) -> {
                    p_123474_.setItem(p_123478_);
                });
            }
        });
        DispenserBlock.registerBehavior(ModItems.NETHER_FRUIT.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123476_, Position p_123477_, ItemStack p_123478_) {
                return (Projectile) Util.make(new NetherFruitProjectile(p_123476_, p_123477_.x(), p_123477_.y(), p_123477_.z()), (p_123474_) -> {
                    p_123474_.setItem(p_123478_);
                });
            }
        });
        DispenserBlock.registerBehavior(ModItems.SOUL_FIRE_FRUIT.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123476_, Position p_123477_, ItemStack p_123478_) {
                return (Projectile) Util.make(new SoulFireFruitProjectile(p_123476_, p_123477_.x(), p_123477_.y(), p_123477_.z()), (p_123474_) -> {
                    p_123474_.setItem(p_123478_);
                });
            }
        });
        DispenserBlock.registerBehavior(ModItems.STONE_FRUIT.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123476_, Position p_123477_, ItemStack p_123478_) {
                return (Projectile) Util.make(new StoneFruitProjectile(p_123476_, p_123477_.x(), p_123477_.y(), p_123477_.z()), (p_123474_) -> {
                    p_123474_.setItem(p_123478_);
                });
            }
        });
        DispenserBlock.registerBehavior(ModItems.SOUL_SAND_FRUIT.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123476_, Position p_123477_, ItemStack p_123478_) {
                return (Projectile) Util.make(new SoulSandFruitProjectile(p_123476_, p_123477_.x(), p_123477_.y(), p_123477_.z()), (p_123474_) -> {
                    p_123474_.setItem(p_123478_);
                });
            }
        });
        DispenserBlock.registerBehavior(ModItems.SAND_FRUIT.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123476_, Position p_123477_, ItemStack p_123478_) {
                return (Projectile) Util.make(new SandFruitProjectile(p_123476_, p_123477_.x(), p_123477_.y(), p_123477_.z()), (p_123474_) -> {
                    p_123474_.setItem(p_123478_);
                });
            }
        });
        event.enqueueWork(() -> {
            ModMessages.register();
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == ModCreativeModeTabs.ELEMENTAL_FRUITS_TAB.get()) {
            event.accept(ModItems.WATER_FRUIT);
            event.accept(ModItems.FIRE_FRUIT);
            event.accept(ModItems.ELECTRO_FRUIT);
            event.accept(ModItems.PLASMA_FRUIT);
            event.accept(ModItems.STEAM_FRUIT);
            event.accept(ModItems.WARPED_FRUIT);
            event.accept(ModItems.CRIMSON_FRUIT);
            event.accept(ModItems.NETHER_FRUIT);
            event.accept(ModItems.SOUL_FIRE_FRUIT);
            event.accept(ModItems.STONE_FRUIT);
            event.accept(ModItems.SAND_FRUIT);
            event.accept(ModItems.SOUL_SAND_FRUIT);
            event.accept(ModItems.SOUL_FRUIT);
        } else if(event.getTab() == ModCreativeModeTabs.ELEMENTAL_FRUITS_MISC_TAB.get()) {
            event.accept(ModItems.ELEMENTAL_SALAD);
            event.accept(ModBlocks.ELECTRO_GENERATOR);
            event.accept(ModBlocks.PLASMA_GENERATOR);
            event.accept(ModBlocks.WARPED_CAKE);
            event.accept(ModBlocks.CRIMSON_CAKE);
            event.accept(ModItems.DUALITY_STONE);
            event.accept(ModBlocks.SOUL_MAGMA_BLOCK);
            event.accept(ModItems.STONE_SPEAR);
            event.accept(ModBlocks.FRUIT_SYNTHESIZER);
        } else if(event.getTab() == ModCreativeModeTabs.ELEMENTAL_FRUITS_SEEDS_TAB.get()) {
            event.accept(ModItems.WATER_FRUIT_SEEDS);
            event.accept(ModItems.FIRE_FRUIT_SEEDS);
            event.accept(ModItems.ELECTRO_FRUIT_SEEDS);
            event.accept(ModItems.PLASMA_FRUIT_SEEDS);
            event.accept(ModItems.STEAM_FRUIT_SEEDS);
            event.accept(ModItems.WARPED_FRUIT_SEEDS);
            event.accept(ModItems.CRIMSON_FRUIT_SEEDS);
            event.accept(ModItems.NETHER_FRUIT_SEEDS);
            event.accept(ModItems.SOUL_FIRE_FRUIT_SEEDS);
            event.accept(ModItems.STONE_FRUIT_SEEDS);
            event.accept(ModItems.SAND_FRUIT_SEEDS);
            event.accept(ModItems.SOUL_SAND_FRUIT_SEEDS);
            event.accept(ModItems.SOUL_FRUIT_SEEDS);
        }
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.FIRE_FRUIT_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.WATER_FRUIT_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.ELECTRO_FRUIT_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.PLASMA_FRUIT_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.STEAM_FRUIT_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.CRIMSON_FRUIT_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.WARPED_FRUIT_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.NETHER_FRUIT_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.SOUL_FIRE_FRUIT_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.STONE_FRUIT_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.SAND_FRUIT_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.SOUL_SAND_FRUIT_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.STONE_SPEAR_PROJECTILE.get(), StoneSpearRenderer::new);
            MenuScreens.register(ModMenuTypes.FRUIT_SYNTHESIZER_MENU.get(), FruitSynthesizerScreen::new);

        }
    }
}
