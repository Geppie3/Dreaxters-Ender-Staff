package com.example.enderstaves.client;

import com.example.enderstaves.EnderStaves;
import com.example.enderstaves.registry.ModItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = EnderStaves.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public final class ClientColorRegistration {
    private static final int CLOTH_TINT = 0x6030A0;
    private static final int METAL_TINT = 0x7050A0;

    private ClientColorRegistration() {
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) -> switch (tintIndex) {
                    case 0 -> CLOTH_TINT;
                    case 1 -> METAL_TINT;
                    default -> -1;
                },
                ModItems.ENDER_MAGE_HELMET.get(),
                ModItems.ENDER_MAGE_CHESTPLATE.get(),
                ModItems.ENDER_MAGE_LEGGINGS.get(),
                ModItems.ENDER_MAGE_BOOTS.get());
    }
}
