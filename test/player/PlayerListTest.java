package player;

import org.junit.Test;
import org.junit.jupiter.api.*;

import java.awt.*;

import static org.junit.Assert.*;

public class PlayerListTest {


    /**
     * Tests for the PlayerList class
     *
     * Author: Bajram Gerbeshi
     *
     * Date: 2022-02-15
     *
     */


    PlayerList PL = new PlayerList();


    @BeforeAll
    public static void setupAll() {
        System.out.println("Should print Before all tests");
    }

    @Test
    public void addNewPlayer() {
    }

    @Test
    @DisplayName("Adding new player and removing it should equal to 0 size total")
    public void addNewPlayerAndRemoveIt() {

        PL.addNewPlayer(null, "null");
        System.out.println(PL.getLength());
        System.out.println(PL.getPlayerFromIndex(0));
        System.out.println(PL.getActivePlayer());
        PL.eliminatePlayer(PL.getActivePlayer());
        System.out.println(PL.getLength());

        assertEquals(0, PL.getLength());

    }

    @Test
    @DisplayName("Creating a new player should list the active player as the same as the first player from the list")
    public void getSamePlayerFromActiveAndIndex() {

        PL.addNewPlayer("John Doe", "null");

        assertEquals(PL.getPlayerFromIndex(0), PL.getActivePlayer());

    }

    @Test
    public void updatePlayer(){

        PL.updatePlayerList();

    }

    @AfterAll
    public static void after() {
        System.out.println("After");
    }

}