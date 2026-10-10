package com.example.enderstaves.registry;

import com.example.enderstaves.EnderStaves;
import com.example.enderstaves.effect.EnderMageSetBonusEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEffects {
    private static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, EnderStaves.MOD_ID);

    public static final RegistryObject<MobEffect> ENDER_MAGE_SET_BONUS =
            EFFECTS.register("ender_mage_set_bonus", EnderMageSetBonusEffect::new);

    private ModEffects() {}

    public static void register(IEventBus modBus) {
        EFFECTS.register(modBus);
    }
}
