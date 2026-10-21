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
    private static final UUID ENDER_POWER_ID = UUID.fromString("1173b790-eb38-4026-8136-8f2f9da94644");
    private static final UUID ELDRITCH_POWER_ID = UUID.fromString("8ad8683d-e565-4295-89a7-86fe8de2f4f9");
    private static final UUID MANA_REGEN_ID = UUID.fromString("5451aad0-016d-40bc-9232-7ea9d8c9bc36");
    private static final UUID MAX_MANA_ID = UUID.fromString("46ca1eab-85c7-42ba-adcd-dd82205fa85c");
    private static final UUID COOLDOWN_ID = UUID.fromString("c2e54f22-4a28-4c30-9602-1c4220d93d0e");

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