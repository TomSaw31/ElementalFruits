package net.tomsaw31.elementalfruits.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.tomsaw31.elementalfruits.ElementalFruitsMod;
import net.tomsaw31.elementalfruits.block.ModBlocks;
import net.tomsaw31.elementalfruits.recipe.FruitSynthesizerRecipe;

public class FruitSynthesizerRecipeCategory implements IRecipeCategory<FruitSynthesizerRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(ElementalFruitsMod.MOD_ID, "fruit_synthesis");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(ElementalFruitsMod.MOD_ID, "textures/gui/fruit_synthesizer_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public FruitSynthesizerRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 90);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.FRUIT_SYNTHESIZER.get()));
    }


    @Override
    public RecipeType<FruitSynthesizerRecipe> getRecipeType() {
        return JEIElementalFruitsPlugin.FRUIT_SYNTHESIS_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Fruit Synthesizer");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FruitSynthesizerRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 68, 15).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 92, 15).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 60).addItemStack(recipe.getResultItem(null));
    }

}
