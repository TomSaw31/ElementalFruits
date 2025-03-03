package net.tomsaw31.elementalfruits.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.tomsaw31.elementalfruits.ElementalFruitsMod;

public class FruitSynthesizerScreen extends AbstractContainerScreen<FruitSynthesizerMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ElementalFruitsMod.MOD_ID,"textures/gui/fruit_synthesizer_gui.png");
    public FruitSynthesizerScreen(FruitSynthesizerMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float partialTicks, int x, int y) {
        RenderSystem.setShaderTexture(0, TEXTURE);
        var posX = (width - imageWidth) / 2;
        var posY = (height - imageHeight) / 2;
        pGuiGraphics.blit(TEXTURE, posX, posY, 0, 0, imageWidth, imageHeight);
        renderProgressArrow(pGuiGraphics,posX,posY);
    }

    private void renderProgressArrow(GuiGraphics pGuiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            pGuiGraphics.blit(TEXTURE, x+109, y+33, 176, 0, 8, menu.getScaledProgress());
        }
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, mouseX, mouseY, delta);
        renderTooltip(pGuiGraphics, mouseX, mouseY);
    }
}
