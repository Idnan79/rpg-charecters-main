package com.idnan;

import com.idnan.charecters.Mage;
import com.idnan.charecters.Ranger;
import com.idnan.charecters.Rogue;
import com.idnan.charecters.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharecterTests {

    private Mage mage;
    private Rogue rogue;
    private Warrior warrior;
    private Ranger ranger;


    @BeforeEach
    public void initializeCharacters() {
        mage = new Mage("Aegwynn");
        rogue = new Rogue("Masques");
        warrior = new Warrior("Amastan");
        ranger = new Ranger("Gelgen");
    }

    @Test
    public void getLevel_InitializedCharecter_StartingLevelOne() {
        assertEquals(1, mage.getLevel());
    }

    @Test
    public void levelUp_IncreaseLevelByOne_ShouldIncrementByOne() {
        mage.levelUp(1);
        assertEquals(2, mage.getLevel());
    }

    @Test
    public void levelUp_ByZeroOrLess_ShouldYieldException() {
        assertThrows(IllegalArgumentException.class, () -> {
            mage.levelUp(0);
            mage.levelUp(-1);
        });
    }

    @Test
    public void primaryAttributes_CorrectDefaultValues_whenMageIsCreated() {
        int[] defaultValue = {mage.getBaseAttributes().getVitality(), mage.getBaseAttributes().getStrength(),
                mage.getBaseAttributes().getDexterity(), mage.getBaseAttributes().getIntelligence()};
        int[] expectedValues = {5, 1, 1, 8};
        assertArrayEquals(expectedValues, defaultValue);
    }

    @Test
    public void primaryAttributes_CorrectDefaultValues_whenRogueIsCreated() {
        int[] defaultValues = {rogue.getBaseAttributes().getVitality(), rogue.getBaseAttributes().getStrength(),
                rogue.getBaseAttributes().getDexterity(), rogue.getBaseAttributes().getIntelligence()};
        int[] expectedValues = {8, 2, 6, 1};
        assertArrayEquals(expectedValues, defaultValues);
    }

    @Test
    public void primaryAttributes_CorrectDefaultValues_whenWarriorIsCreated() {
        int[] defaultValues = {warrior.getBaseAttributes().getVitality(), warrior.getBaseAttributes().getIntelligence(),
                warrior.getBaseAttributes().getDexterity(), warrior.getBaseAttributes().getStrength()};
        int[] expectedValues = {10, 1, 2, 5};
        assertArrayEquals(expectedValues, defaultValues);
    }

    @Test
    public void primaryAttributes_CorrectDefaultValues_whenRangerIsCreated() {
        int[] defaultValues = {ranger.getBaseAttributes().getVitality(), ranger.getBaseAttributes().getIntelligence(),
                ranger.getBaseAttributes().getDexterity(), ranger.getBaseAttributes().getStrength()};
        int[] expectedValues = {8, 1, 7, 1};
        assertArrayEquals(expectedValues, defaultValues);
    }

    @Test
    public void update_CharecterAttributes_WhenLevelUpMage() {
        mage.levelUp(1);
        int[] defaultValue = {mage.getBaseAttributes().getVitality(), mage.getBaseAttributes().getStrength(),
                mage.getBaseAttributes().getDexterity(), mage.getBaseAttributes().getIntelligence()};

        int[] expectedValues = {8, 2, 2, 13};
        assertArrayEquals(expectedValues, defaultValue);
    }

    @Test
    public void update_CharecterAttributes_WhenLevelUpRogue() {
        rogue.levelUp(1);
        int[] defaultValue = {rogue.getBaseAttributes().getVitality(), rogue.getBaseAttributes().getStrength(),
                rogue.getBaseAttributes().getDexterity(), rogue.getBaseAttributes().getIntelligence()};
        int[] expectedValues = {11, 3, 10, 2};
        assertArrayEquals(expectedValues, defaultValue);
    }

    @Test
    public void update_CharecterAttributes_WhenLevelUpWarrior() {
        warrior.levelUp(1);
        int[] defaultValue = {warrior.getBaseAttributes().getVitality(), warrior.getBaseAttributes().getStrength(),
                warrior.getBaseAttributes().getDexterity(), warrior.getBaseAttributes().getIntelligence()};
        int[] expectedValues = {15, 8, 4, 2};
        assertArrayEquals(expectedValues, defaultValue);
    }

    @Test
    public void update_CharecterAttributes_WhenLevelUpRanger() {
        ranger.levelUp(1);
        int[] defaultValue = {ranger.getBaseAttributes().getVitality(), ranger.getBaseAttributes().getStrength(),
                ranger.getBaseAttributes().getDexterity(), ranger.getBaseAttributes().getIntelligence()};
        int[] expectedValues = {10, 2, 12, 2};
        assertArrayEquals(expectedValues, defaultValue);
    }

    @Test
    public void calculate_SecondaryStats_WhenLevelledUpCharecter() {
        warrior.levelUp(1);
        int[] defaultSecondaryAttributes = {warrior.getSecondaryAttributes().getHealth(),
                warrior.getSecondaryAttributes().getArmorRating(), warrior.getSecondaryAttributes().getElementalResistance()};
        int[] expectedValues = {150, 12, 2};
        assertArrayEquals(expectedValues, defaultSecondaryAttributes);
    }

}