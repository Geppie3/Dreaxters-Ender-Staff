package com.example.enderstaves.item.armor;

import com.example.enderstaves.client.EnderMageArmorModel;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.ExtendedArmorItem;
import io.redspace.ironsspellbooks.item.armor.ExtendedArmorMaterials;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import java.util.List;

// Iron's Spells 3.16.2 ignores ExtendedArmorItem's AttributeContainer args; extra bonuses live in EnderMageSetBonus.
public final class EnderMageArmorItem extends ExtendedArmorItem {
    public EnderMageArmorItem(ArmorItem.Type type) {
        super(ExtendedArmorMaterials.NETHERITE_BATTLEMAGE, type, new Item.Properties().rarity(Rarity.RARE));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        tooltip.add(Component.translatable("item.enderstaves.ender_mage_armor.set_bonus")
                .withStyle(ChatFormatting.DARK_PURPLE));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new EnderMageArmorModel());
    }
}
