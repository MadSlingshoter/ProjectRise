package tileCollection;

import org.junit.jupiter.api.Test;
import tiles.Tile;

import static org.junit.jupiter.api.Assertions.*;

class TileCollectionTest {

    @Test
    void getTileAtIndex() {
        TileCollection tileCollection = new TileCollection();
       assertNotEquals(40,tileCollection.getTileAtIndex(30));
    }
}