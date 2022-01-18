package eastSidePanels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import player.PlayerList;

/**
 * this class add tabs that displays informations about the players
 * in tabs
 * @author Abdulkhuder Muhammad, Sebastian Viro.
 *
 */
public class EastSidePanel extends JPanel {

	private static final long serialVersionUID = 3397908521882247649L;
	private PlayerList playerList;
	private JTabbedPane tab;
	private PlayerInfoPanel playerInfoPnl;

	private int currentPlayer = 0;

	/**
	 * @param playerList
	 * this method is also used to update the information displayed
	 */
	public void addPlayerList(PlayerList playerList) {
		this.playerList = playerList;
		addtabs();
	}

	/**
	 * Draws the GUI
	 */
	public EastSidePanel() {

		setPreferredSize(new Dimension(345, 860));
		setOpaque(false);
		setLayout(null);
		UIManager.put("TabbedPane.contentOpaque", false);
		UIManager.put("TabbedPane.selected", Color.cyan);

		tab = new JTabbedPane();

		tab.setBounds(0, 0, 355, 860);
		tab.setBackground(new Color(0, 0, 0));

		add(tab);

	}

	/**
	 * this method adds tabs according to the amount of players
	 */
	public void addtabs() {

		tab.removeAll();

		for (int i = 0; i < playerList.getLength(); i++) {
			new EastSidePanel();
			playerInfoPnl = new PlayerInfoPanel(playerList, i);
			playerInfoPnl.setOpaque(false);
			tab.addTab("Player " + (i + 1), playerInfoPnl);
			tab.setOpaque(false);

		}

		tab.setSelectedIndex(currentPlayer);
		tab.setForeground(Color.white);
		tab.setBackground(new Color(157, 0, 0));
		tab.setBackgroundAt(currentPlayer, new Color(0, 157, 0));

	}

	/**
	 * this method is used to display the correct color
	 * the active players turn should be green and the others should be red.
	 */
	public void setTab() {
		tab.setBackgroundAt(currentPlayer, null);

		currentPlayer++;
		if (currentPlayer > playerList.getLength() - 1) {
			currentPlayer = 0;

			tab.setSelectedIndex(currentPlayer);
			tab.setForeground(Color.white);
			tab.setBackground(new Color(157, 0, 0));
			tab.setBackgroundAt(currentPlayer, new Color(0, 157, 0));

		} else

			tab.setSelectedIndex(currentPlayer);
		tab.setForeground(Color.white);
		tab.setBackground(new Color(157, 0, 0));
		tab.setBackgroundAt(currentPlayer, new Color(0, 157, 0));
	}
	

	public int getTab() {
		return currentPlayer;
	}

}
