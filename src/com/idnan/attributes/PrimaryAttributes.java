package com.idnan.attributes;

public class PrimaryAttributes {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int vitality;

    /**
     * (Constructor) Initializing primaryAttributes.
     *
     * @param vitality     - primaryAttribute that a charecter has
     * @param strength     - primaryAttribute that a charecter has
     * @param dexterity    - primaryAttribute that a charecter has
     * @param intelligence - primaryAttribute that a charecter has
     */

    public PrimaryAttributes(int vitality, int strength, int dexterity, int intelligence) {
        this.vitality = vitality;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;

    }


    /**
     * increases vitality attribute by (int) vitality
     *
     * @param vitality increases the vitality primaryAttribute
     */
    public void increaseVitality(int vitality) {
        this.vitality += vitality;
    }

    /**
     * increases strength attribute by (int) strength
     *
     * @param strength increases the strength primaryAttribute
     */
    public void increaseStrength(int strength) {
        this.strength += strength;
    }

    /**
     * increase dexterity attribute by (int) dexterity
     *
     * @param dexterity increases the dexterity primaryAttribute
     */

    public void increaseDexterity(int dexterity) {
        this.dexterity += dexterity;
    }

    /**
     * increases intelligence attribute by intelligence.
     *
     * @param intelligence (int) increases the intelligence primaryAttribute.
     */
    public void increaseIntelligence(int intelligence) {
        this.intelligence += intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getVitality() {
        return vitality;
    }
}
