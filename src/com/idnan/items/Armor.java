package com.idnan.items;

import com.idnan.attributes.PrimaryAttributes;
import com.idnan.equimpent.SlotType;

public class Armor extends Item {
    private final ArmorType armorType;
    private final PrimaryAttributes primaryAttributes;

    public Armor(String name, int requiredLevel, SlotType slotType, ArmorType armorType, PrimaryAttributes primaryAttributes) {
        super(name, requiredLevel, slotType);
        this.armorType = armorType;
        this.primaryAttributes = primaryAttributes;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public PrimaryAttributes getPrimaryAttributes() {
        return primaryAttributes;
    }


}
