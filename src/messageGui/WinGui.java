package messageGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import events.ManageEvents;

/**
 * Class to display a gui for the winner.
 * @author Mohammad Abdulkhuder.
 */
public class WinGui extends JPanel {

	private JLabel lblLblpic = new JLabel("lblPic");

	/**
	 * Constructor calls the method to draw the gui.
	 */
	public WinGui() {
		addgui();
	}
	
	/**
	 * Draws the GUI.
	 */
	public void addgui() {
		setPreferredSize(new Dimension(1000, 500));
		setLayout(null);

		lblLblpic.setBounds(0, 0, 1027, 500);
		lblLblpic.setIcon(new ImageIcon("images/Rise Winner.png"));
		add(lblLblpic);
		getFrame();
	}

	/**
	 * Creates the frame.
	 */
	public void getFrame() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
