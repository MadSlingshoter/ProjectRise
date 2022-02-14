package player;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PlayerTest {


    @Test
    public void setName(){

        Player p = new Player("Bajram", null, 1);
        p.setName("John\n");
        assertEquals("John\n", p.getName());

    }

    @Test
    public void getName(){

        Player p = new Player("null", null, 1);
        assertEquals("null", p.getName());

    }


    @Test
    public void getPlayerIndex(){

        Player p = new Player(null, null, 1);
        assertEquals(1, p.getPlayerIndex());

    }

    @Test
    public void setPlayerIndex(){

        Player p = new Player(null, null, 1);
        p.setPlayerIndex(2);
        assertEquals(2, p.getPlayerIndex());

    }

    @Test
    public void setBalance(){
        Player p = new Player(null, null, 1);

        p.setBalance(3);

        assertEquals(3, p.getBalance());
    }

    @Test
    public void IncreaseBalance(){
        Player p = new Player(null, null, 1);

        p.increaseBalance(5);

        assertEquals(1505, p.getBalance());

    }


    /**
     * Decrease balance works as imagined, (if you add -balance, then it increases because minus minus is a plus in mathematics.
     */
    @Test
    public void decreaseBalace(){
        Player p = new Player(null, null, 1);

        p.decreaseBalace(-100);

        assertEquals(1600, p.getBalance());

    }

    @Test
    public void setAlive(){
        Player p = new Player(null, null,1);

        p.setIsAlive(true);
        assertTrue(p.isAlive());

        p.setIsAlive(false);
        assertFalse(p.isAlive());

    }

    @Test
    public void color(){

        Player p = new Player("Bajram", null , null , 1);

       Color c =  p.getPlayerColor();

       assertEquals(null, c);

    }


}
