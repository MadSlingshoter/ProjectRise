package controller;

import model.BackgroundMusic;
import model.Dice;
import model.player.Player;
import model.player.PlayerList;
import model.tiles.Property;
import view.MainWindow;
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
    private MainWindow mainWindow;
    private ManageEvents manageEvents;
    private Thread movePlayerThread;
    private Dice dice;
    private ManageTrade manageTrade;

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
        dice = new Dice();
        mainWindow = new MainWindow(this);
        mainWindow.addPlayer();
        mainWindow.startboard();
        mainWindow.getDicePanel().updateShownPlayer(getPlayerList().getActivePlayer().getName(),
                getPlayerList().getActivePlayer().getPlayerColor());
        manageEvents = new ManageEvents(this);
        manageTrade = new ManageTrade(this);

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
        int[] diceRoll = dice.rollDice();

        String historyStr = playerList.getActivePlayer().getName();

        if (diceRoll[0] == diceRoll[1]) {
            dice.doubleRoll();
            historyStr += " Rolled a double: ";
        } else {
            historyStr += " Rolled a: ";
        }
        historyStr += dice.getTotalRoll() + "\n";

        updateHistory(historyStr);

        playerList.getActivePlayer().checkPlayerRank();

        movePlayerThread = new Thread(new LoopThread());
        movePlayerThread.start();

//        updatePlayerList(); // tror att denna är onödig

        return diceRoll;
    }

    private void landOnTile() {
        goEvent();
        manageEvents.newEvent(mainWindow.getBoard().getDestinationTile(playerList.getActivePlayer().getPosition()),
                playerList.getActivePlayer());
        updatePlayerInfo();
        mainWindow.getDicePanel().enableBtnEndTurn(true);
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
            mainWindow.getDicePanel().enableBtnRollDice(false);
            mainWindow.getDicePanel().enableBtnEndTurn(true);
            manageEvents.newEvent(mainWindow.getBoard().getDestinationTile(playerList.getActivePlayer().getPosition()),
                    playerList.getActivePlayer());
        } else if (!playerList.getActivePlayer().isPlayerInJail()) {
            mainWindow.getDicePanel().enableBtnRollDice(true);
            mainWindow.getDicePanel().enableBtnEndTurn(false);
            manageEvents.hideEventPanels();
        }

        mainWindow.getDicePanel().updateShownPlayer(getPlayerList().getActivePlayer().getName(), getPlayerList().getActivePlayer().getPlayerColor());
        updatePlayerInfo();
    }

    /**
     * @param i number of steps to move
     * Cheat method used for Testing
     * it moves the player to a specific index
     */
    public void moveWithCheat(int i) {
        dice.setTotalRoll(i);
        playerList.getActivePlayer().checkPlayerRank();
        mainWindow.getBoard().removePlayer(playerList.getActivePlayer());
        playerList.getActivePlayer().setPosition(getRoll());
        mainWindow.getBoard().setPlayer(playerList.getActivePlayer());

        goEvent();
        manageEvents.newEvent(mainWindow.getBoard().getDestinationTile(playerList.getActivePlayer().getPosition()),
                playerList.getActivePlayer());
        updatePlayerInfo();
        mainWindow.getDicePanel().enableBtnRollDice(false);
        mainWindow.getDicePanel().enableBtnEndTurn(true);
    }

    /**
     * Handles the selling of a selected property.
     * @param playerIndex the index of the player
     * @param propertyIndex the index of the property
     */
    public void sellProperty(int playerIndex, int propertyIndex) {
        Player currPlayer = playerList.getPlayerFromIndex(playerIndex);
        Property currProperty = currPlayer.getPropertyAt(propertyIndex);

        int total = (currProperty.getPrice() + (currProperty.getLevel() * currProperty.getLevelPrice()));

        int res = mainWindow.showConfirmDialog("Do you really want to sell " + currProperty.getName() + " for: " +
                total + "?");
        if (res == 0) {
            currPlayer.sellProperty(currProperty, total);
            updateHistory(currPlayer.getName() + " sold " + currProperty.getName() + "\n");
            updatePlayerInfo();
        }
    }

    /**
     * Handles the upgrading of a selected property.
     * @param playerIndex the index of the player
     * @param propertyIndex the index of the property
     */
    public void upgradeProperty(int playerIndex, int propertyIndex) {
        Player currPlayer = playerList.getPlayerFromIndex(playerIndex);
        Property currProperty = currPlayer.getPropertyAt(propertyIndex);

        if (currPlayer.getBalance()>= currProperty.getLevelPrice()) {
            int res = mainWindow.showConfirmDialog("Do you want to upgrade " + currProperty.getName() + " for: "
                    + currProperty.getLevelPrice());
            if (res == 0) {
                if (currProperty.increaseLevel()) {
                    currPlayer.decreaseBalance(currProperty.getLevelPrice());
                    mainWindow.getEastPanel().getPropertyWindowAt(playerIndex).getPlayerPropertyPanelAt(propertyIndex).upgradeUpdate();
                    updateHistory(currPlayer.getName() + " upgraded " + currProperty.getName() + "\n");
                    updatePlayerInfo();
                } else {
                    mainWindow.showMessage("You need to increase your rank to upgrade this property more.");
                }
            }
        } else {
            mainWindow.showMessage("You do not have enough gold to upgrade this property.");
        }
    }

    /**
     * Handles the downgrading of a selected property.
     * @param playerIndex the index of the player
     * @param propertyIndex the index of the property
     */
    public void downgradeProperty(int playerIndex, int propertyIndex) {
        Player currPlayer = playerList.getPlayerFromIndex(playerIndex);
        Property currProperty = currPlayer.getPropertyAt(propertyIndex);

        int res = mainWindow.showConfirmDialog("Do you really want to downgrade " + currProperty.getName() +
                " for: " + currProperty.getLevelPrice() + "?");
        if (res == 0) {
            if (currProperty.decreaseLevel()) {
                currPlayer.increaseBalance(currProperty.getLevelPrice());
                mainWindow.getEastPanel().getPropertyWindowAt(playerIndex).getPlayerPropertyPanelAt(propertyIndex).downgradeUpdate();
                updateHistory(currPlayer.getName() + " downgraded " + currProperty.getName() + "\n");
                updatePlayerInfo();
            } else {
                mainWindow.showMessage("You cannot downgrade this property more.");
            }
        }
    }

    /**
     * Starts the trade dialog.
     */
    public void trade() {
        manageTrade.startTrade();
    }

    /**
     * Adds a new string to the Game History panel.
     * @param str the string to add.
     */
    public void updateHistory(String str) {
        mainWindow.getWestPanel().append(str);
    }

    /**
     * Refreshes the player information panels.
     */
    public void updatePlayerInfo() {
        mainWindow.getEastPanel().updatePlayerList();
    }

    public PlayerList getPlayerList() {
        return playerList;
    }

    public int getRoll() {
        return dice.getTotalRoll();
    }

    public MainWindow getMainWindow() {
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
                    landOnTile();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
