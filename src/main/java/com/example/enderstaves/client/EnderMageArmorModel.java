package com.example.enderstaves.client;

import com.example.enderstaves.item.armor.EnderMageArmorItem;
import io.redspace.ironsspellbooks.entity.armor.GenericArmorModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public final class EnderMageArmorModel extends GenericArmorModel<EnderMageArmorItem> {
    public EnderMageArmorModel() {
        super("irons_spellbooks", "netherite");
    }

    @Override
    public ResourceLocation getTextureResource(EnderMageArmorItem animatable) {
        return EnderMageArmorTexture.get();
    }
}
