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
    private static final UUID ENDER_POWER_ID = UUID.fromString("6f8e2f0a-6b31-4b5e-8c2f-2a0f6a1d7c44");
    private static final UUID ELDRITCH_POWER_ID = UUID.fromString("4a7c9e1d-8b2f-4e6a-9c3d-5f1b7a2e8d60");
    private static final UUID MANA_REGEN_ID = UUID.fromString("6c1a7e2b-9a3d-4f8e-9b6a-1d4e3c5f8a2b");
    private static final UUID MAX_MANA_ID = UUID.fromString("9d3f5a1c-2e7b-4a6d-8f0c-3b6d9e2a4c7f");
    private static final UUID COOLDOWN_ID = UUID.fromString("1b4d6f8a-3c5e-4d7f-9a1b-2c4e6f8a0b3d");

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
