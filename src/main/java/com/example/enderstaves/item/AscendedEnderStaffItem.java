package com.example.enderstaves.item;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import com.example.enderstaves.client.AscendedEnderStaffClientExtensions;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public final class AscendedEnderStaffItem extends StaffItem {
    private static final UUID ENDER_POWER_ID = UUID.fromString("f57afcb6-85b7-44d5-895b-d7d15b1e0a6d");
    private static final UUID ELDRITCH_POWER_ID = UUID.fromString("02c52289-e4dc-4e7a-a337-d364d7772996");
    private static final UUID MANA_REGEN_ID = UUID.fromString("782ff8ef-b3d9-4d5d-a857-f5051261f869");
    private static final UUID MAX_MANA_ID = UUID.fromString("11f23f2c-6f3a-4690-b9ca-7e8decd44202");
    private static final UUID COOLDOWN_ID = UUID.fromString("035fdf34-fc82-4937-8b71-37f01b063c59");

    public AscendedEnderStaffItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC), 7.0D, -3.0D,
                Map.of(
                        AttributeRegistry.ENDER_SPELL_POWER.get(),
                        new AttributeModifier(ENDER_POWER_ID, "Ascended Ender Staff ender power", 0.25D,
                                AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.ELDRITCH_SPELL_POWER.get(),
                        new AttributeModifier(ELDRITCH_POWER_ID, "Ascended Ender Staff eldritch power", 0.10D,
                                AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.MANA_REGEN.get(),
                        new AttributeModifier(MANA_REGEN_ID, "Ascended Ender Staff mana regeneration", 0.35D,
                                AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.MAX_MANA.get(),
                        new AttributeModifier(MAX_MANA_ID, "Ascended Ender Staff maximum mana", 150.0D,
                                AttributeModifier.Operation.ADDITION),
                        AttributeRegistry.COOLDOWN_REDUCTION.get(),
                        new AttributeModifier(COOLDOWN_ID, "Ascended Ender Staff cooldown reduction", 0.10D,
                                AttributeModifier.Operation.ADDITION)
                ));
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new AscendedEnderStaffClientExtensions());
    }
}
