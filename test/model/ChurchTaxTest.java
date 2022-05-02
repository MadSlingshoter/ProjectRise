package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChurchTaxTest {
    /**
     * Tests for checking the functions of the ChurchTax class.
     *
     * Author: Mattias Bengtsson, 2022-05-02
     */

    ChurchTax churchTax;

    @BeforeEach
    public void setupTest() {
        churchTax = new ChurchTax();
    }

    /**
     * Tests the initial pot of the church tax.
     */
    @Test
    public void initialPot() {
        assertEquals(churchTax.getPot(),0);
    }

    /**
     * Tests increasing the counter.
     */
    @Test
    public void increaseCounter() {
        churchTax.increaseCounter();
        assertEquals(churchTax.getPot(), 200);
    }

    /**
     * Tests that the payout gives the correct value.
     */
    @Test
    public void payoutValue() {
        churchTax.increaseCounter();
        assertEquals(churchTax.payout(), 200);
    }

    /**
     * Tests that payout resets the counter.
     */
    @Test
    public void payoutReset() {
        churchTax.increaseCounter();
        churchTax.payout();
        assertEquals(churchTax.getPot(), 0);
    }
}