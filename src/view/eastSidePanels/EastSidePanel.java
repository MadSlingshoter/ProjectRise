package view.eastSidePanels;


import java.awt.*;


import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import javax.swing.border.EmptyBorder;


import controller.GameLogic;

/**
 * this class add tabs that displays informations about the players
 * in tabs
 * @author Abdulkhuder Muhammad, Sebastian Viro.
 * Updated 2022-02-23 by Mattias Bengtsson: Moved controller methods to GameLogic
 */
public class EastSidePanel extends JPanel {
	private GameLogic controller;
	PlayerInfoPanel[] playerInfoPnls;
	PropertyWindow[] propertyWindows;

	private static final long serialVersionUID = 3397908521882247649L;
	private JTabbedPane tab;

	/**
	 * Draws the GUI
	 */
	public EastSidePanel(GameLogic controller) {
		this.controller = controller;

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
	 *
	 * this method is also used to update the information displayed
	 */
	public void updatePlayerList() {
		tab.removeAll();

		int length = controller.getPlayerList().getLength();

		playerInfoPnls = new PlayerInfoPanel[length];
		propertyWindows = new PropertyWindow[length];

		for (int i = 0; i < length; i++) {
//			new EastSidePanel(); // Mattias: this shouldn't be needed, but I'm leaving it here in case it fixes some unknown bug
			playerInfoPnls[i] = new PlayerInfoPanel(controller, i);
			playerInfoPnls[i].setOpaque(false);
			tab.addTab("Player " + (i + 1), playerInfoPnls[i]);
			tab.setOpaque(false);
			tab.setForeground(Color.white);
			tab.setBackgroundAt(i,controller.getPlayerList().getPlayerFromIndex(i).getPlayerColor());

			propertyWindows[i] = new PropertyWindow(controller, i);
			propertyWindows[i].setBounds(10, 210, 335, 626);

			playerInfoPnls[i].add(propertyWindows[i]);
		}
		tab.setSelectedIndex(controller.getPlayerList().getActivePlayer().getPlayerIndex());
	}

	/**
	 * Returns the PlayerInfoPanel at a given index.
	 * @param index the index of the property.
	 * @return the PlayerInfoPanel at the given index.
	 */
	public PlayerInfoPanel getPlayerInfoPanelAt(int index) {
		return playerInfoPnls[index];
	}

	/**
	 * Returns the PropertyWindow at a given index.
	 * @param index the index of the property.
	 * @return the PropertyWindow at the given index.
	 */
	public PropertyWindow getPropertyWindowAt(int index) {
		return propertyWindows[index];
	}

}
