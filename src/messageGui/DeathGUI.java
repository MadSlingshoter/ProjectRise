package messageGui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class to draw a GUI when players are eliminated
 * @author Sebastian Viro, Muhammad Abdulkhuder
 */
public class DeathGUI extends JPanel implements ActionListener{


	private JLabel lblPic = new JLabel("");
	private JButton btnExit = new JButton("The plague has taken you, you lost");
	private Font font = new Font("Gabriola", Font.BOLD, 32);
	private JFrame frame;
	
	/**
	 * Draws the gui
	 */
	public void addGui() {
		setPreferredSize(new Dimension(1200, 675));
		setLayout(null);

		lblPic.setBounds(0, 0, 1200, 675);
		lblPic.setIcon(new ImageIcon("images/plague_doctors_1200.jpg"));
		btnExit.setBounds(300, 575, 600, 100);
		add(lblPic);
		btnExit.setFont(font);
		btnExit.addActionListener(this);
		add(btnExit);
		getFrame();
	}

	/**
	 * Creates the frame
	 */
	public void getFrame() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	/**
	 * Adds action the the btnExit, disposes the frame. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnExit) {
			frame.dispose();
		}
	}
}
