package com.idnan.charecters;



import com.idnan.attributes.PrimaryAttributes;
import com.idnan.attributes.SecondaryAttributes;
import com.idnan.equimpent.*;
import com.idnan.exceptions.InvalidArmorException;
import com.idnan.exceptions.InvalidWeaponException;
import com.idnan.items.Armor;

import com.idnan.items.Item;
import com.idnan.items.Weapon;


import java.util.stream.IntStream;


public abstract class CharacterBase {
    private final String name;
    private int level;

    private final PrimaryAttributes baseAttributes;
    private PrimaryAttributes equipmentAttributes;
    private PrimaryAttributes totalAttributes;

    private SecondaryAttributes secondaryAttributes = new SecondaryAttributes();
    private final Equipment eItem = new Equipment();


    /**
     * (Constructor) Initialize Charecter info (name, level, baseAttributes, equipmentAttributes & totalAttributes.
     *
     * @param name           - charecter name
     * @param baseAttributes - charecter baseAttributes (type of primaryAttributes)
     */
    public CharacterBase(String name, PrimaryAttributes baseAttributes) {
        this.name = name;
        this.level = 1;
        this.baseAttributes = baseAttributes;
        this.equipmentAttributes = new PrimaryAttributes(0, 0, 0, 0);
        this.totalAttributes = new PrimaryAttributes(0, 0, 0, 0);


        updateTotalAttributes();
    }


    protected abstract void levelUp(int level);

    public abstract boolean equip(Weapon weapon) throws InvalidWeaponException;

    public abstract boolean equip(Armor armor) throws InvalidArmorException;

    public abstract double calculateDamage();


    /**
     * Calculates the charecter DPS based on weapon and param.
     *
     * @param param - (double)
     * @return (1) if charecter doesn't have a weapon
     */
    protected double calculateDPS(double param) {
        return eItem.getWeaponItem() == null ? 1 : eItem.getWeaponItem().getDPSValue() * (1 + (param / 100));
    }

    /**
     * Checks charecter level & if it is not greater than 0, than it will add up.
     *
     * @param level (int) charecter level.
     */
    protected void increaseCharecterLevel(int level) {
        if (level <= 0) {
            throw new IllegalArgumentException("Level gain has to be more than 0");
        }
        this.level += level;
    }


    /**
     * Equips a charecter with an armor and checks if it meets the armor level requirements.
     * The armor will be equipped as specified in the item slot
     * and it will update the character's equipment attributes once it is equipped.
     *
     * @param armor - armor
     * @return True if armor is equipped
     * @throws InvalidArmorException throws Exception OTHERWISE
     */

    protected boolean equipArmor(Armor armor) throws InvalidArmorException {

        if (armor.getRequiredLevel() <= this.level) {
            switch (armor.getSlotType()) {
                case LEGS -> eItem.getSlotTypeItem().put(SlotType.LEGS, armor);
                case HEAD -> eItem.getSlotTypeItem().put(SlotType.HEAD, armor);
                case BODY -> eItem.getSlotTypeItem().put(SlotType.BODY, armor);
            }
            setEquipAttributes();
            return true;
        } else {
            throw new InvalidArmorException("Armor with a higher level requirement cannot be equipped.");
        }
    }


    /**
     * Equips a charecter with a weapon, also checks whether the weapon requiredLevel is too high.
     *
     * @param weapon - weapon
     * @return True if a weapon is equipped
     * @throws InvalidWeaponException throws Exception OTHERWISE
     */
    protected boolean equipWeapon(Weapon weapon) throws InvalidWeaponException {
        if (weapon.getRequiredLevel() <= this.level) {
            eItem.getSlotTypeItem().put(SlotType.WEAPON, weapon);
            setEquipAttributes();
            return true;
        } else {
            throw new InvalidWeaponException("WEAPONS with a higher level requirement cannot be equipped.");
        }
    }

    /**
     * Resets equipmentAttributes values first and then updates totalAttributes & equipmentAttributes.
     */
    private void setEquipAttributes() {
        //before updating reset fields
        equipmentAttributes = new PrimaryAttributes(0, 0, 0, 0);

        eItem.getSlotTypeItem().forEach(this::updateEquipAttributes);
        updateTotalAttributes();
    }

    /**
     * Increases the equipment attributes of each item in the character's equipment,
     * based on the weapon's or armor's primary attributes.
     *
     * @param key   - itemKeys
     * @param value - actualItemValues
     */

    private void updateEquipAttributes(SlotType key, Item value) {
        if (key == SlotType.WEAPON) {
            Weapon weapon = eItem.getWeaponItem();
            if (weapon != null) {
                equipmentAttributes.increaseVitality(weapon.getPrimaryAttributes().getVitality());
                equipmentAttributes.increaseDexterity(weapon.getPrimaryAttributes().getDexterity());
                equipmentAttributes.increaseIntelligence(weapon.getPrimaryAttributes().getIntelligence());
                equipmentAttributes.increaseStrength(weapon.getPrimaryAttributes().getStrength());
            }
        } else {
            //Armor if it isn't a weapon
            Armor armor = eItem.getArmorItem(key);
            if (armor != null) {
                equipmentAttributes.increaseVitality(armor.getPrimaryAttributes().getVitality());
                equipmentAttributes.increaseDexterity(armor.getPrimaryAttributes().getDexterity());
                equipmentAttributes.increaseIntelligence(armor.getPrimaryAttributes().getIntelligence());
                equipmentAttributes.increaseStrength(armor.getPrimaryAttributes().getStrength());
            }
        }
    }

    /**
     * Updates charecter baseAttributes + charecter totalAttributes.
     *
     * @param level        - charecterLevel
     * @param vitality     -  charecterVitality
     * @param strength     - charecterStrength
     * @param dexterity    - charecterDexterity
     * @param intelligence - charecterIntelligence
     */
    protected void updateCharecter(int level, int vitality, int strength, int dexterity, int intelligence) {
        IntStream.range(0, level).forEach(i -> {
            baseAttributes.increaseDexterity(dexterity);
            baseAttributes.increaseIntelligence(intelligence);
            baseAttributes.increaseStrength(strength);
            baseAttributes.increaseVitality(vitality);
        });

        updateTotalAttributes();
    }

    private void updateTotalAttributes() {

        //clear out first!
        totalAttributes = new PrimaryAttributes(0, 0, 0, 0);

        totalAttributes.increaseStrength(baseAttributes.getStrength() + equipmentAttributes.getStrength());
        totalAttributes.increaseDexterity(baseAttributes.getDexterity() + equipmentAttributes.getDexterity());
        totalAttributes.increaseIntelligence(baseAttributes.getIntelligence() + equipmentAttributes.getIntelligence());
        totalAttributes.increaseVitality(baseAttributes.getVitality() + equipmentAttributes.getVitality());

        updateSecondaryAttributes();
    }

    private void updateSecondaryAttributes() {
        secondaryAttributes.setHealth(totalAttributes.getVitality());
        secondaryAttributes.setArmorRating(totalAttributes.getDexterity(), totalAttributes.getStrength());
        secondaryAttributes.setElementalResistance(totalAttributes.getIntelligence());
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public PrimaryAttributes getTotalAttributes() {
        return totalAttributes;
    }

    public SecondaryAttributes getSecondaryAttributes() {
        return secondaryAttributes;
    }

    public void setSecondaryAttributes(SecondaryAttributes secondaryAttributes) {
        this.secondaryAttributes = secondaryAttributes;
    }

    public PrimaryAttributes getBaseAttributes() {
        return baseAttributes;
    }

    public PrimaryAttributes getEquipmentAttributes() {
        return equipmentAttributes;
    }


}


