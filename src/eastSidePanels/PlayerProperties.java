package eastSidePanels;

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
import javax.swing.border.MatteBorder;

import player.Player;
import player.PlayerList;
import tiles.Property;

/**
 * @author Muhammad Abdulkhuder Aevan Dino sebastian Viro.
 *
 */
public class PlayerProperties extends JPanel implements ActionListener {

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
	private String plus = "+";
	private PlayerList playerList;
	private int playerAtI, propertyAtI;

	/**
	 * @param playerList
	 * @param playerAtI
	 * @param propertyAtI 
	 */
	public PlayerProperties(PlayerList playerList, int playerAtI, int propertyAtI) {

		this.playerList = playerList;
		this.playerAtI = playerAtI;
		this.propertyAtI = propertyAtI;

		setBorder(null);

		setOpaque(false);
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(330, 607));
		setLayout(null);

		lblRent.setForeground(Color.white);
		lblRentPerLevel.setForeground(Color.white);
		lblRent.setText(
				"The Rent is: " + playerList.getPlayerFromIndex(playerAtI).getPropertyAt(propertyAtI).getTotalRent());
		lblRentPerLevel.setText("The rent per level : "
				+ playerList.getPlayerFromIndex(playerAtI).getPropertyAt(propertyAtI).getRentPerLevel());
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
		updateLevels(playerList, playerAtI, propertyAtI);
		add(taLevel);

		lblName.setForeground(Color.white);
		lblName.setOpaque(false);
		lblName.setText(playerList.getPlayerFromIndex(playerAtI).getProperty(propertyAtI).getName());

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
					playerList.getPlayerFromIndex(playerAtI).getProperty(propertyAtI).getPicture().toString()));
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
	 * What happens when a button is pressed
	 */
	public void actionPerformed(ActionEvent e) {

		// Sell properties
		if (e.getSource() == btnSell) {

			Property tempProperty = playerList.getPlayerFromIndex(playerAtI).getPropertyAt(propertyAtI);

			playerList.getPlayerFromIndex(playerAtI).sellProperty(tempProperty);

		}
		// upgrade properties
		if (e.getSource() == btnUpgrade) {
			Property tempProperty = playerList.getPlayerFromIndex(playerAtI).getPropertyAt(propertyAtI);

			tempProperty.increaseLevel();
			String tempRes = taLevel.getText();

			if (tempRes.length() < tempProperty.getLevel()) {
				taLevel.append(plus);

			}

		}
		// downgrade properties
		if (e.getSource() == btnDowngrade) {
			Property tempProperty = playerList.getPlayerFromIndex(playerAtI).getPropertyAt(propertyAtI);

			tempProperty.decreaseLevel();

			String tempRes = taLevel.getText();

			if (tempRes.length() > tempProperty.getLevel()) {

				tempRes = tempRes.substring(0, tempRes.length() - 1);
				taLevel.setText(tempRes);
			}

		}

		// trade with a certain player
		if (e.getSource() == btnTrade) {
			int otherPlayerInt = 0;
			int whichPropertyToGive = 0;
			int whichPropertyYouWant = 0;
			int offer = 0;
			int type = 0;
			int confirm;

			do {
			otherPlayerInt = (Integer
					.parseInt(JOptionPane.showInputDialog(null,
							"Which player do you want to trade with?\n 1 for player 1 \n 2 for player 2 and so on..."))
					- 1);
			  
	
			

			} while(otherPlayerInt == playerList.getActivePlayer().getPlayerIndex() || otherPlayerInt > playerList.getLength()-1);
			
			Player activePlayer = playerList.getActivePlayer();
			Player otherPlayer = playerList.getPlayerFromIndex(otherPlayerInt);
			
			if ( otherPlayer.getProperties().size() > 0) {
				
			
			do {			
				type = (Integer.parseInt(JOptionPane.showInputDialog(null,
						"Pick a trade type\n 1 = Property for property \n 2 = Money for property\n 3 = Both")));	
			} while (type<0 ||type >3);
			

			if (type == 1 || type == 3) {
				
				do {
					whichPropertyToGive = (Integer.parseInt(JOptionPane.showInputDialog(null,
							"Which property do you want to give away \n 1 for property 1 \n 2 for property 2 and so on..."))
							- 1);
				} while (whichPropertyToGive > activePlayer.getProperties().size());
				
			}

			if (type == 2 || type == 3) {
				do {
					offer = (Integer.parseInt(JOptionPane.showInputDialog(null,
							"How much do you offer " + otherPlayer.getName() + "?")));
				} while (offer > activePlayer.getBalance());
			
			}

			do {
				whichPropertyYouWant = (Integer.parseInt(JOptionPane.showInputDialog(null,
						"Which property do you want \n 1 for property 1 \n 2 for property 2 and so on...")) - 1);
			} while (whichPropertyYouWant > otherPlayer.getProperties().size());
			

			Property activePlayerProperty = playerList.getActivePlayer().getPropertyAt(whichPropertyToGive);

			Property otherPlayersProperty = playerList.getPlayerFromIndex(otherPlayerInt)
					.getPropertyAt(whichPropertyYouWant);

			

			if (type == 1 || type == 3) {
				confirm = JOptionPane.showConfirmDialog(null,
						otherPlayer.getName() + " Are you okay with this trade?" + "\n You are getting " + offer
								+ "Gold coins" + "\n and are trading away " + otherPlayersProperty.getName() + "\n for "
								+ activePlayerProperty.getName());

				if (confirm == 0) {

					activePlayer.removeProperty(activePlayerProperty);
					otherPlayer.removeProperty(otherPlayersProperty);

					activePlayer.decreaseBalace(offer);
					activePlayer.decreaseNetWorth(offer);

					otherPlayer.increaseBalance(offer);
					otherPlayer.increaseNetWorth(offer);

					activePlayerProperty.setOwner(otherPlayer);
					activePlayer.addNewProperty(otherPlayersProperty);

					otherPlayersProperty.setOwner(activePlayer);
					otherPlayer.addNewProperty(activePlayerProperty);

					JOptionPane.showMessageDialog(null, "Trade Complete! Omedato gosaimasu!!!");

				}

			}

			if (type == 2) {
				confirm = JOptionPane.showConfirmDialog(null, otherPlayer.getName() + " Are you okay with this trade?"
						+ "\n You are getting " + offer + "Gold coins for " + otherPlayersProperty.getName());

				if (confirm == 0) {

					otherPlayer.removeProperty(otherPlayersProperty);
					activePlayerProperty.setOwner(otherPlayer);
					activePlayer.addNewProperty(otherPlayersProperty);

					activePlayer.decreaseBalace(offer);
					activePlayer.decreaseNetWorth(offer);

					otherPlayer.increaseBalance(offer);
					otherPlayer.increaseNetWorth(offer);
					JOptionPane.showMessageDialog(null, "Trade Complete! Omedato gosaimasu!!!");

				}
			}
		}
			else {
				JOptionPane.showMessageDialog(null, "Trade can not be done! The player you picked does not own any properties!");
			}
		}
	}

	/**
	 * @param playerList
	 * @param playerIndex
	 * @param propertyIndex updates levels shown adds a plus to the picture
	 */
	public void updateLevels(PlayerList playerList, int playerIndex, int propertyIndex) {
		int lvl = playerList.getPlayerFromIndex(playerIndex).getPropertyAt(propertyIndex).getLevel();

		for (int i = 0; i < lvl; i++) {

			taLevel.append(plus);
		}

	}

	/**
	 * @param property updates levels shown adds a plus to the picture
	 */
	public void updateLevels(Property property) {
		int lvl = property.getLevel();

		for (int i = 0; i < lvl; i++) {

			taLevel.append(plus);

		}

	}

}