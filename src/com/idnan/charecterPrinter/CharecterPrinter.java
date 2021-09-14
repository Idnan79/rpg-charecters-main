package com.idnan.charecterPrinter;

import com.idnan.charecters.CharacterBase;

/**
 * Charecter printer - displays various charecter attributes.
 */
public class CharecterPrinter {

    /**
     * Displays basic charecter info (name & level)
     *
     * @param characterBase - charecterBase
     */
    public void displayCharecterInfo(CharacterBase characterBase) {

        System.out.printf("Charecter Name- %s\n", characterBase.getName());
        System.out.printf("Level- %s\n", characterBase.getLevel());
        System.out.println("*************");

    }

    /**
     * Displays info about charecter primaryAttributes
     *
     * @param characterBase - characterBase.totalAttributes.
     */
    public void displayPrimaryAttributes(CharacterBase characterBase) {
        System.out.printf("Strength- %s\n", characterBase.getTotalAttributes().getStrength());
        System.out.printf("Dexterity- %s\n", characterBase.getTotalAttributes().getDexterity());
        System.out.printf("Intelligence- %s\n", characterBase.getTotalAttributes().getIntelligence());
        //System.out.printf("Vitality- %s\n", getTotalAttributes().getVitality());
        System.out.println("*************");
    }

    /**
     * Displays info about charecter secondaryAttributes
     *
     * @param characterBase - charecterBase.secondaryAttribute
     */
    public void displaySecondaryAttributes(CharacterBase characterBase) {
        System.out.printf("Health- %s\n", characterBase.getSecondaryAttributes().getHealth());
        System.out.printf("Armor Rating- %s\n", characterBase.getSecondaryAttributes().getArmorRating());
        System.out.printf("Elemental Resistance- %s\n", characterBase.getSecondaryAttributes().getElementalResistance());
        System.out.println("*************");
    }

    /**
     * Displays charecterDamage
     *
     * @param characterBase - charecterBase.calculateDamage()
     * @return - calculated damage (double)
     */
    public double displayDamage(CharacterBase characterBase) {
        return characterBase.calculateDamage();
    }

    /**
     * Displays the overall charecter stats.
     *
     * @param characterBase - charecter-overall stats.
     */
    public void displayStats(CharacterBase characterBase) {

        displayCharecterInfo(characterBase);
        displayPrimaryAttributes(characterBase);
        displaySecondaryAttributes(characterBase);
        System.out.printf("DPS- %.2f", displayDamage(characterBase));

    }

}
