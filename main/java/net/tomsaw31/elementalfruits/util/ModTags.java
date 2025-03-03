package net.tomsaw31.elementalfruits.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.tomsaw31.elementalfruits.ElementalFruitsMod;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> FRUIT_ITEMS = tag("fruit_items");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ElementalFruitsMod.MOD_ID, name));
        }

        private static  TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
    public static class Blocks {
        public static final TagKey<Block> FIRE_BULB_BLOCKS = tag("fire_bulb_blocks");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ElementalFruitsMod.MOD_ID, name));
        }

        private static  TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}