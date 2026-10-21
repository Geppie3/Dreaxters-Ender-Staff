package com.example.enderstaves.item.armor;

import com.example.enderstaves.EnderStaves;
import com.example.enderstaves.registry.ModEffects;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = EnderStaves.MOD_ID)
public final class EnderMageSetBonus {
    private static final UUID SET_BONUS_ID = UUID.fromString("3a1704f5-ada4-4650-92dc-cf69f3a719fb");
    private static final double ENDER_SPELL_POWER_BONUS = 0.65D;
    private static final int CHECK_INTERVAL_TICKS = 20;

    private EnderMageSetBonus() {
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.player.level().isClientSide()) {
            return;
        }
        if (event.player.tickCount % CHECK_INTERVAL_TICKS != 0) {
            return;
        }
        updateSetBonus(event.player);
    }

    private static void updateSetBonus(LivingEntity entity) {
        AttributeInstance attribute = entity.getAttribute(AttributeRegistry.ENDER_SPELL_POWER.get());
        if (attribute == null) {
            return;
        }

        boolean hasFullSet = isWearingFullSet(entity);
        boolean hasBonus = attribute.getModifier(SET_BONUS_ID) != null;

        if (hasFullSet && !hasBonus) {
            attribute.addTransientModifier(new AttributeModifier(
                    SET_BONUS_ID, "Ender Mage set bonus", ENDER_SPELL_POWER_BONUS,
                    AttributeModifier.Operation.MULTIPLY_BASE));
        } else if (!hasFullSet && hasBonus) {
            attribute.removeModifier(SET_BONUS_ID);
        }

        updateIndicatorEffect(entity, hasFullSet);
    }

    // Checked separately so the icon returns if milk clears it.
    private static void updateIndicatorEffect(LivingEntity entity, boolean hasFullSet) {
        MobEffect effect = ModEffects.ENDER_MAGE_SET_BONUS.get();
        boolean hasEffect = entity.hasEffect(effect);

        if (hasFullSet && !hasEffect) {
            entity.addEffect(new MobEffectInstance(
                    effect, MobEffectInstance.INFINITE_DURATION, 0, false, false, true));
        } else if (!hasFullSet && hasEffect) {
            entity.removeEffect(effect);
        }
    }

    private static boolean isWearingFullSet(LivingEntity entity) {
        return isPiece(entity.getItemBySlot(EquipmentSlot.HEAD))
                && isPiece(entity.getItemBySlot(EquipmentSlot.CHEST))
                && isPiece(entity.getItemBySlot(EquipmentSlot.LEGS))
                && isPiece(entity.getItemBySlot(EquipmentSlot.FEET));
    }

    private static boolean isPiece(ItemStack stack) {
        return stack.getItem() instanceof EnderMageArmorItem;
    }
}
