package net.tomsaw31.elementalfruits.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.elementalfruits.ElementalFruitsMod;
import net.tomsaw31.elementalfruits.entity.custom.*;

public class ModEntities {
        public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ElementalFruitsMod.MOD_ID);

        public static final RegistryObject<EntityType<FireFruitProjectile>> FIRE_FRUIT_PROJECTILE =
                ENTITY_TYPES.register("fire_fruit",
                        () -> EntityType.Builder.<FireFruitProjectile>of(FireFruitProjectile::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                                .build(new ResourceLocation(ElementalFruitsMod.MOD_ID, "fire_fruit").toString()));

    public static final RegistryObject<EntityType<WaterFruitProjectile>> WATER_FRUIT_PROJECTILE =
            ENTITY_TYPES.register("water_fruit",
                    () -> EntityType.Builder.<WaterFruitProjectile>of(WaterFruitProjectile::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(new ResourceLocation(ElementalFruitsMod.MOD_ID, "water_fruit").toString()));

    public static final RegistryObject<EntityType<ElectroFruitProjectile>> ELECTRO_FRUIT_PROJECTILE =
            ENTITY_TYPES.register("electro_fruit",
                    () -> EntityType.Builder.<ElectroFruitProjectile>of(ElectroFruitProjectile::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(new ResourceLocation(ElementalFruitsMod.MOD_ID, "electro_fruit").toString()));

    public static final RegistryObject<EntityType<PlasmaFruitProjectile>> PLASMA_FRUIT_PROJECTILE =
            ENTITY_TYPES.register("plasma_fruit",
                    () -> EntityType.Builder.<PlasmaFruitProjectile>of(PlasmaFruitProjectile::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(new ResourceLocation(ElementalFruitsMod.MOD_ID, "plasma_fruit").toString()));

    public static final RegistryObject<EntityType<SteamFruitProjectile>> STEAM_FRUIT_PROJECTILE =
            ENTITY_TYPES.register("steam_fruit",
                    () -> EntityType.Builder.<SteamFruitProjectile>of(SteamFruitProjectile::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(new ResourceLocation(ElementalFruitsMod.MOD_ID, "steam_fruit").toString()));

    public static final RegistryObject<EntityType<CrimsonFruitProjectile>> CRIMSON_FRUIT_PROJECTILE =
            ENTITY_TYPES.register("crimson_fruit",
                    () -> EntityType.Builder.<CrimsonFruitProjectile>of(CrimsonFruitProjectile::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(new ResourceLocation(ElementalFruitsMod.MOD_ID, "crimson_fruit").toString()));

    public static final RegistryObject<EntityType<WarpedFruitProjectile>> WARPED_FRUIT_PROJECTILE =
            ENTITY_TYPES.register("warped_fruit",
                    () -> EntityType.Builder.<WarpedFruitProjectile>of(WarpedFruitProjectile::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(new ResourceLocation(ElementalFruitsMod.MOD_ID, "warped_fruit").toString()));

    public static final RegistryObject<EntityType<NetherFruitProjectile>> NETHER_FRUIT_PROJECTILE =
            ENTITY_TYPES.register("nether_fruit",
                    () -> EntityType.Builder.<NetherFruitProjectile>of(NetherFruitProjectile::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(new ResourceLocation(ElementalFruitsMod.MOD_ID, "nether_fruit").toString()));

    public static final RegistryObject<EntityType<SoulFireFruitProjectile>> SOUL_FIRE_FRUIT_PROJECTILE =
            ENTITY_TYPES.register("soul_fire_fruit",
                    () -> EntityType.Builder.<SoulFireFruitProjectile>of(SoulFireFruitProjectile::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(new ResourceLocation(ElementalFruitsMod.MOD_ID, "soul_fire_fruit").toString()));

    public static final RegistryObject<EntityType<StoneFruitProjectile>> STONE_FRUIT_PROJECTILE =
            ENTITY_TYPES.register("stone_fruit",
                    () -> EntityType.Builder.<StoneFruitProjectile>of(StoneFruitProjectile::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(new ResourceLocation(ElementalFruitsMod.MOD_ID, "stone_fruit").toString()));

    public static final RegistryObject<EntityType<SandFruitProjectile>> SAND_FRUIT_PROJECTILE =
            ENTITY_TYPES.register("sand_fruit",
                    () -> EntityType.Builder.<SandFruitProjectile>of(SandFruitProjectile::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(new ResourceLocation(ElementalFruitsMod.MOD_ID, "sand_fruit").toString()));

    public static final RegistryObject<EntityType<SoulSandFruitProjectile>> SOUL_SAND_FRUIT_PROJECTILE =
            ENTITY_TYPES.register("soul_sand_fruit",
                    () -> EntityType.Builder.<SoulSandFruitProjectile>of(SoulSandFruitProjectile::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(new ResourceLocation(ElementalFruitsMod.MOD_ID, "soul_sand_fruit").toString()));

    public static final RegistryObject<EntityType<StoneSpearProjectile>> STONE_SPEAR_PROJECTILE =
            ENTITY_TYPES.register("stone_spear",
                    () -> EntityType.Builder.<StoneSpearProjectile>of(StoneSpearProjectile::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(new ResourceLocation(ElementalFruitsMod.MOD_ID, "stone_spear").toString()));


    public static void register(IEventBus eventBus) {
            ENTITY_TYPES.register(eventBus);
        }

}