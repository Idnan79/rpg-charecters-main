package com.idnan.charecters;

import com.idnan.attributes.PrimaryAttributes;
import com.idnan.exceptions.InvalidArmorException;
import com.idnan.exceptions.InvalidWeaponException;
import com.idnan.items.Armor;
import com.idnan.items.Weapon;

public class Warrior extends CharacterBase {


    public Warrior(String name) {
        super(name, new PrimaryAttributes(10, 5, 2, 1));
    }

    @Override
    public void levelUp(int level) {
        increaseCharecterLevel(level);
        updateCharecter(level, 5, 3, 2, 1);
    }


    @Override
    public boolean equip(Weapon weapon) throws InvalidWeaponException {
        switch (weapon.getWeaponType()) {
            case AXE, HAMMER, SWORD -> {
                equipWeapon(weapon);
                return true;
            }
            default -> throw new InvalidWeaponException("Warrior can equip only AXE, HAMMER or SWORD");
        }
    }

    @Override
    public boolean equip(Armor armor) throws InvalidArmorException {
        switch (armor.getArmorType()) {
            case MAIL, PLATE -> {
                equipArmor(armor);
                return true;
            }
            default -> throw new InvalidArmorException("Warrior cannot equip anything other than MAIL or PLATE armor");
        }
    }

    @Override
    public double calculateDamage() {
        double roundDPS = calculateDPS(getTotalAttributes().getStrength());
        return Math.round(roundDPS*100.0)/100.0;
    }
}
