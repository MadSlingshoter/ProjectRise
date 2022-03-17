package model.player;

import controller.GameLogic;
import controller.ManageEvents;
import model.tiles.Property;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.EventsPanel;

import javax.swing.*;
import java.awt.*;

class PlayerGoldTest {

    Player testPlayer;
    Player testPlayer2;
    Property property;
    Property property2;
    ManageEvents manageEvents;
    GameLogic controller;
    EventsPanel eventsPanel;

    /**
     * Tests for checking player balance after purchasing a property
     *
     * Author: Filip Örnling
     */



    @BeforeEach
    public void setupTest(){
        String[] PlayerNameArray = new String[2];
        String[] PlayerColorArray = new String[2];
        testPlayer = new Player("Testplayer",new ImageIcon(),0);

        PlayerNameArray [0] = "Testplayer";
        PlayerColorArray [0]="MAGENTA";


        testPlayer2 = new Player("Testplayer2",new ImageIcon(),1);

        PlayerNameArray [1] = "Testplayer2";
        PlayerColorArray [0]="YELLOW";


        System.out.println("Test player 1 Balance = "+ testPlayer.getBalance());
        System.out.println("Test player 2 Balance = "+ testPlayer2.getBalance());

        System.out.println("Createting Testproprerty with  price of 400");
        property = new Property("TestProperty1",400,50,50, Color.black,25,new ImageIcon());

        System.out.println("Createting Testproprerty2 with price of 500");
        property2 = new Property("TestProperty2",500,55,55, Color.white,30,new ImageIcon());

        controller = new GameLogic();
        controller.startNewGame(PlayerNameArray,PlayerColorArray);
        controller.pauseMusic();



        manageEvents = new ManageEvents(controller);
        eventsPanel = new EventsPanel(manageEvents);
    }

    @Test
    public void checkBalance(){
        System.out.println("Test player 1 buys Testproperty1 with a cost of 400");
        manageEvents.propertyBuy(property,testPlayer);

        System.out.println("Test player 2 buys TestProperty2 with a cost of 500");
        manageEvents.propertyBuy(property2,testPlayer2);

        System.out.println("Testing if TestPlayer1 has the correct new balance after the purchase");
        Assert.assertEquals(1100,testPlayer.getBalance());

        System.out.println("Testing if TestPlayer2 has the correct new balance after the purchase");
        Assert.assertEquals(1000,testPlayer2.getBalance());
    }
    @Test
    public void checkBalance2(){
        System.out.println("Test player 1 buys Testproperty1 with a cost of 400");
        manageEvents.propertyBuy(property,testPlayer);

        System.out.println("Test player 1 buys Testproperty1 with a cost of 400");
        manageEvents.propertyBuy(property,testPlayer);

        System.out.println("Test player 2 buys TestProperty2 with a cost of 500");
        manageEvents.propertyBuy(property2,testPlayer2);

        System.out.println("Testing if TestPlayer1 has the correct new balance after the purchase");
        Assert.assertEquals(700,testPlayer.getBalance());

        System.out.println("Testing if TestPlayer2 has the correct new balance after the purchase");
        Assert.assertEquals(1000,testPlayer2.getBalance());
        
    }

}