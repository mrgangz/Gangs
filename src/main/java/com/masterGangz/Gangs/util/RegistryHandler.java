// Copyright Ganger 2020
package com.masterGangz.Gangs.util;

import com.masterGangz.Gangs.Gangs;
import com.masterGangz.Gangs.armor.ModArmorMaterial;
import com.masterGangz.Gangs.items.ItemBase;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Gangs.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }


    // Items
    public static final RegistryObject<Item> BANDANA_BLUE = ITEMS.register("blue_bandana", ItemBase::new);
    public static final RegistryObject<Item> BANDANA_GREEN = ITEMS.register("green_bandana", ItemBase::new);

    // Armor
    public static final RegistryObject<ArmorItem> RED_BANDANA = ITEMS.register("red_bandana", () ->
            new ArmorItem(ModArmorMaterial.RED_BANDANA_SET, EquipmentSlotType.HEAD, new Item.Properties()
                    .group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> RED_VEST = ITEMS.register("red_vest", () ->
            new ArmorItem(ModArmorMaterial.RED_BANDANA_SET, EquipmentSlotType.CHEST, new Item.Properties()
                    .group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> RED_PANTS = ITEMS.register("red_pants", () ->
            new ArmorItem(ModArmorMaterial.RED_BANDANA_SET, EquipmentSlotType.LEGS, new Item.Properties()
                    .group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> RED_JORDANS = ITEMS.register("red_jordans", () ->
            new ArmorItem(ModArmorMaterial.RED_BANDANA_SET, EquipmentSlotType.FEET, new Item.Properties()
                    .group(ItemGroup.COMBAT)));



}
