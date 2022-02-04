package tiles;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TileInfoTest {

    @Test
    void getTitleLowBound() {
        TileInfo tileInfo = new TileInfo();
        assertEquals("Go", tileInfo.getTitle(0));
    }

    @Test
    void getTitleUppBound() {
        TileInfo tileInfo = new TileInfo();
        assertEquals("40", tileInfo.getTitle(39));
    }

    /*
    @Test
    void getTitleTooBig() {
        TileInfo tileInfo = new TileInfo();
        assertEquals("40", tileInfo.getTitle(40));
    }
    
     */
}