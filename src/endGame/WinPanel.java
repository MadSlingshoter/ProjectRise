package endGame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The gui that
 * 
 * @author Muhammad Abdulkhuder
 */
public class WinPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private ImageIcon imgBackground = new ImageIcon("images/win.png");
	private JLabel lblBackground = new JLabel("", imgBackground, JLabel.CENTER);

	/**
	 * Draws the GUI
	 */
	public WinPanel() {
		createFrame();
		lblBackground.setBounds(0, 0, imgBackground.getIconWidth(), imgBackground.getIconHeight());
		add(lblBackground);
		setVisible(true);
	}

	/**
	 * Creates the frame
	 */
	public void createFrame() {
		setSize(imgBackground.getIconWidth(), imgBackground.getIconHeight());
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

}
