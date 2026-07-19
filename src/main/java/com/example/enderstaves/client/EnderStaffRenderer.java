package com.example.enderstaves.client;

import com.example.enderstaves.EnderStaves;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

/** Renders the regular baked Blockbench model through Forge's item-renderer hook. */
public final class EnderStaffRenderer extends BlockEntityWithoutLevelRenderer {
    private static final ResourceLocation GEOMETRY_MODEL =
            new ResourceLocation(EnderStaves.MOD_ID, "item/ender_staff_geometry");

    public EnderStaffRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack,
                             MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Minecraft minecraft = Minecraft.getInstance();
        BakedModel model = minecraft.getModelManager().getModel(GEOMETRY_MODEL);
        // The outer builtin/entity model supplies no display transforms. This lets the
        // Blockbench model's own display section control all held-item positioning.
        minecraft.getItemRenderer().render(stack, displayContext, false, poseStack, bufferSource,
                packedLight, packedOverlay, model);
    }
}
