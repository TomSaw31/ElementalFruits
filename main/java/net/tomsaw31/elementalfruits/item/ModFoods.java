package net.tomsaw31.elementalfruits.item;


import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties FRUIT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).alwaysEat().build();
    public static final FoodProperties ELEMENTAL_SALAD = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.7F).alwaysEat().build();
}
