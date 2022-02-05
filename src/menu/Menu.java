package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import board.Rules;
import combinedPanels.GamePanels;
import startMenu.BackgroundMusic;
import startMenu.StartingScreen;

/**
 * This class displays the game board as well as what the players are called and
 * how much they own.
 * 
 * @author Muhammad Hasan, Rohan Samandari
 *
 * Updated 2022-02-05 by Ali Albabily to fix bug B3 in order to restart the game properly.
 */
public class Menu extends JPanel {
	private BackgroundMusic music;
	private JMenu jmMenu = new JMenu("Menu");
	private JMenuBar jmMenuBar = new JMenuBar();
	private JMenuItem jmExit = new JMenuItem("Exit");
	private JMenuItem jmMusicController = new JMenuItem("Stop / Start Music");
	private JMenuItem jmRestart = new JMenuItem("Restart Game");
	private JMenuItem jmRules = new JMenuItem("Read Rules");
	private Rules rules = new Rules();
	private GamePanels gamePanels;
	
	/**
	 * Constructor which draws the gui and sets music reference.
	 * Updated 2022-02-04 by Marcus Juninger to fix bug B2 with music.
	 * @param music
	 * @param gamePanels
	 */
	public Menu(BackgroundMusic music, GamePanels gamePanels) {
		this.music = music;
		this.gamePanels = gamePanels;

		setOpaque(false);
		setPreferredSize(new Dimension(400, 40));
		setLayout(new BorderLayout());
		jmMenuBar.setPreferredSize(new Dimension(100,5));
		jmExit.addActionListener(new ButtonListener());
		jmMusicController.addActionListener(new ButtonListener());
		jmRules.addActionListener(new ButtonListener());
		jmRestart.addActionListener(new ButtonListener());
		jmMenu.add(jmMusicController);
		jmMenu.add(jmRules);
		jmMenu.add(jmRestart);
		jmMenu.add(jmExit);
		jmMenuBar.add(jmMenu);

		add(jmMenuBar, BorderLayout.WEST);
		setBackground(Color.black);
	}
	
	/**
	 * Button listener class used to listen for actions
	 * @author Rohan Samandari
	 *
	 */
	public class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if (e.getSource()== jmMusicController) {
				if (music.getClip().isActive()) {
					music.pauseMusic();
					jmMusicController.setText("Start Music");
				} else {
					music.startMusic();
					jmMusicController.setText("Pause Music");
				}
			} else if (e.getSource()==jmRestart) {
				restartGame();
			} else if (e.getSource()==jmExit) {
				System.exit(0);
			} else if (e.getSource()==jmRules) {
				rules.showRules();
			}
		}
	}

	/**
	 * This method restarts the game
	 * @author Ali Albabily, 2022-02-05.
	 */
	private void restartGame() {
		gamePanels.Dispose(); // closes current GamePanels
		music.pauseMusic(); // stops playing music
		StartingScreen ss = new StartingScreen();
		ss.initializeGUI();
	}
}
