package com.idnan.equimpent;

import com.idnan.items.Armor;
import com.idnan.items.Weapon;

import com.idnan.items.Item;


import java.util.HashMap;

public class Equipment {


    private final HashMap<SlotType, Item> slotTypeItems;


    public Equipment() {
        this.slotTypeItems = new HashMap<>();
    }

    /**
     * Obtain slotType Item
     *
     * @return HashMap (consisting characters equipments)
     */
    public HashMap<SlotType, Item> getSlotTypeItem() {
        return slotTypeItems;
    }

    public Weapon getWeaponItem() {
        return (Weapon) slotTypeItems.getOrDefault(SlotType.WEAPON, null);
    }

    /**
     * Obtaining an armor in a specific slot Type.
     *
     * @param slotType - slotType
     * @return Null otherWise
     */
    public Armor getArmorItem(SlotType slotType) {
        return (Armor) slotTypeItems.getOrDefault(slotType, null);
    }
}
