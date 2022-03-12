package model.player;

import model.tiles.Property;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class PlayerTest {

    /**
     * Tests for the Player class
     *
     * Author: Bajram Gerbeshi, Ali Albabily
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

        p.decreaseBalance(-100);

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

    /* Player's ranks related tests */

    @Test
    public void checkSetPlayerRank() {
        Player player = new Player("Alice", null, null, 0);
        player.setPlayerRank(PlayerRanks.KNIGHT);
        assertEquals(PlayerRanks.KNIGHT, player.getPlayerRank());
    }

    @Test
    public void checkDefaultPlayerRank() {
        Player player = new Player("Alice", null, null, 0);
        assertEquals(PlayerRanks.PEASANT, player.getPlayerRank());
    }

    @Test
    public void checkIfPlayerReachedRankKnight() {
        Player player = new Player("Alice", null, null, 0);
        player.increaseNetWorth(500);
        player.checkPlayerRank();
        assertEquals(PlayerRanks.KNIGHT, player.getPlayerRank());
    }

    @Test
    public void checkIfPlayerReachedRankLord() {
        Player player = new Player("Alice", null, null, 0);
        player.increaseNetWorth(2500);
        player.checkPlayerRank();
        assertEquals(PlayerRanks.LORD, player.getPlayerRank());
    }

    @Test
    public void checkIfPlayerReachedRankKings() {
        Player player = new Player("Alice", null, null, 0);
        player.increaseNetWorth(6000);
        player.checkPlayerRank();
        assertEquals(PlayerRanks.KINGS, player.getPlayerRank());
    }

    /* Player's properties related tests */

    @Test
    public void checkDefaultNumberOfPlayerProperties() {
        Player player = new Player("Alice", null, null, 0);
        assertEquals(0, player.getProperties().size());
    }

    @Test
    public void checkIfNumberOfPlayerPropertiesIncreased() {
        Player player = new Player("Alice", null, null, 0);
        Property woodCutterCamp = new Property("Wood Cutter Camp", 60, 2, 30, new Color(58,20,56,255), 50,new ImageIcon("tilePics/Wood.png"));
        player.addNewProperty(woodCutterCamp);
        assertEquals(1, player.getProperties().size());
    }

    @Test
    public void checkIfNumberOfPlayerPropertiesDecreased() {
        Player player = new Player("Alice", null, null, 0);
        Property woodCutterCamp = new Property("Wood Cutter Camp", 60, 2, 30, new Color(58,20,56,255), 50,new ImageIcon("tilePics/Wood.png"));
        Property fishStand = new Property("Fish Stand", 100, 6, 40, new Color(131, 166, 219, 255),50 ,new ImageIcon("tilePics/fish.png"));
        player.addNewProperty(woodCutterCamp);
        player.addNewProperty(fishStand);
        player.removeProperty(fishStand);
        assertEquals(1, player.getProperties().size());
    }
}
