package mapper;

import Store.ProductConst;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MapProductToPriceTest {
    @Test
    void productSnShouldMapToExpectedPrice () {
        ProductConst CONST = new ProductConst();
        var mapProductToPrice = new MapProductToPrice();
        HashMap<Integer, String> mapToPrice = mapProductToPrice.getMap();

        assertEquals(CONST.PRICE_ONE_BOOK, mapToPrice.get(CONST.SN_ONE_BOOK));
        assertEquals(CONST.PRICE_ONE_MUSIC_CD, mapToPrice.get(CONST.SN_ONE_MUSIC_CD));
        assertEquals(CONST.PRICE_ONE_CHOCOLATE_BAR, mapToPrice.get(CONST.SN_ONE_CHOCOLATE_BAR));
        assertEquals(CONST.PRICE_IMPORTED_BOX_CHOCOLATE, mapToPrice.get(CONST.SN_IMPORTED_BOX_CHOCOLATE));
        assertEquals(CONST.PRICE_IMPORTED_BOTTLE_PERFUME_1, mapToPrice.get(CONST.SN_IMPORTED_BOTTLE_PERFUME_1));
        assertEquals(CONST.PRICE_IMPORTED_BOTTLE_PERFUME_2, mapToPrice.get(CONST.SN_IMPORTED_BOTTLE_PERFUME_2));
        assertEquals(CONST.PRICE_BOTTLE_PERFUME, mapToPrice.get(CONST.SN_BOTTLE_PERFUME));
        assertEquals(CONST.PRICE_PACKET_HEADACHE_PILLS, mapToPrice.get(CONST.SN_PACKET_HEADACHE_PILLS));
        assertEquals(CONST.PRICE_BOX_IMPORTED_CHOCOLATE, mapToPrice.get(CONST.SN_BOX_IMPORTED_CHOCOLATE));

    }

}