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

public final class EnderStaffRenderer extends BlockEntityWithoutLevelRenderer {
    private static final ResourceLocation GEOMETRY_MODEL =
            new ResourceLocation(EnderStaves.MOD_ID, "item/ender_staff_geometry");

    private static final ResourceLocation EYE_GLOW_MODEL =
            new ResourceLocation(EnderStaves.MOD_ID, "item/ender_staff_eye_glow");

    public EnderStaffRenderer() {
        super(
                Minecraft.getInstance().getBlockEntityRenderDispatcher(),
                Minecraft.getInstance().getEntityModels()
        );
    }

    @Override
    public void renderByItem(
            ItemStack stack,
            ItemDisplayContext displayContext,
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight,
            int packedOverlay
    ) {
        Minecraft minecraft = Minecraft.getInstance();

        BakedModel staffModel = minecraft.getModelManager().getModel(GEOMETRY_MODEL);
        BakedModel eyeGlowModel = minecraft.getModelManager().getModel(EYE_GLOW_MODEL);

        minecraft.getItemRenderer().render(
                stack,
                displayContext,
                false,
                poseStack,
                bufferSource,
                packedLight,
                packedOverlay,
                staffModel
        );

        float time = minecraft.level == null
                ? 0.0F
                : minecraft.level.getGameTime() + minecraft.getFrameTime();

        float bobUpDown =
                0.010F * Mth.sin(time * 0.055F) +
                0.004F * Mth.sin(time * 0.021F + 1.7F);

        float driftSideways =
                0.003F * Mth.sin(time * 0.037F + 0.8F);

        float driftDepth =
                0.002F * Mth.cos(time * 0.029F + 2.1F);

        float pulse =
                1.0F +
                0.010F * Mth.sin(time * 0.060F);

        poseStack.pushPose();
        poseStack.translate(driftSideways, bobUpDown, driftDepth);
        poseStack.scale(pulse, pulse, pulse);

        minecraft.getItemRenderer().render(
                stack,
                displayContext,
                false,
                poseStack,
                bufferSource,
                LightTexture.FULL_BRIGHT,
                packedOverlay,
                eyeGlowModel
        );

        poseStack.popPose();
    }
}