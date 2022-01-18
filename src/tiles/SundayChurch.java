package tiles;

import java.awt.Color;

import javax.swing.ImageIcon;

/**
 * Player does not have to pay anything and doesn't get paid for it. // But the player gets all the collected church taxes.
 * @author AevanDino, SebastianViro
 */
public class SundayChurch implements Tile {
	private ImageIcon img = new ImageIcon("tilePics/church.png");
	String info;

	public void onLanding() {

	}

	public String getName() {
		return "Sunday Church";
	}

	public Boolean getPurchaseable() {
		return Boolean.FALSE;
	}

	public Color getColor() {
		return Color.WHITE;
	}

	public String getTileInfo() {
		info = "Sunday Church \nPlayer attends church, free of charge";
		return info;
	}

	public String getTitle() {
		return null;
	}
	
	public ImageIcon getPicture(){
		return img;
	}

}
