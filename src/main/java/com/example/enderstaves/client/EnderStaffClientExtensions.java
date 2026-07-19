package com.example.enderstaves.client;

import io.redspace.ironsspellbooks.render.ClientStaffItemExtensions;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

/** Client-only support for the Ender Staff's static 3D item model. */
public final class EnderStaffClientExtensions extends ClientStaffItemExtensions {
    private final BlockEntityWithoutLevelRenderer renderer = new EnderStaffRenderer();

    @Override
    public BlockEntityWithoutLevelRenderer getCustomRenderer() {
        return renderer;
    }
}
