package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.GameLogic;
import view.board.Board;
import view.eastSidePanels.EastSidePanel;
import controller.ManageEvents;
import model.player.PlayerList;

/**
 * @author Muhammad Abdulkhuder, Aevan Dino, Sebastian Viro, Seth Oberg
 *
 */
public class Dice extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private GameLogic controller;

	private ShowPlayersTurn showPlayersTurn;
	private Board board;
	private WestSidePanel westSidePnl;
	private EastSidePanel eastSidePnl = new EastSidePanel();

	private JButton btnEndTurn = new JButton("End Turn");
	private JButton btnRollDice = new JButton("Roll Dice");

	private JLabel lblDice1 = new JLabel();
	private JLabel lblDice2 = new JLabel();

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private ImageIcon faceToShow, showDice;
	private Image resizedImage;
	private Menu menu;

	private int diceWidth = 100;
	private int diceHeight = 100;
	private int roll;

	/**
	 * @param controller the main controller class
	 * @param board The board object
	 * @param westSidePanel panel containing all the information about the tiles and the history of all the events
	 * @param eastSidePnl panel containing all the information about the players and their properties 
	 */
	public Dice(GameLogic controller, Board board, WestSidePanel westSidePanel, EastSidePanel eastSidePnl) {
		this.controller = controller;
		this.board = board;
		this.westSidePnl = westSidePanel;
		this.eastSidePnl = eastSidePnl;

		initializePanel();

	}

	/**
	 * calls the method that initializes the panel
	 */
	public Dice() {

		initializePanel();
		
	}

	/**
	 * initializes Panel
	 */
	public void initializePanel() {
		
		setPreferredSize(new Dimension(650, 109));
		setLayout(new FlowLayout());
		setOpaque(false);
		
		showPlayersTurn = new ShowPlayersTurn("Player");
		add(showPlayersTurn);
		
		
		add(lblDice1);

		add(lblDice2);

		btnRollDice.setFont(new Font("Algerian", Font.PLAIN, 14));
		add(btnRollDice);

		btnRollDice.addActionListener(this);

		faceToShow = new ImageIcon("DicePictures/faceValue1White.png");
		resizedImage = faceToShow.getImage().getScaledInstance(diceWidth, diceHeight, Image.SCALE_SMOOTH);
		showDice = new ImageIcon(resizedImage);
		lblDice2.setIcon(showDice);
		lblDice1.setIcon(showDice);

		btnEndTurn.setFont(new Font("Algerian", Font.PLAIN, 14));
		btnEndTurn.addActionListener(this);

		add(btnEndTurn);
//		add(cheat); //Enable for testing with cheater.
		btnEndTurn.setEnabled(false);

		showPlayersTurn.updateGUI(controller.getPlayerList().getActivePlayer().getName(),
				controller.getPlayerList().getActivePlayer().getPlayerColor());
	}

	

	/**
	 * Action Listener that handles what happens if the buttons are pressed
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnRollDice) {
			btnRollDice.setEnabled(false);

			int[] diceFaceValue = controller.rollDice();

			resizedImage = faceToShow(diceFaceValue[0]).getImage().getScaledInstance(diceWidth, diceHeight, Image.SCALE_SMOOTH);
			showDice = new ImageIcon(resizedImage);
			lblDice1.setIcon(showDice);

			resizedImage = faceToShow(diceFaceValue[1]).getImage().getScaledInstance(diceWidth, diceHeight, Image.SCALE_SMOOTH);
			showDice = new ImageIcon(resizedImage);
			lblDice2.setIcon(showDice);
		}
		
		/**
		 * When a player ends their turn
		 * If the next player is in jail they will not have the ability to roll the
		 * dice and will only have the ability to end their turn if they have not paid the bail
		 * If the player is not in jail they can roll the dice
		 */
		if (e.getSource() == btnEndTurn) {
			showPlayersTurn.updateGUI(controller.getPlayerList().getActivePlayer().getName(),
					controller.getPlayerList().getActivePlayer().getPlayerColor());
			
			controller.endTurn();
		}

	}

	public ImageIcon faceToShow(int faceValue) {
		ImageIcon faceToShow = new ImageIcon();
		switch (faceValue) {
			case 1:
				faceToShow = new ImageIcon("DicePictures/faceValue1White.png");
				break;

			case 2:
				faceToShow = new ImageIcon("DicePictures/faceValue2White.png");
				break;

			case 3:
				faceToShow = new ImageIcon("DicePictures/faceValue3White.png");
				break;

			case 4:
				faceToShow = new ImageIcon("DicePictures/faceValue4White.png");
				break;

			case 5:
				faceToShow = new ImageIcon("DicePictures/faceValue5White.png");
				break;

			case 6:
				faceToShow = new ImageIcon("DicePictures/faceValue6White.png");
				break;
		}
		return faceToShow;
	}

//	public void resetGame() {
//		menu.restartGame();
//	}


	/**
	 * To free the prisoner
	 */
	public void activateRollDice() {
		btnRollDice.setEnabled(true);
		btnEndTurn.setEnabled(false);
	}

	public void activateEndTurnDice() {
		btnEndTurn.setEnabled(true);
	}

	public void deactivateAllDiceBtn() {
		btnRollDice.setEnabled(false);
		btnEndTurn.setEnabled(false);
	}

	public void enableBtnEndTurn(boolean enable) {
		btnEndTurn.setEnabled(enable);
	}

	public void enableBtnRollDice(boolean enable) {
		btnRollDice.setEnabled(enable);
	}

	/**
	 * Ends the turn if player is eliminated
	 */
	public void endTurnIfPlayerEliminated() {
		btnRollDice.setEnabled(true);
		btnEndTurn.setEnabled(false);
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}


}