package view.startMenu;

import controller.GameLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing class for textfield inputs
 * @author Nicholas Narvell & Marcus Juninger
 * @date 2022-03-02
 */
class StartingScreenTest {

    StartingScreen ss;
    GameLogic gl;
    String blank;
    String whitespace;
    String notBlankRandom;
    String nullString;
    String name1;
    String name2;
    String name3;
    String name4;

    @BeforeEach
    void setUp() {
        gl = new GameLogic();
        ss = new StartingScreen(gl);
        blank = "";
        whitespace = " ";
        notBlankRandom = "Kalle";
        nullString = null;
        name1 = "Kalle";
        name2 = "Inte Kalle";
        name3 = "Inte Kalle 2";
        name4 = "Abolsut inte kalle";
    }

    @Test
    void textFieldsAllBlank() {
        assertTrue(ss.textFieldsBlank(blank, blank, blank, blank));
    }
    @Test
    void textFieldsWWWW() {
        assertTrue(ss.textFieldsBlank(whitespace, whitespace, whitespace, whitespace));
    }
    @Test
    void textFieldsnBnBnBnB() {
        assertFalse(ss.textFieldsBlank(notBlankRandom, notBlankRandom, notBlankRandom, notBlankRandom));
    }
    @Test
    void textFieldsNNNN() throws Exception {
        assertFalse(ss.textFieldsBlank(nullString, nullString, nullString, nullString));
    }
    @Test
    void textFieldsWBBB() {
        assertTrue(ss.textFieldsBlank(whitespace, blank, blank, blank));
    }
    @Test
    void textFieldsnBrBBB() {
        assertTrue(ss.textFieldsBlank(notBlankRandom, blank, blank, blank));
    }
    @Test
    void textFieldsNBBB() throws Exception {
        assertFalse(ss.textFieldsBlank(nullString, blank, blank, blank));
    }


    @Test
    void playerNamesSame1234() {
        assertFalse(ss.playerNamesSame(name1, name2, name3, name4));
    }

    @Test
    void playerNamesSame1134() {
        assertTrue(ss.playerNamesSame(name1, name1, name3, name4));
    }

    @Test
    void playerNamesSame1214() {
        assertTrue(ss.playerNamesSame(name1, name2, name1, name4));
    }

    @Test
    void playerNamesSame1231() {
        assertTrue(ss.playerNamesSame(name1, name2, name3, name1));
    }

    @Test
    void playerNamesSameCheckNull() {
        assertFalse(ss.playerNamesSame(nullString, name2, name3, name1));
    }
}