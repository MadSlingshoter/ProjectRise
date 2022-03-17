package model.player;

import controller.GameLogic;
import controller.ManageEvents;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.EventsPanel;

import javax.swing.*;


class PlayerIndexTest {

    Player testPlayer;
    Player testPlayer2;
    Player testPlayer3;
    ManageEvents manageEvents;
    GameLogic controller;
    EventsPanel eventsPanel;

    /**
     * Tests for checking player indexes after a player has been eliminated
     *
     * Author: Filip Örnling
     */


    @BeforeEach
    public void setUpTest(){
        String[] PlayerNameArray = new String[3];
        String[] PlayerColorArray = new String[3];

        System.out.println("Creating players and setting up for tests");

        testPlayer = new Player("Testplayer",new ImageIcon(),0);
        PlayerNameArray [0] = "Testplayer";
        PlayerColorArray [0]="MAGENTA";


        testPlayer2 = new Player("Testplayer2",new ImageIcon(),1);
        PlayerNameArray [1] = "Testplayer2";
        PlayerColorArray [1]="YELLOW";

        testPlayer3 = new Player("Testplayer3",new ImageIcon(),2);
        PlayerNameArray [2] = "Testplayer3";
        PlayerColorArray [2]="RED";

        controller = new GameLogic();
        controller.startNewGame(PlayerNameArray,PlayerColorArray);
        controller.pauseMusic();

        manageEvents = new ManageEvents(controller);
        eventsPanel = new EventsPanel(manageEvents);


        controller.getPlayerList().addNewPlayer(testPlayer.getName(), "MAGENTA");
        controller.getPlayerList().addNewPlayer(testPlayer2.getName(), "YELLOW");
        controller.getPlayerList().addNewPlayer(testPlayer3.getName(), "RED");
    }

    @Test
    public void playerIndexTest(){
        System.out.println("Player1 index : "+testPlayer.getPlayerIndex());
        System.out.println("Player2 index : "+testPlayer2.getPlayerIndex());
        System.out.println("Player3 index : "+testPlayer3.getPlayerIndex());

        System.out.println("Removing Player 2");
        controller.getPlayerList().switchToNextPlayer();
        controller.getPlayerList().eliminatePlayer(testPlayer2);
        controller.getPlayerList().updatePlayerList();
        controller.updatePlayerInfo();


        System.out.println("Testing the name of the player on index location 1");

        Assert.assertEquals("Testplayer3",controller.getPlayerList().getPlayerFromIndex(1).getName());
    }
    @Test
    public void playerIndexTest2(){
        System.out.println("Player1 index : "+testPlayer.getPlayerIndex());
        System.out.println("Player2 index : "+testPlayer2.getPlayerIndex());
        System.out.println("Player3 index : "+testPlayer3.getPlayerIndex());

        System.out.println("Removing Player 1");
        controller.getPlayerList().switchToNextPlayer();
        controller.getPlayerList().eliminatePlayer(testPlayer);
        controller.getPlayerList().updatePlayerList();
        controller.updatePlayerInfo();


        System.out.println("Testing the name of the player on index location 1");

        Assert.assertEquals("Testplayer2",controller.getPlayerList().getPlayerFromIndex(0).getName());
    }

}