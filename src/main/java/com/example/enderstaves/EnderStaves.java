package com.example.enderstaves;

import com.example.enderstaves.registry.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(EnderStaves.MOD_ID)
public final class EnderStaves {
    public static final String MOD_ID = "enderstaves";

    public EnderStaves() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modBus);
        modBus.addListener(ModItems::addToCreativeTabs);
    }
}
