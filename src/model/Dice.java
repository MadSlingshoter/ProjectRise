package model;

/**
 * Class for handling dice rolls.
 */
public class Dice {
    private int numOfDice;
    private int totalRoll;
    private int[] diceRolls;

    /**
     * Constructor.
     */
    public Dice() {
        numOfDice = 2;
        totalRoll = 0;
        diceRolls = new int[numOfDice];
    }

    /**
     * Rolls two six-sided dice, and adds the total.
     * @return the numbers rolled on the dice.
     */
    public int[] rollDice() {
        diceRolls = new int[numOfDice];
        totalRoll = 0;
        for (int i = 0; i < numOfDice; i++) {
            diceRolls[i] = (int) (Math.random() * (6) + 1);
            totalRoll += diceRolls[i];
        }
        return diceRolls;
    }

    /**
     * Doubles the roll total.
     */
    public void doubleRoll() {
        totalRoll *= 2;
    }

    /**
     * Sets the total roll number.
     * @param totalRoll the number to set.
     */
    public void setTotalRoll(int totalRoll) {
        this.totalRoll = totalRoll;
    }

    /**
     * Returns the total roll number.
     * @return the total roll number.
     */
    public int getTotalRoll() {
        return totalRoll;
    }


}
