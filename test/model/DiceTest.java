package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    /**
     * Tests for checking the functions of the Dice class.
     *
     * Author: Mattias Bengtsson, 2022-05-02
     */

    Dice dice;

    @BeforeEach
    public void setUpTest() {
        dice = new Dice();
    }

    /**
     * Tests the lowest possible roll.
     */
    @Test
    public void doubleRollLowest() {
        dice.setTotalRoll(2);
        dice.doubleRoll();
        assertEquals(dice.getTotalRoll(),4);
    }

    /**
     * Tests the highest possible roll.
     */
    @Test
    public void doubleRollHighest() {
        dice.setTotalRoll(12);
        dice.doubleRoll();
        assertEquals(dice.getTotalRoll(),24);
    }
}