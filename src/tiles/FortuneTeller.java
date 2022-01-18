package tiles;

import java.awt.Color;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * Fortune teller class, either returns a fortune where the player
 * gains money or has to pay.
 * @author SebastianViro, AevanDino, MuhammadAbdulkhuder
 *
 */
public class FortuneTeller implements Tile{
	
	private Color color = Color.WHITE;
	private static final String NAME = "Fortune Teller";
	
	private static final Boolean PURCHASEABLE = false;
	private String fortune = "";
	private Boolean isBlessing = false;

	private String description = "";
	private int amount; 
	
	private ImageIcon img = new ImageIcon("tilePics/fortune.png");
	
	/**
	 * Empty constructor
	 */
	public FortuneTeller() {
		
	}
	
	/**
	 * Constructor to create a fortune.
	 * @param isBlessing, indicates whether or not its a blessing
	 * @param description, string to display on the card
	 * @param amount, amount to pay or be paid.
	 */
	public FortuneTeller(Boolean isBlessing, String description, int amount) {
		
		if(isBlessing) {
			setFortune("BLESSING");
		}else {
			setFortune("CURSE");
		}
		setDescription(description);
		setAmount(amount);
	}

	/**
	 * @return the fortune
	 */
	public String getFortune() {
		return fortune;
	}

	/**
	 * @param fortune the fortune to set
	 */
	public void setFortune(String fortune) {
		this.fortune = fortune;
	}

	/**
	 * @return the isBlessing
	 */
	public Boolean getIsBlessing() {
		return isBlessing;
	}

	/**
	 * @param isBlessing the isBlessing to set
	 */
	public void setIsBlessing(Boolean isBlessing) {
		this.isBlessing = isBlessing;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	 * Returns name
	 */
	public String getName() {
		return this.NAME;
	}
	
	/**
	 * REturns whether or not its purchasable
	 */
	public Boolean getPurchaseable() {
		return PURCHASEABLE;
	}
	
	/**
	 * returns color
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Returns tile info
	 */
	public String getTileInfo() {
		return "There are two types of cards, blessings and curses." + 
				"\nBlessing affect the player in a positive way." + 
				"\nCurses affect the player in a negative way.";
	}
	
	/**
	 * returns title
	 */
	public String getTitle() {
		return null;
	}
	
	/**
	 * returns image icon of tile
	 */
	public ImageIcon getPicture(){
		return img;
	}
}