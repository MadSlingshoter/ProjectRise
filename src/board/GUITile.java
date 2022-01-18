package board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import player.Player;

import java.awt.font.*;

/**
 * 
 * Every tile is a guiTile object they are used to display the players. It could
 * also be used to show the level on the properties.
 * 
 * @author sethoberg
 */

public class GUITile extends JLabel {

	private static final long serialVersionUID = 1L;
	private Font labelFont = new Font("Arial", Font.BOLD, 10);
	private JLabel infoLabel = new JLabel("", SwingConstants.CENTER);
	private JLabel labelArray = new JLabel();
	private JLabel[] labels = new JLabel[4];
	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();
	private JLabel label3 = new JLabel();
	private JLabel label4 = new JLabel();
	private int alignment = 1;
	private Border tileBorder = BorderFactory.createLineBorder(Color.decode("#ff7723"));

	/**
	 * Initializes the gui
	 */
	public GUITile() {
		setPreferredSize(new Dimension(200, 300));
		setLayout(new BorderLayout());
		setBorder(tileBorder);

		labelArray.setLayout(new GridLayout(2, 2));
		labelArray.setOpaque(true);
		labelArray.setBackground(Color.decode("#ffe9c6"));

		styleAndAddInfoLabel();
		addLabelsToArray();
		addLabelsToGrid();
	}

	/**
	 * Constructor receiving an int gets the location of the info JLabel object
	 * 
	 * @param SouthWestNorthEast either 1, 2, 3, 4
	 */
	public GUITile(int SouthWestNorthEast) {
		alignment = SouthWestNorthEast;

		setPreferredSize(new Dimension(200, 300));
		setLayout(new BorderLayout());

		labelArray.setLayout(new GridLayout(2, 2));
		labelArray.setOpaque(false);
		labelArray.setBackground(Color.decode("#ffe9c6"));

		styleAndAddInfoLabel();
		addLabelsToArray();
		addLabelsToGrid();
	}

	/**
	 * JLabel object gets each Tile showing which level a property is in
	 */
	public void styleAndAddInfoLabel() {
		infoLabel.setPreferredSize(new Dimension(200, 20));
		infoLabel.setOpaque(false);
		infoLabel.setForeground(Color.white);
		infoLabel.setFont(labelFont);
		infoLabel.setText("");
		infoLabel.setBackground(Color.magenta);

		if (alignment == 1) {
			add(infoLabel, BorderLayout.NORTH);
		} else if (alignment == 2) {
			infoLabel.setPreferredSize(new Dimension(20, 200));
			add(infoLabel, BorderLayout.EAST);
		} else if (alignment == 3) {
			add(infoLabel, BorderLayout.SOUTH);
		} else if (alignment == 4) {
			infoLabel.setPreferredSize(new Dimension(20, 200));
			add(infoLabel, BorderLayout.WEST);
		}

	}

	/**
	 * Varje grid ruta läggs till, 4st
	 */
	public void addLabelsToArray() {
		labels[0] = label1;
		labels[1] = label2;
		labels[2] = label3;
		labels[3] = label4;
	}

	// Adds 4 j label
	public void addLabelsToGrid() {
		for (int i = 0; i < labels.length; i++) {
			labels[i].setPreferredSize(new Dimension(200, 200));
			labelArray.add(labels[i]);
		}
		add(labelArray, BorderLayout.CENTER);
	}

	// update level on property
	public void changeLevel(String level) {
		infoLabel.setText(level);
	}

	/**
	 * Each gui tile has 4 places where a player can be placed
	 * 
	 * @param index
	 */

	public void setPlayer(Player player) {
		labels[player.getPlayerIndex()].setIcon(player.getImage());
		labels[player.getPlayerIndex()].setHorizontalAlignment(CENTER);
	}

	public void removePlayer(Player player) {
		labels[player.getPlayerIndex()].setIcon(null);
		labels[player.getPlayerIndex()].setHorizontalAlignment(CENTER);
	}

}
