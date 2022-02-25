package model;

/**
 * Handles the storing and payout of the church tax.
 * @author Mattias Bengtsson
 */
public class ChurchTax {
    private int taxCounter;
    private final int taxValue = 200;

    /**
     * Constructor
     */
    public ChurchTax() {
        taxCounter = 0;
    }

    /**
     * Increases the counter.
     */
    public void increaseCounter() {
        taxCounter++;
    }

    /**
     * Returns the value currently in the pot.
     * @return the value currently in the pot.
     */
    public int getPot() {
        return taxCounter * taxValue;
    }

    /**
     * Returns the value currently in the pot and resets the counter.
     * @return the value currently in the pot.
     */
    public int payout() {
        int payout = getPot();
        taxCounter = 0;
        return payout;
    }
}
