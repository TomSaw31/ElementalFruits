package net.tomsaw31.elementalfruits.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.tomsaw31.elementalfruits.block.custom.FruitSynthesizerBlock;
import net.tomsaw31.elementalfruits.block.entity.custom.FruitSynthesizerBlockEntity;
import org.joml.Vector3f;

public class FruitSynthesizerBlockEntityRenderer implements BlockEntityRenderer<FruitSynthesizerBlockEntity> {
    public FruitSynthesizerBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(FruitSynthesizerBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        for(int i = 0; i<=2; i++) {
            ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
            ItemStack itemStack = pBlockEntity.getRenderStack(i);
            pPoseStack.pushPose();
            switch(i) {
                case 0:
                    switch (pBlockEntity.getBlockState().getValue(FruitSynthesizerBlock.FACING)) {
                        case NORTH -> pPoseStack.translate(0.20f, 0.70f, 0.5f);
                        case EAST -> pPoseStack.translate(0.5f, 0.70f, 0.20f);
                        case SOUTH -> pPoseStack.translate(0.80f, 0.70f, 0.5f);
                        case WEST -> pPoseStack.translate(0.5f, 0.70f, 0.80f);
                    }
                    break;
                case 1:
                    switch (pBlockEntity.getBlockState().getValue(FruitSynthesizerBlock.FACING)) {
                        case SOUTH -> pPoseStack.translate(0.20f, 0.70f, 0.5f);
                        case WEST -> pPoseStack.translate(0.5f, 0.70f, 0.20f);
                        case NORTH -> pPoseStack.translate(0.80f, 0.70f, 0.5f);
                        case EAST -> pPoseStack.translate(0.5f, 0.70f, 0.80f);
                    }
                    break;
                case 2:
                    switch (pBlockEntity.getBlockState().getValue(FruitSynthesizerBlock.FACING)) {
                        case NORTH -> pPoseStack.translate(0.5f, 0.25f, 0.30f);
                        case EAST -> pPoseStack.translate(0.70f, 0.25f, 0.5f);
                        case SOUTH -> pPoseStack.translate(0.5f, 0.25f, 0.70f);
                        case WEST -> pPoseStack.translate(0.30f, 0.25f, 0.5f);
                    }
            }
            pPoseStack.scale(0.35f, 0.35f, 0.35f);
            pPoseStack.mulPose(Axis.XP.rotationDegrees(270));

            switch (pBlockEntity.getBlockState().getValue(FruitSynthesizerBlock.FACING)) {
                case SOUTH -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(0));
                case EAST -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
                case NORTH -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
                case WEST -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
            }

            itemRenderer.renderStatic(itemStack, ItemDisplayContext.GUI, getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()),
                    OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
            pPoseStack.popPose();
        }
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
