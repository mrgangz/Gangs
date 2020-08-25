package com.masterGangz.Gangs.armor;

import com.masterGangz.Gangs.Gangs;
import com.masterGangz.Gangs.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {

    RED_BANDANA_SET( Gangs.MOD_ID + ":red_bandana_set", 5, new int[] {2, 5, 6, 2}, 30,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, () -> {return Ingredient.fromItems(Items.RED_WOOL
            .getItem());});


    private static final int[] MAX_DAMAGE_ARRAY = new int[] {11, 16, 15, 13};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;

    ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability
                    ,SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.maxDamageFactor = maxDamageFactor;
        this.enchantability= enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
    }


    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float func_230304_f_() {
        return 0;
    }

    /*@Override
    public void onArmorTick(World world, PlayerEntity player, ItemStack itemStack) {
        if (player.getArmorInventoryList() != null && player.getCurrentArmor(1).getItem().equals(ModItems.tutorialLeggings))
        {
            effectPlayer(player, Potions.NIGHT_VISION, 1);
        }
        if (itemStack.getItem() == ModItems.tutorialChestplate) {
            effectPlayer(player, Potion.digSpeed, 0);
        }
        if (itemStack.getItem() == ModItems.tutorialLeggings) {
            effectPlayer(player, Potion.moveSpeed, 0);
        }
        if (itemStack.getItem() == ModItems.tutorialBoots) {
            effectPlayer(player, Potion.jump, 1);
        }
    }

    private void effectPlayer(PlayerEntity player, Potion potion, int amplifier) {
        //Always effect for 8 seconds, then refresh
        if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)
            player.addPotionEffect(new PotionEffect(potion.id, 159, amplifier, true, true));
    }*/


}
