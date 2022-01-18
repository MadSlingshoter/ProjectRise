package eastSidePanels;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import player.PlayerList;

/**
 * @author Muhammad Abdulkhuder, Aevan Dino.
 */
public class PropertyWindow extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private PlayerList playerList;
	private JTabbedPane tab;
	private PlayerProperties playerProperties;

	private int playerAt;

	private int[] size;

	/**
	 * @param playerList
	 * 
	 *this method is used to update the panel
	 */
	
	public PropertyWindow() {

		setPreferredSize(new Dimension(330, 600));
		setOpaque(false);
		setLayout(null);
		UIManager.put("TabbedPane.contentOpaque", false);
		UIManager.put("TabbedPane.selected", Color.cyan);

		tab = new JTabbedPane();
		tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tab.setBorder(null);
		tab.setBounds(0, 0, 330, 600);
		add(tab);

	}
	
	public void addPlayerList(PlayerList playerList) {

		this.playerList = playerList;
		addtabs();

	}


	/**
	 * this method loops the amount of players and adds tabs according to the number of 
	 * properties
	 */
	public void addtabs() {

		tab.removeAll();

		tab.setForeground(Color.white);

		size = new int[playerList.getPlayerFromIndex(getPlayerAt()).getProperties().size()];

		for (int i = 0; i < size.length; i++) {

			new PropertyWindow();
			playerProperties = new PlayerProperties(playerList, getPlayerAt(), i);
			tab.addTab("Property" + (i + 1), playerProperties);
			tab.setBackgroundAt(i, playerList.getPlayerFromIndex(getPlayerAt()).getProperty(i).getColor());

		}

	}

	/**
	 * @return playerAT
	 */
	public int getPlayerAt() {
		return playerAt;
	} 

	/**
	 * @param playerAt
	 */
	public void setPlayerAt(int playerAt) {
		this.playerAt = playerAt;
	}

}
