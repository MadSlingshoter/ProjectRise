package controller;

import model.BackgroundMusic;
import model.player.PlayerList;
import view.CombineGamePanels;
import view.Introduction;
import view.startMenu.StartingScreen;

/**
 * Main controller class.
 * Class for handling the overall logic flow of the game.
 *
 * @author Mattias Bengtsson
 */
public class GameLogic {
    StartingScreen startingScreen;
    private BackgroundMusic bgm;
    private PlayerList playerList;
    private CombineGamePanels mainWindow;
    private ManageEvents manageEvents;
    private Thread movePlayerThread;

    private int roll;

    /**
     * Constructor for GameLogic class.
     */
    public GameLogic() {
        bgm = new BackgroundMusic();
        initializeStartScreen();
    }

    /**
     * Starts the starting screen.
     */
    public void initializeStartScreen() {
        startingScreen = new StartingScreen(this);
        startingScreen.initializeGUI();
        playerList = new PlayerList();
        startMusic();
    }

    /**
     * Sets up the main game window with the information entered from the starting screen.
     * @param playerNames the names of the players.
     * @param playerColors the chosen colors of the players.
     */
    public void startNewGame(String[] playerNames, String[] playerColors) {
        for (int i = 0; i < playerNames.length; i++) {
            playerList.addNewPlayer(playerNames[i], playerColors[i]);
        }
        mainWindow = new CombineGamePanels(this);
        mainWindow.addPlayer(playerList);
        mainWindow.startboard();
        manageEvents = new ManageEvents(this);

        Introduction intro = new Introduction();
    }

    /**
     * Starts the music.
     */
    public void startMusic() {
        bgm.startMusic();
    }

    /**
     * Pauses the music.
     */
    public void pauseMusic() {
        bgm.pauseMusic();
    }

    /**
     * Returns if the music is playing or is paused.
     * @return true if the music is playing, false if the music is paused
     */
    public boolean isMusicActive() {
        return bgm.getClip().isActive();
    }

    /**
     * This method restarts the game
     * @author Ali Albabily, 2022-02-05.
     * Updated by Mattias Bengtsson, 2022-02-22 moved from Menu.java.
     */
    public void restartGame() {
        mainWindow.Dispose(); // closes current CombineGamePanels
        pauseMusic(); // stops playing music
        initializeStartScreen();
    }

    /**
     * Method for clicking the Roll Dice button.
     * Rolls the two dice.
     * @return two dice rolls of random integers from 1 to 6.
     */
    public int[] rollDice() {
        int[] diceRoll = new int[2];
        roll = 0;
        for (int i = 0; i < 2; i++) {
            diceRoll[i] = (int) (Math.random() * (6) + 1);
            roll += diceRoll[i];
        }

        String historyStr = playerList.getActivePlayer().getName();

        if (diceRoll[0] == diceRoll[1]) {
            roll *= 2;
            historyStr += " Rolled a double: ";
        } else {
            historyStr += " Rolled a: ";
        }
        historyStr += roll + "\n";

        updateHistory(historyStr);

        playerList.getActivePlayer().checkPlayerRank();

        movePlayerThread = new Thread(new LoopThread());
        movePlayerThread.start();

//        updatePlayerList(); // tror att denna är onödig

        return diceRoll;
    }

    private void manageEventGrej() {
        goEvent();
        manageEvents.newEvent(mainWindow.getBoard().getDestinationTile(playerList.getActivePlayer().getPosition()),
                playerList.getActivePlayer());
        updatePlayerList();
        mainWindow.getDice().enableBtnEndTurn(true);
    }

    /**
     * If a player passes go.
     */
    private void goEvent() {

        if (playerList.getActivePlayer().passedGo()) {

            playerList.getActivePlayer().increaseBalance(200);
            playerList.getActivePlayer().increaseNetWorth(200);

            mainWindow.getWestPanel().append("Passed Go and received 200 GC\n");
            playerList.getActivePlayer().resetPassedGo();
        }
    }

    /**
     * Determines what happens when the End Turn button is clicked.
     */
    public void endTurn() {
        playerList.switchToNextPlayer();

        if (playerList.getActivePlayer().isPlayerInJail()) {
            mainWindow.getDice().enableBtnRollDice(false);
            mainWindow.getDice().enableBtnEndTurn(true);
            manageEvents.newEvent(mainWindow.getBoard().getDestinationTile(playerList.getActivePlayer().getPosition()),
                    playerList.getActivePlayer());
        } else if (!playerList.getActivePlayer().isPlayerInJail()) {
            mainWindow.getDice().enableBtnRollDice(true);
            mainWindow.getDice().enableBtnEndTurn(false);
            manageEvents.hideEventPanels();
        }

        updatePlayerList();
    }

    /**
     * @param i
     * Cheat method used for Testing
     * it moves the player to a specific index
     */
    public void moveWithCheat(int i) {
        roll = i;
        playerList.getActivePlayer().checkPlayerRank();
        mainWindow.getBoard().removePlayer(playerList.getActivePlayer());
        playerList.getActivePlayer().setPosition(getRoll());
        mainWindow.getBoard().setPlayer(playerList.getActivePlayer());

        goEvent();
        manageEvents.newEvent(mainWindow.getBoard().getDestinationTile(playerList.getActivePlayer().getPosition()),
                playerList.getActivePlayer());
        updatePlayerList();
    }

    public void updateHistory(String str) {
        mainWindow.getWestPanel().append(str);
    }

    public void updatePlayerList() {
        mainWindow.getEastPanel().updatePlayerList(playerList);
    }

    public PlayerList getPlayerList() {
        return playerList;
    }

    public int getRoll() {
        return roll;
    }

    public CombineGamePanels getMainWindow() {
        return mainWindow;
    }

    /**
     * @author Seth �berg, Muhammad Abdulkhuder
     * Moves the player with a thread.
     *
     */
    private class LoopThread implements Runnable {
                public void run() {

            for (int i = 0; i < getRoll(); i++) {
                mainWindow.getBoard().removePlayer(playerList.getActivePlayer());
                playerList.getActivePlayer().setPosition(1);
                mainWindow.getBoard().setPlayer(playerList.getActivePlayer());

                if(i == (getRoll() -1))
                    manageEventGrej();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
