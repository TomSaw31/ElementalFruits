package net.tomsaw31.elementalfruits.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.elementalfruits.ElementalFruitsMod;
import net.tomsaw31.elementalfruits.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            ElementalFruitsMod.MOD_ID);

    public static RegistryObject<CreativeModeTab> ELEMENTAL_FRUITS_TAB = CREATIVE_MODE_TABS.register("elemental_fruits_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WATER_FRUIT.get()))
                    .title(Component.translatable("creativemodetab.elemental_fruits_tab")).build());
    public static RegistryObject<CreativeModeTab> ELEMENTAL_FRUITS_MISC_TAB = CREATIVE_MODE_TABS.register("elemental_fruits_misc_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CRIMSON_CAKE.get()))
                    .title(Component.translatable("creativemodetab.elemental_fruits_misc_tab")).build());
    public static RegistryObject<CreativeModeTab> ELEMENTAL_FRUITS_SEEDS_TAB = CREATIVE_MODE_TABS.register("elemental_fruits_seeds_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NETHER_FRUIT_SEEDS.get()))
                    .title(Component.translatable("creativemodetab.elemental_fruits_seeds_tab")).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

