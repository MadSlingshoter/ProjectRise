package tiles;

import java.awt.Color;

import javax.swing.ImageIcon;

import player.Player;

/**
 * Simple Go tile class. 
 * @author AevanDino, SebastianViro
 */
public class Go implements Tile {

	private String info;
	private String name = "GO";
	
	private ImageIcon img = new ImageIcon("tilePics/Go.png");
	
	/**
	 * Constructor with name
	 * @param str
	 */
	public Go(String str) {
		this.name = str;
	}
	
	/**
	 * returns name of go
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns false, because go cant be purchased
	 */
	public Boolean getPurchaseable() {
		return Boolean.FALSE;
	}
	
	/**
	 * Returns color of tile
	 */
	public Color getColor() {
		return Color.WHITE;
	}
	
	/**
	 * Returns info about tile
	 */
	public String getTileInfo() {
		info = name + "\n" + "Every time a player passes by, he or she \nis rewarded 200 gold coins";
		return info;
	}
	
	/**
	 * returns null
	 */
	public String getTitle() {
		return null;
	}
	
	/**
	 * returns icon 
	 */
	public ImageIcon getPicture() {
		return img;
	}
}
