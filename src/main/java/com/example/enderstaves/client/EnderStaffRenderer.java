package com.example.enderstaves.client;

import com.example.enderstaves.EnderStaves;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class EnderStaffRenderer extends BlockEntityWithoutLevelRenderer {
    private final ResourceLocation geometryModel;
    private final ResourceLocation eyeGlowModel;

    public EnderStaffRenderer(String geometryModelPath, String eyeGlowModelPath) {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        this.geometryModel = new ResourceLocation(EnderStaves.MOD_ID, geometryModelPath);
        this.eyeGlowModel = new ResourceLocation(EnderStaves.MOD_ID, eyeGlowModelPath);
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack,
                             MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Minecraft minecraft = Minecraft.getInstance();
        BakedModel staffModel = minecraft.getModelManager().getModel(geometryModel);
        BakedModel bakedEyeGlowModel = minecraft.getModelManager().getModel(eyeGlowModel);

        poseStack.pushPose();
        if (displayContext == ItemDisplayContext.GUI) {
            // GUI has no half-block offset like hand/ground, so recentre in the slot.
            poseStack.translate(0.33D, 0.47D, 0.0D);
            poseStack.scale(1.15F, 0.84F, 1.15F);
        }

        minecraft.getItemRenderer().render(stack, displayContext, false, poseStack, bufferSource,
                packedLight, packedOverlay, staffModel);

        float time = minecraft.level == null ? 0.0F : minecraft.level.getGameTime() + minecraft.getFrameTime();
        renderEyeGlow(stack, displayContext, poseStack, bufferSource, packedOverlay, bakedEyeGlowModel, time);
        poseStack.popPose();
    }

    protected void renderEyeGlow(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack,
                                 MultiBufferSource bufferSource, int packedOverlay, BakedModel bakedEyeGlowModel,
                                 float time) {
        float bob = 0.010F * Mth.sin(time * 0.055F) + 0.004F * Mth.sin(time * 0.021F + 1.7F);
        float driftX = 0.003F * Mth.sin(time * 0.037F + 0.8F);
        float driftZ = 0.002F * Mth.cos(time * 0.029F + 2.1F);
        float pulse = 1.0F + 0.010F * Mth.sin(time * 0.060F);

        poseStack.pushPose();
        poseStack.translate(driftX, bob, driftZ);
        poseStack.scale(pulse, pulse, pulse);
        Minecraft.getInstance().getItemRenderer().render(stack, displayContext, false, poseStack, bufferSource,
                LightTexture.FULL_BRIGHT, packedOverlay, bakedEyeGlowModel);
        poseStack.popPose();
    }
}
