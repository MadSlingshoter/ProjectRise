package westSidePanel;

import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.DefaultCaret;

/**
 * @author RohanSamandari, AevanDino
 *
 */
public class WestSidePanel extends JPanel {

	/**
	 * WestPanel which shows Info about each Boxes.
	 * 
	 * @author RohanSamandari
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblInfoTitle, lblHistoryTitle;
	private JPanel pnlSpace, pnlHeading, pnlInfo, pnlHistory;
	private Font font = new Font("ALGERIAN", Font.BOLD, 19);
	private JTextArea txtTileInfo = new JTextArea();
	private JTextArea txtMessage = new JTextArea();
	private JScrollPane scroller = new JScrollPane(txtMessage);
	
	private DefaultCaret caret = (DefaultCaret)txtMessage.getCaret();
	
	private Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
	private String def = "\n\nMove your mouse on a tile \n   which you want to see \n"
			+ "      information about!";
	private String title = "Information";
	private Color titleColor = Color.DARK_GRAY;

	public WestSidePanel() {
		  
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE); 

		/**
		 * HeadPanel with Information Label
		 */
		pnlSpace = new JPanel();

		pnlSpace.setPreferredSize(new Dimension(10, 15));
		pnlSpace.setOpaque(false);
		pnlHeading = new JPanel();
		pnlHeading.setBorder(border);
		pnlHeading.setPreferredSize(new Dimension(340, 80));
		lblInfoTitle = new JLabel(title);

		lblInfoTitle.setFont(new Font("ALGERIAN", Font.BOLD, 26));
		lblInfoTitle.setPreferredSize(new Dimension(320, 70));
		lblInfoTitle.setBorder(BorderFactory.createLineBorder(Color.black));
		lblInfoTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoTitle.setBackground(titleColor);
		lblInfoTitle.setOpaque(true);
		lblInfoTitle.setForeground(Color.white);

		pnlHeading.setBackground(new Color(0, 0, 0, 20));
		pnlHeading.add(lblInfoTitle, BorderLayout.SOUTH);

		/**
		 * TileInformation Panel
		 */
		pnlInfo = new JPanel();
		pnlInfo.setPreferredSize(new Dimension(340, 255));
		pnlInfo.setBorder(border);
		pnlInfo.setBackground(new Color(0, 0, 0, 20));
		txtTileInfo.setForeground(new Color(71, 60, 50, 225));
		txtTileInfo.setPreferredSize(new Dimension(320, 300));
		txtTileInfo.setFont(font);
		txtTileInfo.setEditable(false);
		txtTileInfo.setMargin(new Insets(10, 10, 10, 10));
		txtTileInfo.setText(def);

		pnlInfo.add(txtTileInfo);

		/**
		 * HistoryPanel
		 */
		pnlHistory = new JPanel();
		txtMessage.setFont(new Font("Gabriola", Font.BOLD, 18));
		txtMessage.setMargin(new Insets(10, 10, 10, 10));
		txtMessage.setEditable(false);
		txtMessage.setForeground(new Color(71, 60, 50, 225));

		scroller.setBackground(Color.white);
		scroller.setForeground(Color.black);
		scroller.setForeground(new Color(71, 60, 50, 225));
		scroller.setPreferredSize(new Dimension(320, 405));
		scroller.setAutoscrolls(true);
		
		lblHistoryTitle = new JLabel("Game history");
		lblHistoryTitle.setPreferredSize(new Dimension(320, 50));
		lblHistoryTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistoryTitle.setBorder(BorderFactory.createLineBorder(Color.black));
		lblHistoryTitle.setForeground(Color.white);
		lblHistoryTitle.setFont(font);

		pnlHistory.setPreferredSize(new Dimension(340, 475));
		pnlHistory.setBackground(new Color(0, 0, 0, 20));
		pnlHistory.setBorder(border);
		pnlHistory.add(lblHistoryTitle);
		pnlHistory.add(scroller);

		/**
		 * The main Panel
		 */
		setOpaque(false);
		setPreferredSize(new Dimension(345, 860));
		setBackground(Color.yellow);
		setBorder(border);
		add(pnlSpace);
		add(pnlHeading);
		add(pnlInfo);
		add(pnlHistory);
	}

	/**
	 * This method is like the above method but only for those boxes which has
	 * default color.
	 * 
	 * @param info
	 * @param lblTitle
	 * @param titleColor
	 * @param titleTxtColor
	 */
	public void setTitleText(String info, String lblTitle, Color titleColor, Color titleTxtColor) {
		txtTileInfo.setText(info);
		lblInfoTitle.setText(lblTitle);
		lblInfoTitle.setBackground(titleColor);
		lblInfoTitle.setForeground(titleTxtColor);
	}

	/**
	 * sets the info text to default when mouse does not pointing on any box.
	 */
	public void setTextDefault() {
		txtTileInfo.setText(def);
		lblInfoTitle.setText(title);
		lblInfoTitle.setBackground(titleColor);
		lblInfoTitle.setForeground(Color.white);
	}

	/**
	 * Adds the history of the game and updates it.
	 * 
	 * @param res
	 */
	public void append(String res) {
		txtMessage.append(res);
	}
}
