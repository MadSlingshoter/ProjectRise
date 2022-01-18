package tileCollection;

import javax.swing.JOptionPane;

/**
 * This class picks and shows a chance card. All cards are always available
 * and each card is picked randomly.
 * @author AevanDino, SebastianViro
 */
public class ChanceCard {

	private String[] chanceCard = {"Det här är ett chanskort, hur ser det ut?", "2", "3", "4", "5", "6", "7"};

	/**
	 * Generates a random number between 0 and chanceCard.length and
	 * returns it to the caller.
	 * @return Random integer between 0 and chanceCards.length
	 */
	public int getRandomNumber() {
		return (int) (Math.random()*chanceCard.length);
	}

	/**
	 * Displays the chosen chance card in an JOptionPane
	 */
	public String getChanceCard() {
		return chanceCard[getRandomNumber()];
	}

	/**
	 * Temporary method to show cards
	 */
	public void showCard() {
		// "null, JOptionPane.QUESTION_MESSAGE, null" sets icon to question mark, instead of the usual exclamation mark.
		JOptionPane.showMessageDialog(null, "Chans: " + getChanceCard(), null, JOptionPane.QUESTION_MESSAGE, null);
	}
}