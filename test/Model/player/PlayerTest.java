package Model.player;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.awt.*;

import static org.junit.Assert.*;

public class PlayerTest {

    /**
     * Tests for the Player class
     *
     * Author: Bajram Gerbeshi
     *
     * Date: 2022-02-15
     *
     */


    Player p = new Player("John", null, 1);

    @ParameterizedTest
    @ValueSource(strings = {"null", "[$&+,:;=?@#|'<>.-^*()%!]+-", "������", "\uD83D\uDE04", "并且当地政府也鼓励人些方言的人数还是逐渐减" } )
    public void setNames(String fName) {

        Player p = new Player(fName, null, 1);

        assertEquals(fName, p.getName());

        System.out.println(p.getName());

    }

    @Test
    public void getName() {

        assertEquals("John", p.getName());

    }


    @Test
    public void getPlayerIndex() {

        assertEquals(1, p.getPlayerIndex());

    }

    @Test
    public void setPlayerIndex() {

        p.setPlayerIndex(2);
        assertEquals(2, p.getPlayerIndex());

    }

    @Test
    public void setBalance() {

        p.setBalance(3);

        assertEquals(3, p.getBalance());
    }

    @Test
    public void IncreaseBalance() {

        p.increaseBalance(5);

        assertEquals(1505, p.getBalance());

    }


    /**
     * Decrease balance works as imagined, (if you add -balance, then it increases because minus minus is a plus in mathematics.
     */
    @Test
    public void decreaseBalace() {

        p.decreaseBalace(-100);

        assertEquals(1600, p.getBalance());

    }

    @Test
    public void setAlive() {

        p.setIsAlive(true);
        assertTrue(p.isAlive());

        p.setIsAlive(false);
        assertFalse(p.isAlive());

    }

    @Test
    public void color() {
        Color c = p.getPlayerColor();

        assertEquals(null, c);

    }

    @Test
    public void increaseJailCounter() {

        p.increaseJailCounter();
        assertEquals(1, p.getJailCounter());
    }

    @Test
    public void setJailCounterToNumber() {

        int counter = -4;
        p.setJailCounter(counter);
        p.increaseJailCounter();

        System.out.println(p.getJailCounter());
        System.out.println(p.isPlayerInJail());
        assertEquals(-3, p.getJailCounter());
    }

    @Test
    public void playerPos() {

        p.setPosition(10);
        assertEquals(10, p.getPosition());

    }

    @Test
    public void Go(){
        System.out.println(p.passedGo());
    }

    @Test
    @DisplayName("Should be null (inialized as null")
    public void Image(){
        assertNull(p.getImage());
    }
}
