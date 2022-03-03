package view.startMenu;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import controller.GameLogic;

/**
 * First screen which Model.player sees, here he is able to choose the amount of players and
 * what names and colors the players will have during the game.
 * @author Aevan Dino
 * Updated 2022-03-03 by Mattias Bengtsson to move initialization to inside methods and moving variables
 * to local variables.
 */
public class StartingScreen extends JFrame {

	private static final long serialVersionUID = 1L;

	private GameLogic controller;

	private JButton btnConfirm;
	private JButton btnStartGame;
	private JButton btnReset;

	private ImageIcon imgBackground = new ImageIcon(
			new ImageIcon("images/fancyRoll.jpg").getImage().getScaledInstance(900, 860, Image.SCALE_SMOOTH));

	private JPanel pnlPlayerInfo;

	private JRadioButton[] radioButtons;

	private JLabel[] playerLabels;

	private JTextField[] playerTf;

	private JComboBox[] playerColors;

	/**
	 * Mute button
	 * Updated 2022-02-04 for better overall usability.
	 * Changed from Checkbox to Toggle button.
	 * /Marcus Juninger
	 */
	private JToggleButton mute;

	private int amountOfPlayers;

	public StartingScreen(GameLogic controller) {
		this.controller = controller;
	}
	
	/**
	 * Method to initialize the GUI.
	 */
	public void initializeGUI() {
		createFrame();

		/**
		 * JPanel for information about players
		 */
		pnlPlayerInfo = new JPanel();
		pnlPlayerInfo.setBounds(0, 0, 900, 830);
		pnlPlayerInfo.setOpaque(false);
		pnlPlayerInfo.setLayout(null);

		/**
		 * Label used to create a background
		 */
		JLabel lblBackground = new JLabel("", imgBackground, JLabel.CENTER);
		lblBackground.setBounds(0, 0, 900, 830);
		lblBackground.setLayout(null);

		/**
		 * Header reading "RISE"
		 */
		Font fontHeader = new Font("Gabriola", Font.BOLD, 92);
		JLabel lblRise = new JLabel("RISE");
		lblRise.setFont(fontHeader);
		lblRise.setBounds(375, 125, 175, 200);
		lblBackground.add(lblRise);

		/**
		 * JLabel reading "How many players?"
		 */
		Font fontLabel = new Font("Gabriola", Font.BOLD, 42);
		JLabel lblPlayer = new JLabel("How many players?");
		lblPlayer.setFont(fontLabel);
		lblPlayer.setBounds(315, 175, 300, 200);

		/**
		 * Create three JRadioButtons
		 */
		createRadioButtons();

		/**
		 * Confirm button
		 */
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(375, 345, 150, 30);
		btnConfirm.addActionListener(new ButtonListener());

		/**
		 * Create players
		 */
		createPlayers();

		/**
		 * Start game button
		 */
		btnStartGame = new JButton("Start Game");
		btnStartGame.setBounds(350, 530, 200, 40);
		btnStartGame.setVisible(false);
		btnStartGame.addActionListener(new ButtonListener());

		/**
		 * Reset button
		 */
		btnReset = new JButton("Reset");
		btnReset.setBounds(375, 575, 150, 30);
		btnReset.setVisible(false);
		btnReset.addActionListener(new ButtonListener());

		/**
		 * Mute button
		 * Updated 2022-02-04 for better overall usability.
		 * Now looks more like a proper on/off toggle switch instead of a checkbox.
		 * /Marcus Juninger.
		 */
		mute = new JToggleButton("Music: On");
		mute.setBounds(10, 740, 100, 40);
		mute.addActionListener(new ButtonListener());

		/**
		 * Adding stuff to background label
		 */
		lblBackground.add(lblRise);
		lblBackground.add(lblPlayer);
		lblBackground.add(btnConfirm);
		lblBackground.add(pnlPlayerInfo);
		lblBackground.add(btnReset);
		lblBackground.add(btnStartGame);
		lblBackground.add(mute);
		add(lblBackground);

		/**
		 * Updated 2022-03-03 by Mattias Bengtsson. Moved method call here to fix 
		 */
		setVisible(true);
	}

	public void createFrame() {
		setSize(900, 830);
		setTitle("Choose Player!");
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Methods create radio buttons using for-loop
	 */
	public void createRadioButtons() {
		radioButtons = new JRadioButton[3];
		ButtonGroup btnGroup = new ButtonGroup();
		Font fontRadioButtons = new Font("Gabriola", Font.PLAIN, 24);
		for (int i = 0; i < radioButtons.length; i++) {
			JRadioButton btnRadio = new JRadioButton((i + 2) + "");
			btnRadio.setBounds(375 + i * 65, 275, 50, 50);
			btnRadio.setFont(fontRadioButtons);
			btnRadio.setOpaque(false);
			btnGroup.add(btnRadio);
			radioButtons[i] = btnRadio;
			add(btnRadio);
		}
	}
	
	/**
	 * Creates all players, textfields, labels and color choice boxes
	 * Updated 2022-03-03 by Mattias Bengtsson to unify the color selection boxes.
	 */
	public void createPlayers() {
		Font fontLabelPlayer = new Font("Gabriola", Font.BOLD, 30);
		String[] colors = new String[]  { "RED", "GREEN", "ORANGE", "YELLOW", "CYAN", "MAGENTA" };
		playerLabels = new JLabel[4];
		playerTf = new JTextField[4];
		playerColors = new JComboBox[4];
		for (int i = 0; i < 4; i++) {
			playerLabels[i] = new JLabel("Player" + (i+1) + ":");
			playerLabels[i].setBounds(280, 360 + i * 40, 150, 50);
			playerLabels[i].setFont(fontLabelPlayer);
			playerLabels[i].setVisible(false);

			playerTf[i] = new JTextField("Name" + (i+1) + "...");
			playerTf[i].setBounds(375, 360 + i * 40, 150, 30);
			playerTf[i].setVisible(false);
			playerTf[i].addMouseListener(new MouseAction());

			playerColors[i] = new JComboBox<String>(colors);
			playerColors[i].setBounds(530, 360 + i * 40, 100, 30);
			playerColors[i].setVisible(false);
			playerColors[i].setSelectedIndex(i);

			pnlPlayerInfo.add(playerLabels[i]);
			pnlPlayerInfo.add(playerTf[i]);
			pnlPlayerInfo.add(playerColors[i]);
		}
	}

	/**
	 *
	 * Buttonlistener class, listens for clicks.
	 * @author Aevan Dino
	 */
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnReset) {
				btnPressed(4, false);
			}

			if (e.getSource() == mute) {
				if (mute.getText().equals("Music: Off")) {
					mute.setText("Music: On");
					controller.startMusic();
				} else {
					mute.setText("Music: Off");
					controller.pauseMusic();
				}
			}
			/**
			 * Updated 2022-03-01 by Susanne Vikstr�m, to show the Confirm button when player Reset players
			 */

			if (e.getSource() == btnConfirm) {
				if (radioButtons[0].isSelected()) {
					btnPressed(2, true);
					amountOfPlayers = 2;
				} else if (radioButtons[1].isSelected()) {
					btnPressed(3, true);
					amountOfPlayers = 3;

				} else if (radioButtons[2].isSelected()) {
					btnPressed(4, true);
					amountOfPlayers = 4;
				}
			}

			if (e.getSource() == btnStartGame) {

				/**
				 * Updated 2022-02-04 by Marcus Juninger to handle whitespace usernames in bug B4.
				 * Updated 2022-03-01 by Susanne Vikstr�m, to handle identical usernames, see bug B16.
				 * Updated 2022-03-03 by Mattias Bengtsson to handle identical color choices in bug B7 and for handling
				 * when information has been entered before Reset has been clicked.
				 */
				if(!checkBlankNames()) {
					JOptionPane.showMessageDialog(null, "All players must have a name. Names can not be blank.");
				} else if(!checkSameName()){
					JOptionPane.showMessageDialog(null, "Players cannot have the same name. Please pick different names for all players.");
				} else if (!checkColors()){
					JOptionPane.showMessageDialog(null, "Two or more players are not allowed to have the same color");
				} else {
					startUpGame();
				}
			}
		}

		/**
		 * Added 2022-03-03 by Mattias Bengtsson
		 * Checks if all players have a non-blank name. For B29.
		 * @return true if all players have a non-blank name, false otherwise
		 */
		private boolean checkBlankNames() {
			boolean ok = true;
			for (int i = 0; i < amountOfPlayers && ok; i++) {
				if (playerTf[i].getText().isBlank()) {
					ok = false;
				}
			}
			return ok;
		}

		/**
		 * Added 2022-03-03 by Mattias Bengtsson
		 * Checks if all players have chosen a unique name. For B29.
		 * @return true if all unique names, false otherwise
		 */
		private boolean checkSameName() {
			boolean ok = true;
			for (int i = 0; i < amountOfPlayers && ok; i++) {
				for (int j = i+1; j < amountOfPlayers && ok; j++) {
					if (playerTf[i].getText().equals(playerTf[j].getText())) {
						ok = false;
					}
				}
			}
			return ok;
		}

		/**
		 * Added 2022-03-03 by Mattias Bengtsson
		 * Checks if all players have chosen a unique color. For B7 and B29.
		 * @return true if all unique colors, false otherwise
		 */
		private boolean checkColors() {
			boolean ok = true;
			for (int i = 0; i < amountOfPlayers-1 && ok; i++) {
				for (int j = i+1; j < amountOfPlayers && ok; j++) {
					if (playerColors[i].getSelectedItem().equals(playerColors[j].getSelectedItem())) {
						ok = false;
					}
				}
			}
			return ok;
		}

		/**
		 * Method called when player clicks start game
		 */
		public void startUpGame() {
			String[] playerNameStr = playerNamesToStr();
			String[] playerColorStr = playerColorsToStr();
			controller.startNewGame(playerNameStr, playerColorStr);

			dispose();
		}
		
		/**
		 * Creates the right amount of players.
		 */
		private String[] playerNamesToStr() {
			String[] playerNameStr = new String[amountOfPlayers];
			for (int i = 0; i < amountOfPlayers; i++) {
				if (playerTf[i].getText().length()>=10) {
					playerTf[i].setText(playerTf[i].getText().substring(0, 10));
				}
				playerNameStr[i] = playerTf[i].getText();
			}
			return playerNameStr;
		}

		private String[] playerColorsToStr() {
			String[] playerColorStr = new String[amountOfPlayers];
			for (int i = 0; i < amountOfPlayers; i++) {
				playerColorStr[i] = (String) playerColors[i].getSelectedItem();
			}
			return playerColorStr;
		}
		
		/**
		 * Updated 2022-03-01 by Susanne Vikstr�m, to show the Confirm button when player Reset players (B25)
		 * Whenever player chooses to reset the start screen
		 * @param amountOfPlayers, how many players to draw
		 * @param bool, boolean indicating whether or not components should be visible.
		 */
		public void btnPressed(int amountOfPlayers, boolean bool) {
			for (int i = 0; i < amountOfPlayers; i++) {
				playerLabels[i].setVisible(bool);
				playerTf[i].setVisible(bool);
				playerColors[i].setVisible(bool);
			}
			btnStartGame.setVisible(bool);
			btnReset.setVisible(bool);
			btnConfirm.setVisible(!bool);
			for (JRadioButton radioButton : radioButtons) {
				radioButton.setEnabled(!bool);
			}
		}
	}

	/**
	 * MouseClickedListener for the name inserting so the text disappear when the player clicks.
	 */
	private class MouseAction implements MouseListener{
		int counter0 = 0, counter1 = 0, counter2 =0, counter3 =0;
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == playerTf[0]) {
				if(counter0 <1) {
					counter0++;
					playerTf[0].setText(null);
				}
			}
			if(e.getSource() == playerTf[1]) {
				if(counter1 <1) {
					counter1++;
					playerTf[1].setText(null);
				}
			}
			if(e.getSource() == playerTf[2]) {
				if(counter2 <1) {
					counter2++;
					playerTf[2].setText(null);
				}
			}
			if(e.getSource() == playerTf[3]) {
				if(counter3 <1) {
					counter3++;
					playerTf[3].setText(null);
				}
			}
		}
		/**
		 * Nothing will happen with the other implemented methods. Methods must be implemented by MouseListener.
		 */
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
	}
}