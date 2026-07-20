package com.example.enderstaves.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class EnderStavesConfig {
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.DoubleValue ENDER_SPELL_POWER_MULTIPLIER;
    public static final ForgeConfigSpec.DoubleValue MANA_REGEN_MULTIPLIER;
    public static final ForgeConfigSpec.IntValue MAX_MANA_BONUS;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("ender_staff");

        ENDER_SPELL_POWER_MULTIPLIER = builder
                .comment("Ender spell power bonus. 0.15 means +15%.")
                .defineInRange("ender_spell_power_multiplier", 0.15D, 0.0D, 10.0D);

        MANA_REGEN_MULTIPLIER = builder
                .comment("Mana regeneration bonus. 0.25 means +25%.")
                .defineInRange("mana_regen_multiplier", 0.25D, 0.0D, 10.0D);

        MAX_MANA_BONUS = builder
                .comment("Flat maximum mana bonus granted by the Ender Staff.")
                .defineInRange("max_mana_bonus", 100, 0, 100000);

        builder.pop();
        SPEC = builder.build();
    }

    private EnderStavesConfig() {
    }
}