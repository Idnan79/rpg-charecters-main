package com.idnan.items;

import com.idnan.attributes.PrimaryAttributes;
import com.idnan.equimpent.SlotType;

public class Weapon extends Item {
    private final int damage;
    private final double attackSpeed;
    private final WeaponType weaponType;
    private final PrimaryAttributes primaryAttributes;

    public Weapon(String name, int requiredLevel, int damage, double attackSpeed, WeaponType weaponType, PrimaryAttributes primaryAttributes) {
        super(name, requiredLevel, SlotType.WEAPON);
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.weaponType = weaponType;
        this.primaryAttributes = primaryAttributes;
    }

    public int getDamage() {
        return damage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public double getDPSValue() {
        return this.attackSpeed * this.damage;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public PrimaryAttributes getPrimaryAttributes() {
        return primaryAttributes;
    }
}
