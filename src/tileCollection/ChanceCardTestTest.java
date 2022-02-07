package tileCollection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class ChanceCardTestTest {

    @BeforeEach
    void setUp() {
        ChanceCardTest chanceCardTest = new ChanceCardTest();
    }

    @Test
    void getRandomNumber() {
        ChanceCardTest chanceCardTest = new ChanceCardTest();
        assertNotEquals(8,chanceCardTest.getRandomNumber());
    }
    @Test
    void printCard(){
        ChanceCardTest chanceCardTest = new ChanceCardTest();
        chanceCardTest.printCard();

    }


}