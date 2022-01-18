package tileCollection;

import java.awt.Color;

import javax.swing.ImageIcon;

import tiles.FortuneTeller;
import tiles.Go;
import tiles.GoToJail;
import tiles.Jail;
import tiles.Property;
import tiles.SundayChurch;
import tiles.Tavern;
import tiles.Tax;
import tiles.Tile;
import tiles.Work;


/** 
 * Informtion about each tiles. 
 * Price, Title, 
 * @author Rohan, Sebastian, Muhammad Abdulkhuder
 */

public class TileCollection {

	private Tile[] tileArray = new Tile[40];

	public TileCollection() {
		
		tileArray[0] = new Go("GO");
		tileArray[1] = new Property("Wood Cutter Camp", 60, 2, 30, new Color(58,20,56,255), 50,new ImageIcon("tilePics/Wood.png"));
		tileArray[2] = new FortuneTeller();
		tileArray[3] = new Property("Stone Mason Camp", 60, 4, 30, new Color(58,20,56,255),50 ,new ImageIcon("tilePics/stone.png"));
		tileArray[4] = new Tax();
		tileArray[5] = new Work(); 
		tileArray[6] = new Property("Fish Stand", 100, 6, 40, new Color(131, 166, 219, 255),50 ,new ImageIcon("tilePics/fish.png"));
		tileArray[7] = new FortuneTeller();
		tileArray[8] = new Property("Vegetables Stand", 100, 6, 50, new Color(131, 166, 219, 255), 50,new ImageIcon("tilePics/veggieStall.png"));
		tileArray[9] = new Property("Bakery Stand", 120, 8, 60, new Color(131, 166, 219, 255),50, new ImageIcon("tilePics/bakerStall.png"));
		tileArray[10] = new Jail();
		tileArray[11] = new Property("Tannery", 140, 10, 70, new Color(163,61,125,255), 100,new ImageIcon("tilePics/tanner.png"));
		tileArray[12] = new Tavern("Western Tavern", 150);
		tileArray[13] = new Property("Mill", 140, 10, 80, new Color(163,61,125,255), 100,new ImageIcon("tilePics/mill.png"));
		tileArray[14] = new Property("Smith", 160, 12, 80, new Color(163,61,125,255),100, new ImageIcon("tilePics/smith.png"));
		tileArray[15] = new Work();
		tileArray[16] = new Property("Bath House", 180, 14, 100, new Color(191,120,59,255),100, new ImageIcon("tilePics/bath.png"));
		tileArray[17] = new FortuneTeller();
		tileArray[18] = new Property("Bakery", 180, 14, 110, new Color(191,120,59,255),100, new ImageIcon("tilePics/bakerStore.png"));
		tileArray[19] = new Property("Butcher Shop", 200, 16, 120, new Color(191,120,59,255),100, new ImageIcon("tilePics/butcher.png"));
		tileArray[20] = new SundayChurch();
		tileArray[21] = new Property("Warehouse",220 ,18 , 130, new Color(169, 60, 48, 255),150, new ImageIcon("tilePics/warehouse.png"));
		tileArray[22] = new FortuneTeller();
		tileArray[23] = new Property("Alchemy Store", 220,18 ,140 , new Color(169, 60, 48, 255),150, new ImageIcon("tilePics/alch.png"));
		tileArray[24] = new Property("Stable", 240, 20, 75, new Color(169, 60, 48, 255), 150,new ImageIcon("tilePics/stable.png"));
		tileArray[25] = new Work();
		tileArray[26] = new Property("Cobbler", 260, 22, 160,  new Color(254,231,11, 255),150, new ImageIcon("tilePics/cobbler.png"));
		tileArray[27] = new Property("General Store", 260, 22 , 170,  new Color(254,231,11, 55),150, new ImageIcon("tilePics/general.png"));
		tileArray[28] = new Tavern("Northern Tavern", 150);
		tileArray[29] = new Property("Silver Smith", 280, 24, 180,  new Color(254,231,11, 255),150, new ImageIcon("tilePics/silver.png"));
		tileArray[30] = new GoToJail();
		tileArray[31] = new Property("Armorer", 300, 26, 190, new Color(95,178,77, 255),200, new ImageIcon("tilePics/armor.png"));
		tileArray[32] = new Property("Tailor", 300, 26, 200, new Color(95,178,77, 255),200, new ImageIcon("tilePics/tailor.png"));
		tileArray[33] = new FortuneTeller();
		tileArray[34] = new Property("Weapon Smith", 320, 28, 210, new Color(95,178,77, 255),200 ,new ImageIcon("tilePics/weapon.png"));
		tileArray[35] = new Work();
		tileArray[36] = new FortuneTeller();
		tileArray[37] = new Property("Church", 350, 35, 300, new Color(4,74,159, 255),200, new ImageIcon("tilePics/churchp.png"));
		tileArray[38] = new Tax(); 
		tileArray[39] = new Property("The Castle", 400, 50, 400, new Color(4,74,159, 255),200, new ImageIcon("tilePics/castle.png"));		

	}
	
	 
	public Tile getTileAtIndex(int index) {
		return tileArray[index];
	}
	
	
}
