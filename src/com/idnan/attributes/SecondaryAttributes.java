package com.idnan.attributes;

public class SecondaryAttributes {


    private int health;
    private int armorRating;
    private int elementalResistance;


    public int getHealth() {
        return health;
    }

    /**
     * Determines health based on vitality.
     *
     * @param vitality - charecter vitality
     */
    public void setHealth(int vitality) {
        this.health = vitality * 10;
    }

    public int getArmorRating() {
        return armorRating;
    }

    /**
     * Determines armorRating based on dexterity and strength
     *
     * @param dexterity - charecter dexterity
     * @param strength  - charecter strength
     */
    public void setArmorRating(int dexterity, int strength) {
        this.armorRating = strength + dexterity;
    }

    public int getElementalResistance() {
        return elementalResistance;
    }

    /**
     * Determines elementalResistance based on intelligence
     *
     * @param intelligence - charecter intelligence
     */
    public void setElementalResistance(int intelligence) {
        this.elementalResistance = intelligence;
    }
}



