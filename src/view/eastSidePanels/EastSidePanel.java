package view.eastSidePanels;


import java.awt.*;


import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import javax.swing.border.EmptyBorder;


import model.player.PlayerList;

/**
 * this class add tabs that displays informations about the players
 * in tabs
 * @author Abdulkhuder Muhammad, Sebastian Viro.
 * Updated 2022-02-23 by Mattias Bengtsson: Moved controller methods to GameLogic
 */
public class EastSidePanel extends JPanel {

	private static final long serialVersionUID = 3397908521882247649L;
	private JTabbedPane tab;
	private PlayerInfoPanel playerInfoPnl;

	/**
	 * Draws the GUI
	 */
	public EastSidePanel() {

		setPreferredSize(new Dimension(345, 860));
		setOpaque(false);
		setLayout(null);

		UIManager.put("TabbedPane.contentOpaque", false);
		UIManager.put("TabbedPane.selected", Color.black);
		UIManager.put("TabbedPane.borderHightlightColor", Color.DARK_GRAY);
		UIManager.put("TabbedPane.darkShadow", Color.DARK_GRAY);
		UIManager.put("TabbedPane.light", Color.DARK_GRAY);
		UIManager.put("TabbedPane.selectHighlight", Color.DARK_GRAY);
		UIManager.put("TabbedPane.darkShadow", Color.DARK_GRAY);
		UIManager.put("TabbedPane.focus", Color.DARK_GRAY);
		UIManager.put("TabbedPane.contentBorderInsets", new Insets(0,0,0,0));
		UIManager.put("TabbedPane.tabAreaInsets", new Insets(0,0,0,0));
		UIManager.put("TabbedPane.tabInsets", new Insets(0,0,0,0));
		UIManager.put("TabbedPane.tabsOverlapBorder", true);
		UIManager.put("TabbedPane.selected",Color.BLACK);

		tab = new JTabbedPane();

		tab.setBounds(0, 0, 355, 860);
		tab.setBackground(new Color(0, 0, 0));
		setBorder(new EmptyBorder(0,0,0,0));

		add(tab);
	}

	/**
	 * @param playerList
	 * this method is also used to update the information displayed
	 */
	public void updatePlayerList(PlayerList playerList) {
		tab.removeAll();

		for (int i = 0; i < playerList.getLength(); i++) {
//			new EastSidePanel(); // Mattias: this shouldn't be needed, but I'm leaving it here in case it fixes some unknown bug
			playerInfoPnl = new PlayerInfoPanel(playerList, i, this);
			playerInfoPnl.setOpaque(false);
			tab.addTab("Player " + (i + 1), playerInfoPnl);
			tab.setOpaque(false);
			tab.setForeground(Color.white);
			tab.setBackgroundAt(i,playerList.getPlayerFromIndex(i).getPlayerColor());
		}
		tab.setSelectedIndex(playerList.getActivePlayer().getPlayerIndex());
	}

	private void addInfoPanel(PlayerList playerList) {

	}

}
