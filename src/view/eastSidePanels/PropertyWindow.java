package view.eastSidePanels;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.GameLogic;

/**
 * @author Muhammad Abdulkhuder, Aevan Dino.
 * Updated 2022-02-05 by Mattias Bengtsson: MVC architecture restructuring
 */
public class PropertyWindow extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTabbedPane tab;
	private PlayerPropertyPanel[] playerPropertyPanels;

	public PropertyWindow(GameLogic controller, int playerNbr) {
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

		addPropertyPanels(controller, playerNbr);
	}
	
	private void addPropertyPanels(GameLogic controller, int playerNbr) {

		tab.removeAll();

		tab.setForeground(Color.white);

		int size = controller.getPlayerList().getPlayerFromIndex(playerNbr).getProperties().size();

		playerPropertyPanels = new PlayerPropertyPanel[size];

		for (int i = 0; i < size; i++) {
			//new PropertyWindow(eastSidePanel); // Mattias: this shouldn't be needed, but I'm leaving it here in case it fixes some unknown bug
			playerPropertyPanels[i] = new PlayerPropertyPanel(controller, playerNbr, i);
			tab.addTab("Property" + (i + 1), playerPropertyPanels[i]);
			tab.setBackgroundAt(i, controller.getPlayerList().getPlayerFromIndex(playerNbr).getProperty(i).getColor());

		}

	}

	/**
	 * Sets which property to show.
	 * @param index the index of the property.
	 */
	public void setSelectedTab(int index) {
		if (index < tab.getTabCount()) {
			tab.setSelectedIndex(index);
		}
	}

	/**
	 * Returns the PlayerPropertyPanel at a given index.
	 * @param index the index of the property.
	 * @return the PlayerPropertyPanel at the given index.
	 */
	public PlayerPropertyPanel getPlayerPropertyPanelAt(int index) {
		return playerPropertyPanels[index];
	}

}
