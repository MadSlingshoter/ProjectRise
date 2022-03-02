package controller;

import model.Dice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testing class for double dice rolls
 * @author Nicholas Narvell & Marcus Juninger
 * @date 2022-03-01
 */
class GameLogicTest {

    static GameLogic gl = new GameLogic();
    static Dice dice = new Dice();

    @Test
    public void checkRoll11() {
        int[] ints = {1,1};
        dice.setTotalRoll(2);

        gl.checkRoll(ints, dice);
        assertEquals(4,dice.getTotalRoll());
    }

    @Test
    void checkRoll12() {
        int[] ints = {1,2};
        dice.setTotalRoll(3);
        gl.checkRoll(ints, dice);
        assertEquals(3,dice.getTotalRoll());
    }
    @Test
    void checkRoll13() {
        int[] ints = {1,3};
        dice.setTotalRoll(4);
        gl.checkRoll(ints, dice);
        assertEquals(4,dice.getTotalRoll());
    }
    @Test
    void checkRoll14() {
        int[] ints = {1,4};
        dice.setTotalRoll(5);
        gl.checkRoll(ints, dice);
        assertEquals(5,dice.getTotalRoll());
    }
    @Test
    void checkRoll15() {
        int[] ints = {1,5};
        dice.setTotalRoll(6);
        gl.checkRoll(ints, dice);
        assertEquals(6,dice.getTotalRoll());
    }
    @Test
    void checkRoll16() {
        int[] ints = {1,6};
        dice.setTotalRoll(7);
        gl.checkRoll(ints, dice);
        assertEquals(7,dice.getTotalRoll());
    }
    @Test
    void checkRoll21() {
        int[] ints = {2,1};
        dice.setTotalRoll(3);
        gl.checkRoll(ints, dice);
        assertEquals(3,dice.getTotalRoll());
    }
    @Test
    void checkRoll22() {
        int[] ints = {2,2};
        dice.setTotalRoll(4);
        gl.checkRoll(ints, dice);
        assertEquals(8,dice.getTotalRoll());
    }
    @Test
    void checkRoll23() {
        int[] ints = {2,3};
        dice.setTotalRoll(5);
        gl.checkRoll(ints, dice);
        assertEquals(5,dice.getTotalRoll());
    }
    @Test
    void checkRoll24() {
        int[] ints = {2,4};
        dice.setTotalRoll(6);
        gl.checkRoll(ints, dice);
        assertEquals(6,dice.getTotalRoll());
    }
    @Test
    void checkRoll25() {
        int[] ints = {2,5};
        dice.setTotalRoll(7);
        gl.checkRoll(ints, dice);
        assertEquals(7,dice.getTotalRoll());
    }
    @Test
    void checkRoll26() {
        int[] ints = {2,6};
        dice.setTotalRoll(8);
        gl.checkRoll(ints, dice);
        assertEquals(8,dice.getTotalRoll());
    }
    @Test
    void checkRoll31() {
        int[] ints = {3,1};
        dice.setTotalRoll(4);
        gl.checkRoll(ints, dice);
        assertEquals(4,dice.getTotalRoll());
    }
    @Test
    void checkRoll32() {
        int[] ints = {3,2};
        dice.setTotalRoll(5);
        gl.checkRoll(ints, dice);
        assertEquals(5,dice.getTotalRoll());
    }
    @Test
    void checkRoll33() {
        int[] ints = {3,3};
        dice.setTotalRoll(6);
        gl.checkRoll(ints, dice);
        assertEquals(12,dice.getTotalRoll());
    }
    @Test
    void checkRoll34() {
        int[] ints = {3,4};
        dice.setTotalRoll(7);
        gl.checkRoll(ints, dice);
        assertEquals(7,dice.getTotalRoll());
    }
    @Test
    void checkRoll35() {
        int[] ints = {3,5};
        dice.setTotalRoll(8);
        gl.checkRoll(ints, dice);
        assertEquals(8,dice.getTotalRoll());
    }
    @Test
    void checkRoll36() {
        int[] ints = {3,6};
        dice.setTotalRoll(9);
        gl.checkRoll(ints, dice);
        assertEquals(9,dice.getTotalRoll());
    }
    @Test
    void checkRoll41() {
        int[] ints = {4,1};
        dice.setTotalRoll(5);
        gl.checkRoll(ints, dice);
        assertEquals(5,dice.getTotalRoll());
    }
    @Test
    void checkRoll42() {
        int[] ints = {4,2};
        dice.setTotalRoll(6);
        gl.checkRoll(ints, dice);
        assertEquals(6,dice.getTotalRoll());
    }
    @Test
    void checkRoll43() {
        int[] ints = {4,3};
        dice.setTotalRoll(7);
        gl.checkRoll(ints, dice);
        assertEquals(7,dice.getTotalRoll());
    }
    @Test
    void checkRoll44() {
        int[] ints = {4,4};
        dice.setTotalRoll(8);
        gl.checkRoll(ints, dice);
        assertEquals(16,dice.getTotalRoll());
    }
    @Test
    void checkRoll45() {
        int[] ints = {4,5};
        dice.setTotalRoll(9);
        gl.checkRoll(ints, dice);
        assertEquals(9,dice.getTotalRoll());
    }
    @Test
    void checkRoll46() {
        int[] ints = {4,6};
        dice.setTotalRoll(10);
        gl.checkRoll(ints, dice);
        assertEquals(10,dice.getTotalRoll());
    }
    @Test
    void checkRoll51() {
        int[] ints = {5,1};
        dice.setTotalRoll(6);
        gl.checkRoll(ints, dice);
        assertEquals(6,dice.getTotalRoll());
    }
    @Test
    void checkRoll52() {
        int[] ints = {5,2};
        dice.setTotalRoll(7);
        gl.checkRoll(ints, dice);
        assertEquals(7,dice.getTotalRoll());
    }
    @Test
    void checkRoll53() {
        int[] ints = {5,3};
        dice.setTotalRoll(8);
        gl.checkRoll(ints, dice);
        assertEquals(8,dice.getTotalRoll());
    }
    @Test
    void checkRoll54() {
        int[] ints = {5,4};
        dice.setTotalRoll(9);
        gl.checkRoll(ints, dice);
        assertEquals(9,dice.getTotalRoll());
    }
    @Test
    void checkRoll55() {
        int[] ints = {5,5};
        dice.setTotalRoll(10);
        gl.checkRoll(ints, dice);
        assertEquals(20,dice.getTotalRoll());
    }
    @Test
    void checkRoll56() {
        int[] ints = {5,6};
        dice.setTotalRoll(11);
        gl.checkRoll(ints, dice);
        assertEquals(11,dice.getTotalRoll());
    }
    @Test
    void checkRoll61() {
        int[] ints = {6,1};
        dice.setTotalRoll(7);
        gl.checkRoll(ints, dice);
        assertEquals(7,dice.getTotalRoll());
    }
    @Test
    void checkRoll62() {
        int[] ints = {6,2};
        dice.setTotalRoll(8);
        gl.checkRoll(ints, dice);
        assertEquals(8,dice.getTotalRoll());
    }
    @Test
    void checkRoll63() {
        int[] ints = {6,3};
        dice.setTotalRoll(9);
        gl.checkRoll(ints, dice);
        assertEquals(9,dice.getTotalRoll());
    }
    @Test
    void checkRoll64() {
        int[] ints = {6,4};
        dice.setTotalRoll(10);
        gl.checkRoll(ints, dice);
        assertEquals(10,dice.getTotalRoll());
    }
    @Test
    void checkRoll65() {
        int[] ints = {6,5};
        dice.setTotalRoll(11);
        gl.checkRoll(ints, dice);
        assertEquals(11,dice.getTotalRoll());
    }
    @Test
    void checkRoll66() {
        int[] ints = {6,6};
        dice.setTotalRoll(12);
        gl.checkRoll(ints, dice);
        assertEquals(24,dice.getTotalRoll());
    }
}