package tiles;

import java.awt.Color;

import javax.swing.ImageIcon;

import dice.Dice;
import player.Player;

/**
 * @author Muhammad abdulkhuder, AevanDino, Sebastian Viro, .
 */
public class Work implements Tile {
	private ImageIcon img = new ImageIcon("tilePics/Work.png");
	private Player player;
	private String info;
	private int roll;

	public Work(Player player) {
		this.player = player;
	}

	public Work() {

	}

	public void payPlayer(int nbrOfDots) {
		setRoll(nbrOfDots);
		player.increaseBalance(player.getPlayerRank().getSalary(nbrOfDots));
		player.increaseNetWorth(getPay());

	}

	public int getPay() {

		return player.getPlayerRank().getSalary(getRoll());

	}

	public String getName() {
		return null;
	}

	public Boolean getPurchaseable() {
		return null;
	}

	public Color getColor() {
		return null; 
	}

	public String getTileInfo() {
		info = getName() + "\nPlayer gets to roll the dice, and depending \n"
				+ "on his or her rank they are rewarded gold coins for their effort. \n"
				+ "Peasant: 20 times the sum of the roll \n" + "Knight: 25 times the sum of the roll \n"
				+ "Lord: 30 times the sum of the roll \n" + "Ruler: 40 times the sum of the roll";

		return info;
	}

	public Player setPlayer(Player player) {
		return this.player = player;
	}

	

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getTitleColor() {
		// TODO Auto-generated method stub
		return null;
	}

	public ImageIcon getPicture() {
		return img;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}
}
