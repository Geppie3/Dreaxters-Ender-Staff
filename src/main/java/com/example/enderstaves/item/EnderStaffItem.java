package com.example.enderstaves.item;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import com.example.enderstaves.client.EnderStaffClientExtensions;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public final class EnderStaffItem extends StaffItem {
    private static final UUID ENDER_POWER_ID = UUID.fromString("957b56d0-e921-4d12-8c0e-df5762319fd1");
    private static final UUID MANA_REGEN_ID = UUID.fromString("50bda941-fef2-4b94-a86a-f74adf5df850");
    private static final UUID MAX_MANA_ID = UUID.fromString("3a26bafc-cdf0-4024-b6bd-38e59f7d39cf");

    public EnderStaffItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 5.0D, -3.0D,
                Map.of(
                        AttributeRegistry.ENDER_SPELL_POWER.get(),
                        new AttributeModifier(ENDER_POWER_ID, "Ender Staff ender power", 0.15D,
                                AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.MANA_REGEN.get(),
                        new AttributeModifier(MANA_REGEN_ID, "Ender Staff mana regeneration", 0.25D,
                                AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.MAX_MANA.get(),
                        new AttributeModifier(MAX_MANA_ID, "Ender Staff maximum mana", 100.0D,
                                AttributeModifier.Operation.ADDITION)
                ));
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new EnderStaffClientExtensions());
    }
}
