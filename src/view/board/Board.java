package view.board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

import controller.GameLogic;
import model.player.Player;
import model.player.PlayerList;
import model.tiles.Tile;
import model.tiles.TileCollection;
import model.tiles.TileInfo;
import view.WestSidePanel;



/**
 * @author Muhammad Abdulkhuder, Seth Oberg, Rohan Samandari
 *
 */
public class Board extends JLayeredPane {
	GameLogic controller;

	private TileInfo info = new TileInfo();
	
	private GUITile[] guiTiles = new GUITile[40]; //Creates empty tile objects with a background.
	private Listener listener = new Listener();
	
	private TileCollection tileCollection = new TileCollection();
		
	private static final long serialVersionUID = 1L;

	private JPanel[] panels;

	JLabel lblNewLabel = new JLabel();

	/**
	 * 
	 * @param controller the controller class
	 */
	public Board(GameLogic controller) {
		this.controller = controller;

		initializeAllPanels();	
		initializeGUI();

	}

	/**
	 * Sets players
	 */
	public void setPlayers() {
		for(int i = 0; i < controller.getPlayerList().getLength(); i++) {
			setPlayer(controller.getPlayerList().getPlayerFromIndex(i));
		}
	}
	
	/**
	 * Initilizes all panels
	 */
	public void initializeAllPanels() {
		panels = new JPanel[40];
		for (int i = 0; i < 40; i++) {
			panels[i] = new JPanel();
		}

		setPreferredSize(new Dimension(750, 750));
		setLayout(null);

		panels[0].setOpaque(false);
		panels[0].setBounds(649, 650, 101, 100);
		add(panels[0]);

		panels[1].setOpaque(false);
		panels[1].setBounds(587, 651, 60, 99);
		add(panels[1]);

		panels[2].setOpaque(false);
		panels[2].setBounds(525, 650, 60, 100);
		add(panels[2]);

		panels[3].setOpaque(false);
		panels[3].setBounds(467, 650, 60, 100);
		add(panels[3]);

		panels[4].setOpaque(false);
		panels[4].setBounds(412, 650, 53, 100);
		add(panels[4]);

		panels[5].setOpaque(false);
		panels[5].setBounds(346, 650, 66, 100);
		add(panels[5]);

		panels[6].setOpaque(false);
		panels[6].setBounds(283, 650, 66, 100);
		add(panels[6]);

		panels[7].setOpaque(false);
		panels[7].setBounds(225, 651, 60, 99);
		add(panels[7]);

		panels[8].setOpaque(false);
		panels[8].setBounds(163, 651, 66, 99);
		add(panels[8]);

		panels[9].setOpaque(false);
		panels[9].setBounds(103, 650, 60, 100);
		add(panels[9]);

		panels[10].setOpaque(false);
		panels[10].setBounds(0, 650, 101, 100);
		add(panels[10]);

		panels[11].setOpaque(false);
		panels[11].setBounds(0, 587, 101, 62);
		add(panels[11]);

		panels[12].setOpaque(false);
		panels[12].setBounds(0, 527, 101, 62);
		add(panels[12]);

		panels[13].setOpaque(false);
		panels[13].setBounds(0, 465, 101, 62);
		add(panels[13]);

		panels[14].setOpaque(false);
		panels[14].setBounds(0, 407, 101, 62);
		add(panels[14]);

		panels[15].setOpaque(false);
		panels[15].setBounds(0, 345, 101, 62);
		add(panels[15]);

		panels[16].setOpaque(false);
		panels[16].setBounds(0, 281, 101, 62);
		add(panels[16]);

		panels[17].setOpaque(false);
		panels[17].setBounds(0, 218, 101, 62);
		add(panels[17]);

		panels[18].setOpaque(false);
		panels[18].setBounds(0, 162, 101, 62);
		add(panels[18]);

		panels[19].setOpaque(false);
		panels[19].setBounds(0, 103, 101, 62);
		add(panels[19]);

		panels[20].setOpaque(false);
		panels[20].setBounds(0, 0, 101, 100);
		add(panels[20]);

		panels[21].setOpaque(false);
		panels[21].setBounds(103, 0, 60, 100);
		add(panels[21]);

		panels[22].setOpaque(false);
		panels[22].setBounds(163, 0, 60, 100);
		add(panels[22]);

		panels[23].setOpaque(false);
		panels[23].setBounds(225, 0, 60, 100);
		add(panels[23]);

		panels[24].setOpaque(false);
		panels[24].setBounds(283, 0, 66, 100);
		add(panels[24]);

		panels[25].setOpaque(false);
		panels[25].setBounds(346, 0, 60, 100);
		add(panels[25]);

		panels[26].setOpaque(false);
		panels[26].setBounds(407, 0, 60, 100);
		add(panels[26]);

		panels[27].setOpaque(false);
		panels[27].setBounds(467, 0, 60, 100);
		add(panels[27]);

		panels[28].setOpaque(false);
		panels[28].setBounds(525, 0, 60, 100);
		add(panels[28]);

		panels[29].setOpaque(false);
		panels[29].setBounds(587, 0, 60, 100);
		add(panels[29]);

		panels[30].setOpaque(false);
		panels[30].setBounds(649, 0, 101, 100);
		add(panels[30]);

		panels[31].setOpaque(false);
		panels[31].setBounds(649, 103, 101, 62);
		add(panels[31]);

		panels[32].setOpaque(false);
		panels[32].setBounds(649, 162, 101, 62);
		add(panels[32]);

		panels[33].setOpaque(false);
		panels[33].setBounds(649, 228, 101, 62);
		add(panels[33]);

		panels[34].setOpaque(false);
		panels[34].setBounds(649, 281, 101, 62);
		add(panels[34]);

		panels[35].setOpaque(false);
		panels[35].setBounds(649, 345, 101, 62);
		add(panels[35]);

		panels[36].setOpaque(false);
		panels[36].setBounds(649, 407, 101, 62);
		add(panels[36]);

		panels[37].setOpaque(false);
		panels[37].setBounds(649, 465, 101, 62);
		add(panels[37]);

		panels[38].setOpaque(false);
		panels[38].setBounds(649, 527, 101, 62);
		add(panels[38]);

		panels[39].setOpaque(false);
		panels[39].setBounds(649, 587, 101, 62);
		add(panels[39]);

		Border border = BorderFactory.createLineBorder(Color.black);
		
		/**
		 * Adds mouselistener
		 */
		for (int i = 0; i< panels.length; i++) {
			panels[i].addMouseListener(listener);

		}

		lblNewLabel.setBounds(0, -136, 1050, 1022);
		lblNewLabel.setIcon(new ImageIcon("images/RiseBoard750.png"));
		add(lblNewLabel);
		
		for (int i = 0; i < panels.length; i++) {
			panels[i].setLayout(new BorderLayout());
		}
	}
	
	/**
	 * Initilizes gui
	 */
	public void initializeGUI() {
		addEmptyGridPanels();
		paintNewBoard(guiTiles); //Requires a array with all 40 tiles to be sent to paintNewBoard.
		
	}
	
	/**
	 * @param index index for a tile.
	 * @return GUITile at given index.
	 */
	public GUITile getTileAtIndex(int index) {
		return guiTiles[index];
	}
	
	
	/**
	 * Tile objects are created with an int depending on their position on the board.
	 */
	public void addEmptyGridPanels() {
		for (int i = 0; i < guiTiles.length; i++) {
			
			/**
			 * If index is between 0-10 then labels are placed in north.
			 */
			if(i < 11) {
				guiTiles[i] = new GUITile(1); 
			}
			
			/**
			 * If index is between 11-20 then labels are placed in east.
			 */
			else if(i < 20) {
				guiTiles[i] = new GUITile(2); 
			}

			/**
			 * If index is between 20 and 30 then labels are placed in south.
			 */
			else if(i < 31) {
				guiTiles[i] = new GUITile(3); 
			}
			
			/**
			 * If index is between 31-39 then labels are placed in west.
			 */
			else if(i < 40) {
				guiTiles[i] = new GUITile(4); 
			}	
		}
	}
		
	/**
	 * Sets a player on a certain position.
	 * @param player
	 */
	public void setPlayer(Player player) {
		guiTiles[player.getPosition()].setPlayer(player); 
	}
	
	/**
	 * Removes a player from a certain position.
	 * @param player
	 */
	public void removePlayer(Player player) {
		guiTiles[player.getPosition()].removePlayer(player);
	}
	
	
	/**
	 * Method is called when the user arrives at the destination tile
	 * @param index of tile.
	 * @return tile at given index.
	 */
	public Tile getDestinationTile(int index) {
		return tileCollection.getTileAtIndex(index);
	}
	 
	/**
	 * Used to initialize all the tiles.
	 * @param spaces, receives a array with all 40 tile objects.
	 */
	public void paintNewBoard(GUITile[] spaces) {

		for(int i = 0; i < panels.length; i ++) {
			panels[i].add(spaces[i]);
		}	
	}
	
	/**
	 * Listener class for interactive tiles
	 */
	public class Listener implements MouseListener {

		/**
		 * Nothing happens when clicking
		 */
		public void mouseClicked(MouseEvent e) {

		}
		/**
		 * Method for when hovering over tiles.
		 */
		public void mouseEntered(MouseEvent e) {
			for (int i = 0; i< panels.length; i++) {
				if (e.getSource()== panels[i]) {
					if (i == 0 || i == 2 || i == 4 || i == 5 ||i == 7 || 
							i == 10 || i == 15 ||i == 17 || 
							i == 20 ||i == 22 || i == 25 || i == 30 ||
							i == 33 ||i == 35 || i == 36 || i == 38){
							controller.getMainWindow().getWestPanel().setTitleText(info.getInfo(i), info.getTitle(i), Color.DARK_GRAY, Color.white);
					}else if(i==26 || i==27 || i==29) {
						controller.getMainWindow().getWestPanel().setTitleText(tileCollection.getTileAtIndex(i).getTileInfo(),
								tileCollection.getTileAtIndex(i).getTitle(), new Color(254,231,11, 255), Color.black);
					}
					else if(i == 12 || i == 28) {
						controller.getMainWindow().getWestPanel().setTitleText(tileCollection.getTileAtIndex(i).getTileInfo(),
								tileCollection.getTileAtIndex(i).getName(), Color.DARK_GRAY, Color.white);
					}
					else {
						controller.getMainWindow().getWestPanel().setTitleText(tileCollection.getTileAtIndex(i).getTileInfo(),
							tileCollection.getTileAtIndex(i).getTitle(), tileCollection.getTileAtIndex(i).getColor(), Color.white );
					}
				}
			}		
			}
		
			/**
			 * Calls method to set default text when mouse leaves a tile.
			 */
			public void mouseExited(MouseEvent e) {
				controller.getMainWindow().getWestPanel().setTextDefault();
			}

			/**
			 * Nothing happens when mouse is pressed.
			 */
			public void mousePressed(MouseEvent e) {

			}
			
			/**
			 * Nothing happens by releasing mouse.
			 */
			public void mouseReleased(MouseEvent e) {

			}
	}
}
