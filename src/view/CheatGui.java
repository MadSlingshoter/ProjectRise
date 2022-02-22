package view;

import controller.GameLogic;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Sebastian Viro, Muhammad Abdulkhuder
 * 
 *         This class is used for testing purposes only.
 */
public class CheatGui extends JPanel implements ActionListener {

	private JTextField inputTF = new JTextField("");
	private JButton btnTeleport = new JButton("Teleport");
	private GameLogic controller;
	private int index;

	/**
	 * @param controller
	 * 
	 *                   Calls the method that starts the gui and gets a reference
	 *                   from dice
	 */
	public CheatGui(GameLogic controller) {
		this.controller = controller;
		startGUI();
	}

	/**
	 * The method that draws the gui
	 */
	private void startGUI() {
		setPreferredSize(new Dimension(100, 100));
		setLayout(new BorderLayout());
		btnTeleport.setPreferredSize(new Dimension(300, 50));
		add(inputTF, BorderLayout.CENTER);
		add(btnTeleport, BorderLayout.SOUTH);
		btnTeleport.addActionListener(this);
		setVisible(true);
	}

	/**
	 * This is what happens when a button is pressed
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnTeleport) {
			try {
				setIndex(Integer.parseInt(inputTF.getText()));
				controller.moveWithCheat(getIndex());

			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}

	}

	/**
	 * @return index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index 
	 */
	public void setIndex(int index) {
		this.index = index;

	}

}
