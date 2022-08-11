package mapper;

import store.ProductConstants;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MapKeyToNameTest {
    @Test
    void keyShouldMapToExpectedName () {
        ProductConstants CONST = new ProductConstants();
        var mapKeyToName = new MapKeyToName();
        HashMap<Integer, String> nameMap = mapKeyToName.getMap();

        assertEquals(CONST.NAME_ONE_BOOK, nameMap.get(CONST.KEY_ONE_BOOK));
        assertEquals(CONST.NAME_ONE_MUSIC_CD, nameMap.get(CONST.KEY_ONE_MUSIC_CD));
        assertEquals(CONST.NAME_ONE_CHOCOLATE_BAR, nameMap.get(CONST.KEY_ONE_CHOCOLATE_BAR));
        assertEquals(CONST.NAME_ONE_IMPORTED_BOX_CHOCOLATE, nameMap.get(CONST.KEY_IMPORTED_BOX_CHOCOLATE));
        assertEquals(CONST.NAME_ONE_IMPORTED_BOTTLE_PERFUME_1, nameMap.get(CONST.KEY_IMPORTED_BOTTLE_PERFUME_1));
        assertEquals(CONST.NAME_ONE_IMPORTED_BOTTLE_PERFUME_2, nameMap.get(CONST.KEY_IMPORTED_BOTTLE_PERFUME_2));
        assertEquals(CONST.NAME_ONE_BOTTLE_PERFUME, nameMap.get(CONST.KEY_BOTTLE_PERFUME));
        assertEquals(CONST.NAME_ONE_PACKET_HEADACHE_PILLS, nameMap.get(CONST.KEY_PACKET_HEADACHE_PILLS));
        assertEquals(CONST.NAME_ONE_BOX_IMPORTED_CHOCOLATE, nameMap.get(CONST.KEY_BOX_IMPORTED_CHOCOLATE));

    }
}