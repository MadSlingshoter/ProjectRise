package tiles;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class TileInfoTest {

    /**
     *  Class: TileInfo
     *  Method: getTitle
     *
     *
     *  Tester: Susanne Vikström
     *  Date: 2022-02-04
     *
     */

    @Test
    public void getTitle() {

        TileInfo Tile = new TileInfo();

       String[] titleArray = new String[] {"Go", "1", "Fortune Teller", "4",
                "Church Tax", "Work", "7", "Fortune Teller", "9", "10",
                "Jail", "12", "Western Tavern", "14", "15",
                "Work", "17", "Fortune Teller", "19", "20",
                "Sunday church", "22", "Fortune Teller", "24", "25",
                "Work", "27", "28", "Northern Tavern", "30",
                "Go To Jail", "32", "33", "Fortune Teller", "35",
                "Work", "Fortune Teller", "38", "Church Tax", "40"};

        for (int i = 0; i < titleArray.length; i++){

            assertEquals(titleArray[i] , Tile.getTitle(i) );
        }



    }



}