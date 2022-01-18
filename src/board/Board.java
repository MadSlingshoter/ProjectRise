package board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import player.Player;
import player.PlayerList;
import tiles.Tile;
import tileCollection.TileCollection;
import tiles.TileInfo;
import westSidePanel.WestSidePanel;



/**
 * @author Muhammad Abdulkhuder, Seth Öberg, Rohan Samandari
 *
 */
public class Board extends JPanel {
	
	private WestSidePanel pnlWest;
	private TileInfo info = new TileInfo();
	
	private GUITile[] guiTiles = new GUITile[40]; //Creates empty tile objects with a background.  
	private PlayerList playerList = new PlayerList();
	private Listener listener = new Listener();
	
	private TileCollection tileCollection = new TileCollection();
		
	private static final long serialVersionUID = 1L;
	
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();
	private JPanel p5 = new JPanel();
	private JPanel p6 = new JPanel();
	private JPanel p7 = new JPanel();
	private JPanel p8 = new JPanel();
	private JPanel p9 = new JPanel();
	private JPanel p10 = new JPanel();
	private JPanel p11 = new JPanel();
	private JPanel p12 = new JPanel();
	private JPanel p13 = new JPanel();
	private JPanel p14 = new JPanel();
	private JPanel p15 = new JPanel();
	private JPanel p16 = new JPanel();
	private JPanel p17 = new JPanel();
	private JPanel p18 = new JPanel();
	private JPanel p19 = new JPanel();
	private JPanel p20 = new JPanel();
	private JPanel p21 = new JPanel();
	private JPanel p22 = new JPanel();
	private JPanel p23 = new JPanel();
	private JPanel p24 = new JPanel();
	private JPanel p25 = new JPanel();
	private JPanel p26 = new JPanel();
	private JPanel p27 = new JPanel();
	private JPanel p28 = new JPanel();
	private JPanel p29 = new JPanel();
	private JPanel p30 = new JPanel();
	private JPanel p31 = new JPanel();
	private JPanel p32 = new JPanel();
	private JPanel p33 = new JPanel();
	private JPanel p34 = new JPanel();
	private JPanel p35 = new JPanel();
	private JPanel p36 = new JPanel();
	private JPanel p37 = new JPanel();
	private JPanel p38 = new JPanel();
	private JPanel p39 = new JPanel();
	private JPanel p40 = new JPanel();

	private JPanel[] panelarray = { p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20,
			p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38, p39, p40 };

	JLabel lblNewLabel = new JLabel();

	/**
	 * 
	 * @param wp, WestSidePanel
	 */
	public Board(WestSidePanel wp) {
		this.pnlWest = wp;
		initializeAllPanels();	
		initializeGUI(); 
	}
	
	/**
	 * 
	 * @param playerList, list of players
	 */
	public Board(PlayerList playerList) {
		initializeAllPanels();	
		this.playerList = playerList; 
		
	}

	/**
	 * 
	 * @param playerList, list of players
	 * @param wp, WestSidePanel
	 */
	public Board(PlayerList playerList,WestSidePanel wp) {
		initializeAllPanels();	
		this.playerList = playerList;  
		
	}

	/**
	 * Sets the list of players.
	 * @param playerList
	 */
	public void addPlayers(PlayerList playerList) {
		this.playerList = playerList;
	}
	/**
	 * Sets players
	 */
	public void setPlayers() {
		
		for(int i = 0; i < playerList.getLength(); i++) {
			setPlayer(playerList.getPlayerFromIndex(i));
		}
	}
	
	/**
	 * Initilizes all panels
	 */
	public void initializeAllPanels() {
		setPreferredSize(new Dimension(750, 750));
		setLayout(null);

		p1.setOpaque(false);
		p1.setBounds(649, 650, 101, 100);
		add(p1);

		p2.setOpaque(false);
		p2.setBounds(587, 651, 60, 99);
		add(p2);

		p3.setOpaque(false);
		p3.setBounds(525, 650, 60, 100);
		add(p3);

		p4.setOpaque(false);
		p4.setBounds(467, 650, 60, 100);
		add(p4);

		p5.setOpaque(false);
		p5.setBounds(412, 650, 53, 100);
		add(p5);

		p6.setOpaque(false);
		p6.setBounds(346, 650, 66, 100);
		add(p6);

		p7.setOpaque(false);
		p7.setBounds(283, 650, 66, 100);
		add(p7);

		p8.setOpaque(false);
		p8.setBounds(225, 651, 60, 99);
		add(p8);

		p9.setOpaque(false);
		p9.setBounds(163, 651, 66, 99);
		add(p9);

		p10.setOpaque(false);
		p10.setBounds(103, 650, 60, 100);
		add(p10);

		p11.setOpaque(false);
		p11.setBounds(0, 650, 101, 100);
		add(p11);

		p12.setOpaque(false);
		p12.setBounds(0, 587, 101, 62);
		add(p12);

		p13.setOpaque(false);
		p13.setBounds(0, 527, 101, 62);
		add(p13);

		p14.setOpaque(false);
		p14.setBounds(0, 465, 101, 62);
		add(p14);

		p15.setOpaque(false);
		p15.setBounds(0, 407, 101, 62);
		add(p15);

		p16.setOpaque(false);
		p16.setBounds(0, 345, 101, 62);
		add(p16);

		p17.setOpaque(false);
		p17.setBounds(0, 281, 101, 62);
		add(p17);  

		p18.setOpaque(false);
		p18.setBounds(0, 218, 101, 62);
		add(p18);

		p19.setOpaque(false);
		p19.setBounds(0, 162, 101, 62);
		add(p19);

		p20.setOpaque(false);
		p20.setBounds(0, 103, 101, 62);
		add(p20);

		p21.setOpaque(false);
		p21.setBounds(0, 0, 101, 100);
		add(p21);

		p22.setOpaque(false);
		p22.setBounds(103, 0, 60, 100);
		add(p22);

		p23.setOpaque(false);
		p23.setBounds(163, 0, 60, 100);
		add(p23);

		p24.setOpaque(false);
		p24.setBounds(225, 0, 60, 100);
		add(p24);

		p25.setOpaque(false);
		p25.setBounds(283, 0, 66, 100);
		add(p25);

		p26.setOpaque(false);
		p26.setBounds(346, 0, 60, 100);
		add(p26);

		p27.setOpaque(false);
		p27.setBounds(407, 0, 60, 100);
		add(p27);

		p28.setOpaque(false);
		p28.setBounds(467, 0, 60, 100);
		add(p28);

		p29.setOpaque(false);
		p29.setBounds(525, 0, 60, 100);
		add(p29);

		p30.setOpaque(false);
		p30.setBounds(587, 0, 60, 100);
		add(p30);

		p31.setOpaque(false);
		p31.setBounds(649, 0, 101, 100);
		add(p31);

		p32.setOpaque(false);
		p32.setBounds(649, 103, 101, 62);
		add(p32);

		p33.setOpaque(false);
		p33.setBounds(649, 162, 101, 62);
		add(p33);

		p34.setOpaque(false);
		p34.setBounds(649, 228, 101, 62);
		add(p34);

		p35.setOpaque(false);
		p35.setBounds(649, 281, 101, 62);
		add(p35);

		p36.setOpaque(false);
		p36.setBounds(649, 345, 101, 62);
		add(p36);

		p37.setOpaque(false);
		p37.setBounds(649, 407, 101, 62);
		add(p37);

		p38.setOpaque(false);
		p38.setBounds(649, 465, 101, 62);
		add(p38);

		p39.setOpaque(false); 
		p39.setBounds(649, 527, 101, 62);
		add(p39);

		p40.setOpaque(false);
		p40.setBounds(649, 587, 101, 62);
		add(p40);
		
		/**
		 * Adds mouselistener
		 */
		for (int i=0; i<panelarray.length; i++) {
			panelarray[i].addMouseListener(listener);
		}

		lblNewLabel.setBounds(0, -136, 1050, 1022);
		lblNewLabel.setIcon(new ImageIcon("images/RiseBoard750.png"));
		add(lblNewLabel);
		
		for (int i = 0; i < panelarray.length; i++) {
			panelarray[i].setLayout(new BorderLayout());
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
	 * Used to initilize all the tiles.
	 * @param spaces, receives a array with all 40 tile objects.
	 */
	public void paintNewBoard(GUITile[] spaces) {

		for(int i = 0; i < panelarray.length; i ++) {
			panelarray[i].add(spaces[i]);
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
			for (int i=0; i<panelarray.length; i++) {
				if (e.getSource()==panelarray[i]) {
					if (i == 0 || i == 2 || i == 4 || i == 5 ||i == 7 || 
							i == 10 || i == 15 ||i == 17 || 
							i == 20 ||i == 22 || i == 25 || i == 30 ||
							i == 33 ||i == 35 || i == 36 || i == 38){
							pnlWest.setTitleText(info.getInfo(i), info.getTitle(i), Color.DARK_GRAY, Color.white);
					}else if(i==26 || i==27 || i==29) {
						pnlWest.setTitleText(tileCollection.getTileAtIndex(i).getTileInfo(),
								tileCollection.getTileAtIndex(i).getTitle(), new Color(254,231,11, 255), Color.black);
					}
					else if(i == 12 || i == 28) {
						pnlWest.setTitleText(tileCollection.getTileAtIndex(i).getTileInfo(), 
								tileCollection.getTileAtIndex(i).getName(), Color.DARK_GRAY, Color.white);
					}
					else {						
						pnlWest.setTitleText(tileCollection.getTileAtIndex(i).getTileInfo(),
							tileCollection.getTileAtIndex(i).getTitle(), tileCollection.getTileAtIndex(i).getColor(), Color.white );
					}
				}
			}		
			}
		
			/**
			 * Calls method to set default text when mouse leaves a tile.
			 */
			public void mouseExited(MouseEvent e) {
				pnlWest.setTextDefault();
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
