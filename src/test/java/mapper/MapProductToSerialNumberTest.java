package mapper;

import Store.ProductConst;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MapProductToSerialNumberTest {
    @Test
    void productSnShouldMapToExpectedName () {
        ProductConst CONST = new ProductConst();
        var mapProductToSerialNumber = new MapProductToSerialNumber();
        HashMap<Integer, String> productToSnMap = mapProductToSerialNumber.getMap();

        assertEquals(CONST.ONE_BOOK, productToSnMap.get(CONST.SN_ONE_BOOK));
        assertEquals(CONST.ONE_MUSIC_CD, productToSnMap.get(CONST.SN_ONE_MUSIC_CD));
        assertEquals(CONST.ONE_CHOCOLATE_BAR, productToSnMap.get(CONST.SN_ONE_CHOCOLATE_BAR));
        assertEquals(CONST.ONE_IMPORTED_BOX_CHOCOLATE, productToSnMap.get(CONST.SN_IMPORTED_BOX_CHOCOLATE));
        assertEquals(CONST.ONE_IMPORTED_BOTTLE_PERFUME_1, productToSnMap.get(CONST.SN_IMPORTED_BOTTLE_PERFUME_1));
        assertEquals(CONST.ONE_IMPORTED_BOTTLE_PERFUME_2, productToSnMap.get(CONST.SN_IMPORTED_BOTTLE_PERFUME_2));
        assertEquals(CONST.ONE_BOTTLE_PERFUME, productToSnMap.get(CONST.SN_BOTTLE_PERFUME));
        assertEquals(CONST.ONE_PACKET_HEADACHE_PILLS, productToSnMap.get(CONST.SN_PACKET_HEADACHE_PILLS));
        assertEquals(CONST.ONE_BOX_IMPORTED_CHOCOLATE, productToSnMap.get(CONST.SN_BOX_IMPORTED_CHOCOLATE));

    }

}