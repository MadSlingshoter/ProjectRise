package tiles;

import java.awt.Color;

import javax.swing.ImageIcon;

import player.Player;

public class Tax implements Tile {

	private final static String NAME = "Kings tax";
	private final static Boolean PURCHASABLE = false;
	private final static Color COLOR = Color.WHITE;
	private String info, tileName;
	private static Player player;
	private int taxToPay = 200;
	private ImageIcon img = new ImageIcon("tilePics/tax.png");
	
	public Tax() {
		
	}
	public void onLanding() {
		taxToPay =  player.getPlayerRank().calculateTax();
	}
	
	public int getTax() {
		return this.taxToPay;
	}

	public String getName() {
		return this.NAME;
	}

	public Boolean getPurchaseable() {
		return this.PURCHASABLE;
	}

	public Color getColor() {
		return this.COLOR;
	}
	
	public String getTileInfo() { 
		info = getName() + "\n"
				+ "Owner: \t \t" 			+ "The king" + "\n"
				+ "Peasant tax: \t" 		+ "100 gold coins" + "\n"
				+ "Knight tax: \t" 		+ "150 gold coins" + "\n"
				+ "Lord tax: \t" 	        + "200 gold coins"+ "\n"
				+ "\n"
				+ "Your tax: \t" 		    + player.getPlayerRank().calculateTax() + "\n";
		return info;
	}
	@Override
	public String getTitle() {
		return null;
	}

	public ImageIcon getPicture(){
		return img;
	}
}
