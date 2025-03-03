package net.tomsaw31.elementalfruits.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.elementalfruits.ElementalFruitsMod;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ElementalFruitsMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<FruitSynthesizerRecipe>> FRUIT_SYNTHESIS_SERIALIZER =
            SERIALIZERS.register("fruit_synthesis", () -> FruitSynthesizerRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}