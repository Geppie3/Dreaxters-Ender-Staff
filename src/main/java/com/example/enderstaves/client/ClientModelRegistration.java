package com.example.enderstaves.client;

import com.example.enderstaves.EnderStaves;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = EnderStaves.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public final class ClientModelRegistration {
    private ClientModelRegistration() {
    }

    @SubscribeEvent
    public static void registerAdditionalModels(ModelEvent.RegisterAdditional event) {
        event.register(new ResourceLocation(EnderStaves.MOD_ID, "item/ender_staff_geometry"));
        event.register(new ResourceLocation(EnderStaves.MOD_ID, "item/ender_staff_eye_glow"));
    }
}