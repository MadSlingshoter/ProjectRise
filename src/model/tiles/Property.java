package model.tiles;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.player.Player;

/**
 * Class for property.
 * @author Sebastian Viro, Aevan Dino, Muhammad Abdulkhuder
 * Updated 2022-02-05 by Mattias Bengtsson: MVC architecture restructuring. Moved controller methods to GameLogic.
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
		return name;
	}

	public void setPurchaseable(Boolean canBeBought) {
		this.purchaseable=canBeBought;
	}

	public Boolean getPurchaseable() {
		return purchaseable;
	}

	public void setColor(Color colorOfTile) {
		this.color=colorOfTile;
	}

	public Color getColor() {
		return color;
	} 

	public void setPrice(int price) {
		this.price=price;
	}

	public int getPrice() {
		return price;
	}

	
	public void setOwner(Player newOwner) {
		this.player = newOwner;
	}
	
	public Player getOwner() {
		return player;
	}
	
	
	public void setDefaultRent(int defaultRent) {
		this.defaultRent = defaultRent;
	}

	public int getDefaultRent() {
		return defaultRent;
	}

	public void setRentPerLevel(int rentPerLevel) {
		this.rentPerLevel = rentPerLevel;
	}

	public int getRentPerLevel() {
		return rentPerLevel;
	}
	
	public int getTotalRent() {
		return defaultRent + (rentPerLevel * levels);
	}
	
	public void setLevel(int levels) {
		this.levels=levels;
	}
	
	public int getLevelPrice() {
		return levelPrice;
	}
 
	public void setLevelPrice(int levelPrice) {
		this.levelPrice = levelPrice;
	}
	
	public boolean increaseLevel() {
		if (player.getPlayerRank().nbrOfLevels() > levels) {
			levels+=1;
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean decreaseLevel() {
		if (levels > 0) {
			levels -= 1;
			return true;
		} else {
			return false;
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
