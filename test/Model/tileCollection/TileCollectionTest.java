package Model.tileCollection;

import org.junit.Test;

public class TileCollectionTest {


    /**
     *  Class: TileCollection
     *  Method: getTileAtIndex
     *
     *
     *  Tester: Justine Jensen
     *  Date: 2022-02-04
     */

    @Test
    public void getTileAtIndex() {

        TileCollection TC = new TileCollection();

        for (int i = 0; i < 40; i++){

            System.out.println(TC.getTileAtIndex(i));
        }

    }
}