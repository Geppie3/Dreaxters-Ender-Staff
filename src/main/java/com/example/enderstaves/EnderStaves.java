package com.example.enderstaves;

import com.example.enderstaves.config.EnderStavesConfig;
import com.example.enderstaves.registry.ModItems;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EnderStaves.MOD_ID)
public final class EnderStaves {
    public static final String MOD_ID = "enderstaves";

    public EnderStaves() {
        ModLoadingContext.get().registerConfig(
                ModConfig.Type.COMMON,
                EnderStavesConfig.SPEC,
                "enderstaves-common.toml"
        );

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modBus);
        modBus.addListener(ModItems::addToCreativeTabs);
    }
}