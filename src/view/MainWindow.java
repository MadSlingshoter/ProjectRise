package view;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;

import controller.GameLogic;
import view.board.Board;
import view.eastSidePanels.EastSidePanel;
import model.player.PlayerList;

/**
 * This class combines most of the panels in the game and adds appropriate
 * references.
 * 
 * @author Abdulkhuder Muhammad
 *
 * Updated 2022-02-05 by Ali Albabily to fix bug B3 in order to restart the game properly.
 */
public class MainWindow extends JPanel {
	GameLogic controller;
	private static final long serialVersionUID = 1L;
	private EastSidePanel eastPanel;
	private WestSidePanel westPanel;
	private Board board;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private Menu menu;
	private DicePanel dicePanel;
	private JFrame frame = new JFrame();
	private JLabel lblPic = new JLabel();
	private CheatGui cheat;
	private int width = screenSize.width;
	private int height = screenSize.height;
	private int boardWidth = 750;
	private int boardHeight = 750;
	private int sidePanelsWidth = 345;
	private int sidePanelsHeight = 860;
	private int gamePosX = (width - ((sidePanelsWidth*2) + boardWidth))/2;
	private int gamePosY = (height - sidePanelsHeight)/2;
	private JFrame jframe;

	/**
	 * adds the panels and sets the bounds
	 */
	public MainWindow(GameLogic controller) {
		this.controller = controller;
		eastPanel = new EastSidePanel(controller);
		westPanel = new WestSidePanel();
		board = new Board(controller);
		menu = new Menu(controller);
		dicePanel = new DicePanel(controller);
		cheat = new CheatGui(controller);
		setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
		dicePanel.setMenu(menu);
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(width, height));
		setLayout(null);
		eastPanel.setOpaque(false);
		eastPanel.setBounds(gamePosX+sidePanelsWidth+boardWidth, gamePosY, sidePanelsWidth, sidePanelsHeight);
		add(eastPanel);
		westPanel.setBounds(gamePosX, gamePosY, sidePanelsWidth, sidePanelsHeight);
		add(westPanel);
		board.setBounds(gamePosX+sidePanelsWidth+1, gamePosY, boardWidth, boardHeight);
		add(board);
		dicePanel.setBounds(gamePosX+sidePanelsWidth+1, gamePosY+boardHeight+1, boardWidth, 109);
		add(dicePanel);
		menu.setBounds(gamePosX, gamePosY, 50, 18);
		add(menu);
		jframe = new JFrame();
		jframe.add(cheat);
		jframe.setVisible(true);
		jframe.setSize(new Dimension(400,400));

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("images/back2jpg.jpg"));

		} catch (IOException e) {

			e.printStackTrace();
		}

		Image bimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		lblPic.setBounds(0, 0, width, height);

		lblPic.setIcon(new ImageIcon(bimg));
		add(lblPic);

	}

	/**
	 * This is where we call the frame
	 */
	public void startboard() {
		frame = new JFrame("Change your fate");
		frame.setPreferredSize(new Dimension(width + 18, height + 10));
		frame.setLocation(-9, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().add(this);
		frame.pack();
	}

	/**
	 *
	 */
	public void addPlayer() {
		board.setPlayers();
		eastPanel.updatePlayerList();
	}

	/**
	 * Shows a dialog message to the user.
	 * @param str the String to show to the user.
	 */
	public void showMessage(String str) {
		JOptionPane.showMessageDialog(null, str);
	}

	/**
	 * Shows a confirm dialog message to the user.
	 * @param str the String to show to the user.
	 * @return the answer from the user.
	 */
	public int showConfirmDialog(String str) {
		return JOptionPane.showConfirmDialog(null, str);
	}

	/**
	 * Disposes the frame
	 */
	public void Dispose() {
		frame.dispose();
	}

	public DicePanel getDicePanel() {
		return dicePanel;
	}

	public EastSidePanel getEastPanel() {
		return eastPanel;
	}

	public WestSidePanel getWestPanel() {
		return westPanel;
	}

	public Board getBoard() {
		return board;
	}

	public CheatGui getCheat() {
		return cheat;
	}
}
