package com.example.enderstaves.client;

import com.example.enderstaves.EnderStaves;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;

public final class VoidTouchedEnderStaffRenderer extends EnderStaffRenderer {
    // Eye centre in model space.
    private static final float PIVOT_X = 8.0F / 16.0F;
    private static final float PIVOT_Y = 14.36F / 16.0F;
    private static final float PIVOT_Z = 8.0F / 16.0F;
    // atan(sqrt(2)): stands a cube on its corner after a 45 degree Y turn.
    private static final float CORNER_TILT_DEGREES = 54.7356F;

    private final ResourceLocation shardsModel =
            new ResourceLocation(EnderStaves.MOD_ID, "item/void_touched_ender_staff_shards");

    public VoidTouchedEnderStaffRenderer() {
        super("item/void_touched_ender_staff_geometry", "item/void_touched_ender_staff_eye_glow");
    }

    @Override
    protected void renderEyeGlow(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack,
                                 MultiBufferSource bufferSource, int packedOverlay, BakedModel bakedEyeGlowModel,
                                 float time) {
        float gemBob = 0.15F / 16.0F * Mth.sin(time * 0.055F);
        float gemPulse = 1.0F + 0.05F * Mth.sin(time * 0.12F);
        renderAroundEye(stack, displayContext, poseStack, bufferSource, packedOverlay, bakedEyeGlowModel,
                gemBob, time * 3.0F, gemPulse, true);

        float shardBob = 0.25F / 16.0F * Mth.sin(time * 0.08F + 1.3F);
        BakedModel shards = Minecraft.getInstance().getModelManager().getModel(shardsModel);
        renderAroundEye(stack, displayContext, poseStack, bufferSource, packedOverlay, shards,
                shardBob, -time * 4.0F, 1.0F, false);
    }

    private static void renderAroundEye(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack,
                                        MultiBufferSource bufferSource, int packedOverlay, BakedModel model,
                                        float bob, float spinDegrees, float scale, boolean standOnCorner) {
        poseStack.pushPose();
        // Apply the display transform first so the spin happens in model space.
        BakedModel transformed = ForgeHooksClient.handleCameraTransforms(poseStack, model, displayContext, false);
        poseStack.translate(-0.5F, -0.5F, -0.5F);
        poseStack.translate(PIVOT_X, PIVOT_Y + bob, PIVOT_Z);
        poseStack.mulPose(Axis.YP.rotationDegrees(spinDegrees));
        if (standOnCorner) {
            poseStack.mulPose(Axis.ZP.rotationDegrees(CORNER_TILT_DEGREES));
            poseStack.mulPose(Axis.YP.rotationDegrees(45.0F));
        }
        poseStack.scale(scale, scale, scale);
        poseStack.translate(-PIVOT_X, -PIVOT_Y, -PIVOT_Z);

        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        for (RenderType renderType : transformed.getRenderTypes(stack, true)) {
            VertexConsumer consumer = ItemRenderer.getFoilBufferDirect(bufferSource, renderType, true, stack.hasFoil());
            itemRenderer.renderModelLists(transformed, stack, LightTexture.FULL_BRIGHT, packedOverlay, poseStack, consumer);
        }
        poseStack.popPose();
    }
}
