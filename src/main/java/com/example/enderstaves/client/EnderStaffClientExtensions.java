package com.example.enderstaves.client;

import io.redspace.ironsspellbooks.render.ClientStaffItemExtensions;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

public final class EnderStaffClientExtensions extends ClientStaffItemExtensions {
    private final BlockEntityWithoutLevelRenderer renderer =
            new EnderStaffRenderer("item/ender_staff_geometry", "item/ender_staff_eye_glow");

    @Override
    public BlockEntityWithoutLevelRenderer getCustomRenderer() {
        return renderer;
    }
}
