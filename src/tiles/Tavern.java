package tiles;

import java.awt.Color;

import javax.swing.ImageIcon;

import player.Player;

public class Tavern implements Tile{
	
	private final static String TAVERN = "Tavern";
	private String info = "";
	private boolean purchasable;
	private Player owner;
	private Color color; 
	private int price;
	private String name;
	private ImageIcon img = new ImageIcon("tilePics/tavern.png");

	public Tavern( String namn, int price) {
		this.name = namn;
		this.price = price;
		this.purchasable = true;
		this.owner = null;
	}
	public void onLanding() {
		// TODO Auto-generated method stub
		
	}

	public String getName() {
		return this.name;
	}

	public Boolean getPurchaseable() {
		return this.purchasable;
	}

	public Color getColor() {
		return null;
	}
	
	public void setOwner(Player newOwner) {
		this.owner = newOwner;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getTileInfo() {
		String ownerName = "";
		if(owner == null) {
			ownerName = "No Owner";
		} else {
			ownerName = owner.getName();
		}
		info =    "\nOwner: \t         " + ownerName + "\n"
				+ "Price:\t\t" + price + "\n"
				+ "Default rent:    Read Rules\n"
				+ "Rent with Levels:\t" 	+ 0 + "\n"
				+ "Total rent:        Read Rules";
		return info;
	}
	
	public void setPurchaseable(boolean b) {
		this.purchasable = b;
	}
	
	public void clearTavern() {
		purchasable = true; 
	}

	public String getTitle() {
		return null;
	}
	
	public ImageIcon getPicture(){
		return img;
	}

}
