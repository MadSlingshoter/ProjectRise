package tiles;

import java.awt.Color;

import javax.swing.ImageIcon;
/**
 * All tiles will implement this interface. Methods listed are
 * common methods for all types of tiles.
 * @author AevanDino, SebastianViro
 */
public interface Tile {

	/**
	 * @return tileName, name of current tile.
	 */
	public String getName();

	/**
	 * @return if tile can be bought.
	 */
	public Boolean getPurchaseable(); 


	/**
	 * @return color, returns a color-object representing color of tile.
	 */
	public Color getColor();

	/**
	 * @return info, information about tile. (Price, owner, stuff).
	 */
	public String getTileInfo();
	
	/**
	 * @return the tile title.
	 */
	public String getTitle();
		
	/**
	 * @return picture of the tile.
	 */
	public ImageIcon getPicture();

}
