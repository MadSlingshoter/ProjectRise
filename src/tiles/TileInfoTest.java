package tiles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileInfoTest {

    @Test
    void getTitleLowBoarder() {
        TileInfo tileInfo = new TileInfo();
        assertEquals("Go", tileInfo.getTitle(0));
    }

    @Test
    void getTitleNull() {
        TileInfo tileInfo = new TileInfo();
        assertEquals("40", tileInfo.getTitle(39));
    }
}