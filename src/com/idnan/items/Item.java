package com.idnan.items;

import com.idnan.equimpent.SlotType;

public abstract class Item {
    private final String name;
    private final int requiredLevel;
    private final SlotType slotType;

    public Item(String name, int requiredLevel, SlotType slotType) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slotType = slotType;
    }

    public String getName() {
        return name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public SlotType getSlotType() {
        return slotType;
    }


}
