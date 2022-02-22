package View.eastSidePanels;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Model.player.PlayerList;

/**
 * @author Muhammad Abdulkhuder, Aevan Dino.
 */
public class PropertyWindow extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private PlayerList playerList;
	private JTabbedPane tab;
	private PlayerProperties playerProperties;

	/**
	 * Reference for updating GUI, only exists because of lackluster architecture overall.
	 * Not used in this class, only passed on to PlayerProperties class.
	 * Added 2022-02-03 by Marcus Juninger.
	 */
	private EastSidePanel eastSidePanel;

	private int playerAt;

	private int[] size;
	
	public PropertyWindow(EastSidePanel eastSidePanel) {

		this.eastSidePanel = eastSidePanel;
		setBorder(new EmptyBorder(0,0,0,0));
		setPreferredSize(new Dimension(345, 600));
		setOpaque(false);
		setLayout(null);
		UIManager.put("TabbedPane.contentOpaque", false);
		UIManager.put("TabbedPane.selected", Color.cyan);
		UIManager.getDefaults().put("TabbedPane.contentBorderInsets", new Insets(0,0,0,0));
		UIManager.getDefaults().put("TabbedPane.tabsOverlapBorder", true);

		tab = new JTabbedPane();
		tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

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

			new PropertyWindow(eastSidePanel);
			playerProperties = new PlayerProperties(playerList, getPlayerAt(), i, eastSidePanel);
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
