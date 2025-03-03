package net.tomsaw31.elementalfruits.block;

import net.minecraft.client.resources.model.Material;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MagmaBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.elementalfruits.ElementalFruitsMod;
import net.tomsaw31.elementalfruits.block.custom.*;
import net.tomsaw31.elementalfruits.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ElementalFruitsMod.MOD_ID);


    public static final RegistryObject<Block> FRUIT_SYNTHESIZER = registerBlock("fruit_synthesizer",
            () -> new FruitSynthesizerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6f).requiresCorrectToolForDrops().noOcclusion()));

   public static final RegistryObject<Block> CRIMSON_CAKE = registerBlock("crimson_cake",
            () -> new CustomCakeBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WARPED_CAKE = registerBlock("warped_cake",
            () -> new CustomCakeBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ELECTRO_GENERATOR = registerBlock("electro_generator",
            () -> new GeneratorBlock(0,BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6f).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PLASMA_GENERATOR = registerBlock("plasma_generator",
            () -> new GeneratorBlock(1,BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6f).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> SOUL_MAGMA_BLOCK = registerBlock("soul_magma_block",
            () -> new MagmaBlock(BlockBehaviour.Properties.copy(Blocks.MAGMA_BLOCK).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> ELECTRO_BUSH_BLOCK = registerBlockWithoutBlockItem("electro_bush_block",
            () -> new CustomBushBlock(0,BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PLASMA_BUSH_BLOCK = registerBlockWithoutBlockItem("plasma_bush_block",
            () -> new CustomBushBlock(1,BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CRIMSON_VINES_BLOCK = registerBlockWithoutBlockItem("crimson_vines_block",
            () -> new CustomFallingVineBlock(0,BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.WEEPING_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> NETHER_VINES_BLOCK = registerBlockWithoutBlockItem("nether_vines_block",
            () -> new CustomFallingVineBlock(1,BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.WEEPING_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WARPED_VINES_BLOCK = registerBlockWithoutBlockItem("warped_vines_block",
            () -> new CustomVineBlock(0,BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.TWISTING_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> FIRE_BULB_BLOCK = registerBlockWithoutBlockItem("fire_bulb_block",
            () -> new CustomBulbBlock(0,BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> STEAM_BULB_BLOCK = registerBlockWithoutBlockItem("steam_bulb_block",
            () -> new CustomBulbBlock(1,BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SOUL_FIRE_BULB_BLOCK = registerBlockWithoutBlockItem("soul_fire_bulb_block",
            () -> new CustomBulbBlock(2,BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WATER_GRASS_BLOCK = registerBlockWithoutBlockItem("water_grass_block",
            () -> new CustomAlgaeBlock(0,BlockBehaviour.Properties.of().mapColor(MapColor.WATER ).randomTicks().noCollission().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> ToReturn = BLOCKS.register(name, block);
        registerBlockItem(name, ToReturn);
        return ToReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);

    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}