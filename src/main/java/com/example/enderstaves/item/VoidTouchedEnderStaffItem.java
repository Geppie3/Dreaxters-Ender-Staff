package com.example.enderstaves.item;

import com.example.enderstaves.client.VoidTouchedEnderStaffClientExtensions;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public final class VoidTouchedEnderStaffItem extends StaffItem {
    private static final UUID ENDER_POWER_ID = UUID.fromString("8f3a1c2d-6b4e-4f19-a2d7-1c9e4b6a8f30");
    private static final UUID ELDRITCH_POWER_ID = UUID.fromString("2d7e4f1a-9c3b-4e6d-8a1f-5b7c3d9e2f41");
    private static final UUID MANA_REGEN_ID = UUID.fromString("b6c8d2a4-3e5f-4a7b-9d1c-6f8a2b4c7e93");
    private static final UUID MAX_MANA_ID = UUID.fromString("4e1a7c9d-2b6f-4d8e-a3c5-9f2d6b8e1a74");
    private static final UUID COOLDOWN_ID = UUID.fromString("7a2c5e8f-4d1b-4c6a-8e3f-2b9d5c7a1e05");

    public VoidTouchedEnderStaffItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC), 9.0D, -3.0D,
                Map.of(
                        AttributeRegistry.ENDER_SPELL_POWER.get(),
                        new AttributeModifier(ENDER_POWER_ID, "Void-Touched Ender Staff ender power", 0.35D,
                                AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.ELDRITCH_SPELL_POWER.get(),
                        new AttributeModifier(ELDRITCH_POWER_ID, "Void-Touched Ender Staff eldritch power", 0.15D,
                                AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.MANA_REGEN.get(),
                        new AttributeModifier(MANA_REGEN_ID, "Void-Touched Ender Staff mana regeneration", 0.45D,
                                AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.MAX_MANA.get(),
                        new AttributeModifier(MAX_MANA_ID, "Void-Touched Ender Staff maximum mana", 200.0D,
                                AttributeModifier.Operation.ADDITION),
                        AttributeRegistry.COOLDOWN_REDUCTION.get(),
                        new AttributeModifier(COOLDOWN_ID, "Void-Touched Ender Staff cooldown reduction", 0.15D,
                                AttributeModifier.Operation.ADDITION)
                ));
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new VoidTouchedEnderStaffClientExtensions());
    }
}