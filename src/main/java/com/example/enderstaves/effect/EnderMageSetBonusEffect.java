package com.example.enderstaves.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

// Display only; the actual bonus is applied by EnderMageSetBonus.
public final class EnderMageSetBonusEffect extends MobEffect {
    public EnderMageSetBonusEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x7B2FBE);
    }
}
