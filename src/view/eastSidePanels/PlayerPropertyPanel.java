package view.eastSidePanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.GameLogic;
import model.player.Player;
import model.tiles.Property;

/**
 * @author Muhammad Abdulkhuder Aevan Dino sebastian Viro.
 * Updated 2022-02-05 by Mattias Bengtsson: MVC architecture restructuring. Moved controller methods to GameLogic.
 */
public class PlayerPropertyPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblName = new JLabel("Name");
	private JLabel lblPicture = new JLabel("");
	private JLabel lblRent = new JLabel("Rent");
	private JLabel lblRentPerLevel = new JLabel("Rent Per Level");
	private JTextArea taLevel = new JTextArea("");
	private JButton btnUpgrade = new JButton("Upgrade");
	private JButton btnDowngrade = new JButton("Downgrade");
	private JButton btnTrade = new JButton("Trade");
	private JButton btnSell = new JButton("Sell");
	private Font font = new Font("ALGERIAN", Font.BOLD, 22);
	private Font fontLevel = new Font("ALGERIAN", Font.BOLD, 50);
	private GameLogic controller;
	private final int playerIndex, propertyIndex;

	/**
	 * @param controller the main controller class
	 * @param playerIndex the index of the player
	 * @param propertyIndex the index of the property of the player
	 */
	public PlayerPropertyPanel(GameLogic controller, int playerIndex, int propertyIndex) {
		this.controller = controller;
		this.playerIndex = playerIndex;
		this.propertyIndex = propertyIndex;

		setBorder(new EmptyBorder(0,0,0,0));

		setOpaque(false);
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(345, 607));
		setLayout(null);

		lblRent.setForeground(Color.white);
		lblRentPerLevel.setForeground(Color.white);
		lblRent.setText(
				"The Rent is: " + controller.getPlayerList().getPlayerFromIndex(playerIndex).getPropertyAt(propertyIndex).getTotalRent());
		lblRentPerLevel.setText("The rent per level : "
				+ controller.getPlayerList().getPlayerFromIndex(playerIndex).getPropertyAt(propertyIndex).getRentPerLevel());
		lblRent.setFont(font);
		lblRentPerLevel.setFont(font);

		lblRent.setBounds(0, 92, 330, 64);
		add(lblRent);
		lblRentPerLevel.setBounds(0, 140, 330, 64);
		add(lblRentPerLevel);

		btnDowngrade.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnDowngrade.setBounds(163, 481, 167, 53);
		add(btnDowngrade);

		btnUpgrade.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnUpgrade.setBounds(0, 481, 167, 53);
		add(btnUpgrade);

		btnTrade.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnTrade.setBounds(163, 532, 167, 46);
		add(btnTrade);

		btnSell.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnSell.setBounds(0, 532, 167, 46);
		btnSell.setForeground(Color.red);
		add(btnSell);
		btnSell.setFont(font);

		taLevel.setEditable(false);
		taLevel.setBounds(46, 38, 263, 53);
		taLevel.setOpaque(false);
		taLevel.setFont(fontLevel);
		taLevel.setForeground(Color.white);
		updateLevels();
		add(taLevel);

		lblName.setForeground(Color.white);
		lblName.setOpaque(false);
		lblName.setText(controller.getPlayerList().getPlayerFromIndex(playerIndex).getProperty(propertyIndex).getName());

		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(0, 11, 330, 46);
		add(lblName);
		lblName.setFont(font);
		lblPicture.setForeground(Color.WHITE);

		lblPicture.setBorder(null);
		lblPicture.setBounds(0, 0, 330, 480);
		add(lblPicture);

		lblPicture.setFont(font);
		lblPicture.setOpaque(true);
		btnDowngrade.setFont(font);
		btnUpgrade.setFont(font);
		btnTrade.setFont(font);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(
					controller.getPlayerList().getPlayerFromIndex(playerIndex).getProperty(propertyIndex).getPicture().toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image resizedImg = img.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH);

		lblPicture.setIcon(new ImageIcon(resizedImg));

		btnUpgrade.addActionListener(this);
		btnDowngrade.addActionListener(this);
		btnSell.addActionListener(this);
		btnTrade.addActionListener(this);

	}

	/**
	 * Adds a plus to indicate an upgrade.
	 */
	public void upgradeUpdate() {
		taLevel.append("+");
	}

	public void downgradeUpdate() {
		String tempRes = taLevel.getText();
		tempRes = tempRes.substring(0, tempRes.length() - 1);
		taLevel.setText(tempRes);
	}

	/**
	 * What happens when a button is pressed
	 */
	public void actionPerformed(ActionEvent e) {

		// Sell properties
		if (e.getSource() == btnSell) {
			controller.sellProperty(playerIndex, propertyIndex);
		}
		// upgrade properties
		if (e.getSource() == btnUpgrade) {
			controller.upgradeProperty(playerIndex, propertyIndex);
		}
		// downgrade properties
		if (e.getSource() == btnDowngrade) {
			controller.downgradeProperty(playerIndex, propertyIndex);
		}

		// trade with a certain player
		if (e.getSource() == btnTrade) {
			controller.trade();
		}
	}

	/**
	 *
	 */
	public void updateLevels() {
		int lvl = controller.getPlayerList().getPlayerFromIndex(playerIndex).getPropertyAt(propertyIndex).getLevel();

		for (int i = 0; i < lvl; i++) {

			taLevel.append("+");
		}

	}
}