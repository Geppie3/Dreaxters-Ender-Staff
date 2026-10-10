package com.example.enderstaves.client;

import io.redspace.ironsspellbooks.render.ClientStaffItemExtensions;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

public final class VoidTouchedEnderStaffClientExtensions extends ClientStaffItemExtensions {
    private final BlockEntityWithoutLevelRenderer renderer = new VoidTouchedEnderStaffRenderer();

    @Override
    public BlockEntityWithoutLevelRenderer getCustomRenderer() {
        return renderer;
    }
}
