package combinedPanels;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import board.Board;
import dice.Dice;
import eastSidePanels.EastSidePanel;
import menu.Menu;
import player.PlayerList;
import startMenu.BackgroundMusic;
import westSidePanel.WestSidePanel;

/**
 * This class combines most of the panels in the game and adds appropriate
 * references.
 * 
 * @author Abdulkhuder Muhammad
 *
 * Updated 2022-02-05 by Ali Albabily to fix bug B3 in order to restart the game properly.
 */
public class GamePanels extends JPanel {

	private static final long serialVersionUID = 1L;
	private EastSidePanel eastSidePanel = new EastSidePanel();
	private WestSidePanel westPanel = new WestSidePanel();
	private Board board = new Board(westPanel);
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private PlayerList playerList;
	private Dice dice = new Dice(board, playerList, westPanel, eastSidePanel);
	private JFrame frame = new JFrame();
	private JLabel lblPic = new JLabel();
	private Menu menu;
	private int width = screenSize.width;
	private int height = screenSize.height;
	private int boardWidth = 750;
	private int boardHeight = 750;
	private int sidePanelsWidth = 345;
	private int sidePanelsHeight = 860;
	private int gamePosX = (width - ((sidePanelsWidth*2) + boardWidth))/2;
	private int gamePosY = (height - sidePanelsHeight)/2;

	/**
	 * adds the panels and sets the bounds
	 */
	public GamePanels(BackgroundMusic music) {
		menu = new Menu(music, this);
		setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));

		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(width, height));
		setLayout(null);
		eastSidePanel.setOpaque(false);
		eastSidePanel.setBounds(gamePosX+sidePanelsWidth+boardWidth, gamePosY, sidePanelsWidth, sidePanelsHeight);
		add(eastSidePanel);
		westPanel.setBounds(gamePosX, gamePosY, sidePanelsWidth, sidePanelsHeight);
		add(westPanel);
		board.setBounds(gamePosX+sidePanelsWidth+1, gamePosY, boardWidth, boardHeight);
		add(board);
		dice.setBounds(gamePosX+sidePanelsWidth+1, gamePosY+boardHeight+1, boardWidth, 109);
		add(dice);
		menu.setBounds(gamePosX, gamePosY, 50, 18);
		add(menu);

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
	 * @param playerList
	 */
	public void addPlayer(PlayerList playerList) {

		board.addPlayers(playerList);
		board.setPlayers();
		eastSidePanel.addPlayerList(playerList);
		dice.addPlayerList(playerList);

	}

	/**
	 * Disposes the frame
	 */
	public void Dispose() {
		frame.dispose();
	}

}
