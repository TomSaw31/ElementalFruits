package net.tomsaw31.elementalfruits.item;


import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.elementalfruits.ElementalFruitsMod;
import net.tomsaw31.elementalfruits.block.ModBlocks;
import net.tomsaw31.elementalfruits.item.custom.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ElementalFruitsMod.MOD_ID);

    public static final RegistryObject<Item> ELEMENTAL_SALAD = ITEMS.register("elemental_salad",
            () -> new BowlFoodItem((new Item.Properties()).stacksTo(1).food(ModFoods.ELEMENTAL_SALAD)));
    public static final RegistryObject<Item> STONE_SPEAR = ITEMS.register("stone_spear",
            () -> new StoneSpearItem((new Item.Properties()).durability(250)));
    public static final RegistryObject<Item> DUALITY_STONE = ITEMS.register("duality_stone",
            () -> new DualityStone(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> WATER_FRUIT = ITEMS.register("water_fruit",
            () -> new WaterFruitItem(new Item.Properties().food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> WATER_FRUIT_SEEDS = ITEMS.register("water_fruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.WATER_GRASS_BLOCK.get(), (new Item.Properties())));
    public static final RegistryObject<Item> FIRE_FRUIT = ITEMS.register("fire_fruit",
            () -> new FireFruitItem(new Item.Properties().food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> FIRE_FRUIT_SEEDS = ITEMS.register("fire_fruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.FIRE_BULB_BLOCK.get(), (new Item.Properties())));
    public static final RegistryObject<Item> ELECTRO_FRUIT = ITEMS.register("electro_fruit",
            () -> new ElectroFruitItem(new Item.Properties().food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> ELECTRO_FRUIT_SEEDS = ITEMS.register("electro_fruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.ELECTRO_BUSH_BLOCK.get(), (new Item.Properties())));
    public static final RegistryObject<Item> PLASMA_FRUIT = ITEMS.register("plasma_fruit",
            () -> new PlasmaFruitItem(new Item.Properties().food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> PLASMA_FRUIT_SEEDS = ITEMS.register("plasma_fruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.PLASMA_BUSH_BLOCK.get(), (new Item.Properties())));
    public static final RegistryObject<Item> STEAM_FRUIT = ITEMS.register("steam_fruit",
            () -> new SteamFruitItem(new Item.Properties().food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> STEAM_FRUIT_SEEDS = ITEMS.register("steam_fruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.STEAM_BULB_BLOCK.get(), (new Item.Properties())));
    public static final RegistryObject<Item> WARPED_FRUIT = ITEMS.register("warped_fruit",
            () -> new WarpedFruitItem(new Item.Properties().food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> WARPED_FRUIT_SEEDS = ITEMS.register("warped_fruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.WARPED_VINES_BLOCK.get(), (new Item.Properties())));
    public static final RegistryObject<Item> CRIMSON_FRUIT = ITEMS.register("crimson_fruit",
            () -> new CrimsonFruitItem(new Item.Properties().food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> CRIMSON_FRUIT_SEEDS = ITEMS.register("crimson_fruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CRIMSON_VINES_BLOCK.get(), (new Item.Properties())));
    public static final RegistryObject<Item> NETHER_FRUIT = ITEMS.register("nether_fruit",
            () -> new NetherFruitItem(new Item.Properties().food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> NETHER_FRUIT_SEEDS = ITEMS.register("nether_fruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.NETHER_VINES_BLOCK.get(), (new Item.Properties())));
    public static final RegistryObject<Item> SOUL_FIRE_FRUIT = ITEMS.register("soul_fire_fruit",
            () -> new SoulFireFruitItem(new Item.Properties().food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> SOUL_FIRE_FRUIT_SEEDS = ITEMS.register("soul_fire_fruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SOUL_FIRE_BULB_BLOCK.get(), (new Item.Properties())));
    public static final RegistryObject<Item> STONE_FRUIT = ITEMS.register("stone_fruit",
            () -> new StoneFruitItem(new Item.Properties().food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> STONE_FRUIT_SEEDS = ITEMS.register("stone_fruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.PLASMA_BUSH_BLOCK.get(), (new Item.Properties())));
    public static final RegistryObject<Item> SAND_FRUIT = ITEMS.register("sand_fruit",
            () -> new SandFruitItem(new Item.Properties().food(ModFoods.FRUIT)));
    public static final RegistryObject<Item>  SAND_FRUIT_SEEDS = ITEMS.register("sand_fruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.PLASMA_BUSH_BLOCK.get(), (new Item.Properties())));
    public static final RegistryObject<Item> SOUL_SAND_FRUIT = ITEMS.register("soul_sand_fruit",
            () -> new SoulSandFruitItem(new Item.Properties().food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> SOUL_SAND_FRUIT_SEEDS = ITEMS.register("soul_sand_fruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.PLASMA_BUSH_BLOCK.get(), (new Item.Properties())));
    public static final RegistryObject<Item> SOUL_FRUIT = ITEMS.register("soul_fruit",
            () -> new SoulFireFruitItem(new Item.Properties().food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> SOUL_FRUIT_SEEDS = ITEMS.register("soul_fruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.PLASMA_BUSH_BLOCK.get(), (new Item.Properties())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

