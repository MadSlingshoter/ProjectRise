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

    public PlayerList getPlayerList() {
        return playerList;
    }
}
