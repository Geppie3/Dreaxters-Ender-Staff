package com.example.enderstaves.client;

import com.example.enderstaves.EnderStaves;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

// Iron's Spells is All Rights Reserved, so its texture is recoloured in memory instead of shipped.
@OnlyIn(Dist.CLIENT)
public final class EnderMageArmorTexture {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final ResourceLocation SOURCE =
            new ResourceLocation("irons_spellbooks", "textures/models/armor/netherite.png");
    private static final ResourceLocation RECOLORED =
            new ResourceLocation(EnderStaves.MOD_ID, "textures/models/armor/ender_mage_recolored");

    // Netherite RGB -> Ender RGB.
    private static final Map<Integer, Integer> PALETTE = Map.ofEntries(
            // Metal
            Map.entry(0x111111, 0x050308),
            Map.entry(0x241F20, 0x0B0812),
            Map.entry(0x322727, 0x100B1A),
            Map.entry(0x352D2D, 0x120C1E),
            Map.entry(0x3F303B, 0x170F26),
            Map.entry(0x473E3F, 0x1B112C),
            Map.entry(0x49393F, 0x1C1130),
            Map.entry(0x51444E, 0x211436),
            Map.entry(0x5D565D, 0x2A1745),
            Map.entry(0x766A76, 0x3A1A60),
            // Cloth
            Map.entry(0x696896, 0x1E1036),
            Map.entry(0xA59BB7, 0x2E1752),
            Map.entry(0xE7C8D4, 0x46187A),
            Map.entry(0xFFFFFF, 0x5E1EA0)
    );

    private static ResourceLocation texture;

    private EnderMageArmorTexture() {
    }

    public static ResourceLocation get() {
        if (texture == null) {
            texture = create();
        }
        return texture;
    }

    private static ResourceLocation create() {
        Minecraft minecraft = Minecraft.getInstance();
        try (InputStream in = minecraft.getResourceManager().open(SOURCE)) {
            NativeImage image = NativeImage.read(in);
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    image.setPixelRGBA(x, y, recolor(image.getPixelRGBA(x, y)));
                }
            }
            minecraft.getTextureManager().register(RECOLORED, new DynamicTexture(image));
            return RECOLORED;
        } catch (IOException e) {
            LOGGER.warn("Could not recolour Ender Mage armour texture, using the original", e);
            return SOURCE;
        }
    }

    // NativeImage pixels are ABGR.
    private static int recolor(int abgr) {
        int alpha = abgr >>> 24;
        if (alpha == 0) {
            return abgr;
        }
        int rgb = ((abgr & 0xFF) << 16) | (abgr & 0xFF00) | ((abgr >> 16) & 0xFF);
        Integer mapped = PALETTE.get(rgb);
        if (mapped == null) {
            return abgr;
        }
        return (alpha << 24) | ((mapped & 0xFF) << 16) | (mapped & 0xFF00) | ((mapped >> 16) & 0xFF);
    }
}
