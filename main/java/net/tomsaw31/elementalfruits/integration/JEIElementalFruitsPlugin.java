package net.tomsaw31.elementalfruits.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.tomsaw31.elementalfruits.ElementalFruitsMod;
import net.tomsaw31.elementalfruits.recipe.FruitSynthesizerRecipe;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIElementalFruitsPlugin implements IModPlugin {
    public static RecipeType<FruitSynthesizerRecipe> FRUIT_SYNTHESIS_TYPE =
            new RecipeType<>(FruitSynthesizerRecipeCategory.UID, FruitSynthesizerRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ElementalFruitsMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                FruitSynthesizerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<FruitSynthesizerRecipe> recipesSynthesis = rm.getAllRecipesFor(FruitSynthesizerRecipe.Type.INSTANCE);
        registration.addRecipes(FRUIT_SYNTHESIS_TYPE, recipesSynthesis);
    }
}