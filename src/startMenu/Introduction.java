package startMenu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * Panel that shows up when players start the game. This contains information about the game
 * @author Muhammad Abdulkhuder, Sebastian Viro
 */
public class Introduction extends JPanel {

	private JLabel lblTitel = new JLabel("Welcome to Rise!");
	private JLabel lblPic = new JLabel();
	private JFrame frame;
	private JTextArea taText = new JTextArea();
	private Font fontTitel = new Font("ALGERIAN", Font.ITALIC, 20);
	private Font fontText = new Font("Gabriola", Font.ITALIC, 22);

	/**
	 * Constructor that calls upon method which draws gui
	 */
	public Introduction() {
		startGUI();
	}

	/**
	 * Creates gui
	 */
	private void startGUI() {
		setPreferredSize(new Dimension(600, 350));
		lblTitel.setBounds(87, -20, 411, 86);
		taText.setAlignmentX(Component.RIGHT_ALIGNMENT);
		taText.setBounds(10, 53, 600, 286);
		lblTitel.setFont(fontTitel);
		lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
		taText.setText("Salutations adventurers and welcome to Rise! The people you see next to you are no longer your friends. This is a race to the top where only one will triumph as king! \r\n" + 
				"\r\n" + 
				"You start as peasants and will rise through the ranks when your total wealth reaches a certain number. Player one will now begin by rolling the dice and then after that the player will press the end turn button to let the next player begin his turn. To know more press the info button in the menu tab. Now good luck on your adventures!  \r\n" + 
				"");
		
		taText.setEditable(false);
		lblTitel.setBackground(Color.black);
		taText.setForeground(Color.black);
		taText.setLineWrap(true);
		taText.setWrapStyleWord(true);
		taText.setFont(fontText);
		setLayout(null);
		taText.setOpaque(false);
		lblPic.setBounds(0, 0, 600, 350);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("images/backpaper.jpg"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		Image resizedImg = img.getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_SMOOTH);

		lblPic.setIcon(new ImageIcon(resizedImg));
		
		add(lblTitel);
		add(taText);
		add(lblPic);
		getFrame();
	}

	 /**
	  * Creates a frame which the panel is shown in.
	  */
    public void getFrame() {
    	frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}