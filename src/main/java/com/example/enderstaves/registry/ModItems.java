package com.example.enderstaves.registry;

import com.example.enderstaves.EnderStaves;
import com.example.enderstaves.item.AscendedEnderStaffItem;
import com.example.enderstaves.item.EnderStaffItem;
import com.example.enderstaves.item.VoidTouchedEnderStaffItem;
import com.example.enderstaves.item.armor.EnderMageArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    private static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EnderStaves.MOD_ID);

    public static final RegistryObject<Item> ENDER_STAFF =
            ITEMS.register("ender_staff", EnderStaffItem::new);

    public static final RegistryObject<Item> ASCENDED_ENDER_STAFF =
            ITEMS.register("ascended_ender_staff", AscendedEnderStaffItem::new);

    public static final RegistryObject<Item> VOID_TOUCHED_ENDER_STAFF =
            ITEMS.register("void_touched_ender_staff", VoidTouchedEnderStaffItem::new);

    public static final RegistryObject<Item> ENDER_MAGE_HELMET =
            ITEMS.register("ender_mage_helmet", () -> new EnderMageArmorItem(ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> ENDER_MAGE_CHESTPLATE =
            ITEMS.register("ender_mage_chestplate", () -> new EnderMageArmorItem(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> ENDER_MAGE_LEGGINGS =
            ITEMS.register("ender_mage_leggings", () -> new EnderMageArmorItem(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> ENDER_MAGE_BOOTS =
            ITEMS.register("ender_mage_boots", () -> new EnderMageArmorItem(ArmorItem.Type.BOOTS));

    private ModItems() {}

    public static void register(IEventBus modBus) {
        ITEMS.register(modBus);
    }

    public static void addToCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ENDER_STAFF);
            event.accept(ASCENDED_ENDER_STAFF);
            event.accept(VOID_TOUCHED_ENDER_STAFF);
            event.accept(ENDER_MAGE_HELMET);
            event.accept(ENDER_MAGE_CHESTPLATE);
            event.accept(ENDER_MAGE_LEGGINGS);
            event.accept(ENDER_MAGE_BOOTS);
        }
    }
}
