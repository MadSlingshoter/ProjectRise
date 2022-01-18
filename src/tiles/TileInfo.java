package tiles;

import java.awt.Color;

import events.ManageEvents;

/**
 * Information about each tiles.
 * @author Rohan Samandari
 *
 */
public class TileInfo {
	private String[] info;
	private String[] title;	
	
	public TileInfo() {
		
	}
	
	/**
	 *  An array with all information about each tile/Box.
	 * @param tile gets the index of the tile
	 * @return information about the insert index
	 */
	public String getInfo(int tile) {
		
		info = new String[]{"\n\n            Cash in 200 GC \n"
				+ "            when you pass ",
				"2", "\n\n          Fortune Teller\n            will tell you \n           your fortune", "4", 
				"\n\n           You shall pay\n                  200 GC\n"
				+"          to the church\n", 
				"\n\n               get paid\n     for your hard work",	"7", 
				"\n\n          Fortune Teller\n            will tell you \n           your fortune", "9", "10", 
				"\n\n       Visiting the prison", "12", "13", "14", "15", 
				"\n\n               get paid\n     for your hard work", "17", 
				"\n\n          Fortune Teller\n            will tell you \n           your fortune", "19", "20",
				"\n\n    All of Gods worshippers\n        donations are here \n\t;)" , "22",				
				"\n\n          Fortune Teller\n            will tell you \n           your fortune", "24", "25", 
				"\n\n               get paid\n     for your hard work", 
				"27", "28", "29", "30",	 
				"\n\n   You shall be in the jail \n              for 3 rounds\n "
				+ "     You can pay the bail \n              and get free", "32", 
				"33", "\n\n          Fortune Teller\n            will tell you \n           your fortune", "35", 
				"\n\n               get paid\n     for your hard work", 
				"\n\n          Fortune Teller\n            will tell you \n           your fortune", "38", 
				"\n\n           You shall pay\n                  200 GC\n "
				+ "          to the church\n", "40"};
		return info[tile];
	}
	
	/**
	 * An array with all title names.
	 * @param i, has the index of the tile
	 * @return the title name of the insert index
	 */
	public String getTitle(int i) {
		title = new String[] {"Go", "1", "Fortune Teller", "4", 
				"Church Tax", "Work", "7", "Fortune Teller", "9", "10",
				"Jail", "12", "Western Tavern", "14", "15", 
				"Work", "17", "Fortune Teller", "19", "20", 
				"Sunday church", "22", "Fortune Teller", "24", "25", 
				"Work", "27", "28", "Northern Tavern", "30", 
				"Go To Jail", "32", "33", "Fortune Teller", "35", 
				"Work", "Fortune Teller", "38", "Church Tax", "40"}; 
				
		return title[i];
	}
}
