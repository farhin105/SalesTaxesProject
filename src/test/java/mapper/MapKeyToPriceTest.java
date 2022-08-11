package mapper;

import store.ProductConstants;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MapKeyToPriceTest {
    @Test
    void keyShouldMapToExpectedPrice () {
        ProductConstants CONST = new ProductConstants();
        var mapKeyToPrice = new MapKeyToPrice();
        HashMap<Integer, String> mapToPrice = mapKeyToPrice.getMap();

        assertEquals(CONST.PRICE_ONE_BOOK, mapToPrice.get(CONST.KEY_ONE_BOOK));
        assertEquals(CONST.PRICE_ONE_MUSIC_CD, mapToPrice.get(CONST.KEY_ONE_MUSIC_CD));
        assertEquals(CONST.PRICE_ONE_CHOCOLATE_BAR, mapToPrice.get(CONST.KEY_ONE_CHOCOLATE_BAR));
        assertEquals(CONST.PRICE_IMPORTED_BOX_CHOCOLATE, mapToPrice.get(CONST.KEY_IMPORTED_BOX_CHOCOLATE));
        assertEquals(CONST.PRICE_IMPORTED_BOTTLE_PERFUME_1, mapToPrice.get(CONST.KEY_IMPORTED_BOTTLE_PERFUME_1));
        assertEquals(CONST.PRICE_IMPORTED_BOTTLE_PERFUME_2, mapToPrice.get(CONST.KEY_IMPORTED_BOTTLE_PERFUME_2));
        assertEquals(CONST.PRICE_BOTTLE_PERFUME, mapToPrice.get(CONST.KEY_BOTTLE_PERFUME));
        assertEquals(CONST.PRICE_PACKET_HEADACHE_PILLS, mapToPrice.get(CONST.KEY_PACKET_HEADACHE_PILLS));
        assertEquals(CONST.PRICE_BOX_IMPORTED_CHOCOLATE, mapToPrice.get(CONST.KEY_BOX_IMPORTED_CHOCOLATE));

    }
}