package messageGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import events.ManageEvents;

/**
 * Gui to display messages
 * @author AevanDino, Sebastian Viro, Muhammad Abdulkhuder
 *
 */
public class FortuneTellerGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel centerPanel = new JPanel();
    private JPanel outerPanel = new JPanel();
    private JLabel type = new JLabel();
    private JTextPane dis = new JTextPane();
    private JFrame frame;
    
    private Font fontType = new Font("ALGERIAN", Font.BOLD, 30);
    private Font fontDis = new Font("ALGERIAN", Font.BOLD, 20);
    private Thread thread;
    
    /**
     * Method to draw the GUI.
     */
    public void startGUI() {
    	setLayout(new BorderLayout());
        outerPanel.setLayout(new BorderLayout());
        centerPanel.setLayout(new BorderLayout());

        setPreferredSize(new Dimension(500, 250));
        setBackground(Color.black);
        setForeground(Color.black);

        setBorder(BorderFactory.createMatteBorder(3,3, 3, 3, Color.black));
        outerPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.DARK_GRAY));
        centerPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.gray));

        type.setPreferredSize(new Dimension(200,70));
        type.setFont(fontType);
        type.setForeground(Color.WHITE);
        type.setHorizontalAlignment(SwingConstants.CENTER);
        dis.setFont(fontDis);
        dis.setForeground(Color.WHITE);
        dis.setEditable(false);


        centerPanel.add(type,BorderLayout.NORTH);
        centerPanel.add(dis,BorderLayout.CENTER);

        add(outerPanel, BorderLayout.CENTER);
        outerPanel.add(centerPanel, BorderLayout.CENTER); 
        getFrame();
        
       thread  = new Thread(new Sleeper());
       thread.start();
    }
    
    /**
     * Method checks if the fortune is a blessing or a curse and changes the GUI accordingly before it calls the method startGUI().
     * @param b boolean for the fortune.
     * @param amount how much the player either has to pay or get paid.
     */
    public void newFortune(Boolean b, int amount) {
    	if(b) {
    		type.setText("Blessing");
    		 dis.setText("\n                     Fortune smiles upon you. \n"
    	                + "                         You recived " + amount + " GC");
    		 dis.setBackground(new Color(26, 122, 137));
    		 centerPanel.setBackground(new Color(26, 122, 137));
    	} else {
    		type.setText("Curse");
    		dis.setText("\n                     You have been cursed! \n"
	                + "                         You pay " + amount + " GC");
    		dis.setBackground(new Color(209, 13, 10));
    		centerPanel.setBackground(new Color(209, 13, 10));
    	}
    	startGUI();
    }
    
    /**
     * Creates the frame.
     */
    public void getFrame() {
    	frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
    
    /**
     *Inner class that extends thread in order to automatically close the frame after 3 seconds.
     */
    private class Sleeper extends Thread {
    	
    	public void run() {
    		try { 
    			Thread.sleep(3000);
    		} catch (Exception e) {
    			e.printStackTrace();
    		} finally {
				frame.dispose();
			}
    	}
    }
    
}