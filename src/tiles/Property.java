package tiles;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import player.Player;

/**
 * Class for property.
 * @author Sebastian Viro, Aevan Dino, Muhammad Abdulkhuder
 */
public class Property implements Tile {

	private String name, info;
	private int price, rentPerLevel, defaultRent, levels;
	private Boolean purchaseable;
	private Color color;
	private Player player ;
	private ImageIcon img;
	private int levelPrice;

	/**
	 * Construtor which sets values of property
	 * @param name, of property
	 * @param price, of property
	 * @param defaultRent, rent for level 0
	 * @param rentPerLevel, amount to be increased by per level
	 * @param color, color of property
	 * @param levelPrice, cost of upgrade 
	 * @param img, image of tile
	 */
	public Property(String name, int price, int defaultRent, int rentPerLevel, Color color,int levelPrice , ImageIcon img) {
		setName(name);
		setPrice(price);
		setDefaultRent(defaultRent);
		setRentPerLevel(rentPerLevel);
		setColor(color);
		purchaseable=true;
		player = null;
		this.img=img;
		this.levelPrice= levelPrice;
	}
	
	/**
	 * Returns information about tile
	 */
	public String getTileInfo() {
		String ownerName = "";
		if(player == null) {
			ownerName = "No Owner";
		} else {
			ownerName = player.getName();
		}
		info =    "\nOwner: \t         " + ownerName + "\n"
				+ "Price:\t\t" + price + "\n"
				+ "Default rent:\t" + defaultRent + "\n"
				+ "Rent per level:\t" 	+ rentPerLevel + "\n"
				+ "Total rent:\t" 		+ getTotalRent();
		return info;
	}
	
	
	public String getTitle() {
		return name;
	}
	public Color getTitleColor() {
		return color;
	}

	public void setName(String tileName) {
		this.name = tileName;
	}

	public String getName() {
		return this.name;
	}

	public void setPurchaseable(Boolean canBeBought) {
		this.purchaseable=canBeBought;
	}

	public Boolean getPurchaseable() {
		return this.purchaseable;
	}

	public void setColor(Color colorOfTile) {
		this.color=colorOfTile;
	}

	public Color getColor() {
		return this.color;
	} 

	public void setPrice(int price) {
		this.price=price;
	}

	public int getPrice() {
		return this.price;
	}

	
	public void setOwner(Player newOwner) {
		this.player = newOwner;
	}
	
	public Player getOwner() {
		return player;
	}
	
	
	public void setDefaultRent(int defRent) {
		this.defaultRent = defRent;
	}

	public int getDefaultRent() {
		return this.defaultRent;
	}

	public void setRentPerLevel(int rentPerLevel) {
		this.rentPerLevel = rentPerLevel;
	}

	public int getRentPerLevel() {
		return this.rentPerLevel;
	}
	
	public int getTotalRent() {
		return this.defaultRent + (this.rentPerLevel * this.levels);
	}
	
	public void setLevel(int num) {
		this.levels=num;
	}
	
	public int getLevelPrice() {
		return levelPrice;
	}
 
	public void setLevelPrice(int levelPrice) {
		this.levelPrice = levelPrice;
	}
	
	public void increaseLevel() {
		
		int res = JOptionPane.showConfirmDialog(null, "Do you want to upgrade " + getName() + " for: " + getLevelPrice());
		if (res == 0 && player.getPlayerRank().nbrOfLevels() > levels && player.getBalance()>= getLevelPrice()) {
			this.levels+=1;

			player.decreaseBalace(getLevelPrice());
		}
		
	}
	
	public void decreaseLevel() {
		int res = JOptionPane.showConfirmDialog(null, "Do you really want to downgrade " + getName() + " for: " + getLevelPrice());
		if (levels>0 && res == 0) {	
			this.levels-=1;
			player.increaseBalance(getLevelPrice());
		}
	}
		
	public int getLevel() {
		return this.levels;
	}
	
	public void setPurchaseable(boolean b) {
		this.purchaseable = b;
	}	
	
	public void clearProperty() {
		purchaseable = true; 
		setLevel(0);
	}
	
	public ImageIcon getPicture(){
		return this.img;
	}

}
