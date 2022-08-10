package mapper;

import Store.ProductConst;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MapProductToCategoryTest {
    @Test
    void productSnShouldMapToExpectedCategory () {
        ProductConst CONST = new ProductConst();
        var mapProductToCategory = new MapProductToCategory();
        HashMap<Integer, String> mapToCategory = mapProductToCategory.getMap();

        assertEquals(CONST.CATEGORY_ONE_BOOK, mapToCategory.get(CONST.SN_ONE_BOOK));
        assertEquals(CONST.CATEGORY_ONE_MUSIC_CD, mapToCategory.get(CONST.SN_ONE_MUSIC_CD));
        assertEquals(CONST.CATEGORY_ONE_CHOCOLATE_BAR, mapToCategory.get(CONST.SN_ONE_CHOCOLATE_BAR));
        assertEquals(CONST.CATEGORY_IMPORTED_BOX_CHOCOLATE, mapToCategory.get(CONST.SN_IMPORTED_BOX_CHOCOLATE));
        assertEquals(CONST.CATEGORY_IMPORTED_BOTTLE_PERFUME_1, mapToCategory.get(CONST.SN_IMPORTED_BOTTLE_PERFUME_1));
        assertEquals(CONST.CATEGORY_IMPORTED_BOTTLE_PERFUME_2, mapToCategory.get(CONST.SN_IMPORTED_BOTTLE_PERFUME_2));
        assertEquals(CONST.CATEGORY_BOTTLE_PERFUME, mapToCategory.get(CONST.SN_BOTTLE_PERFUME));
        assertEquals(CONST.CATEGORY_PACKET_HEADACHE_PILLS, mapToCategory.get(CONST.SN_PACKET_HEADACHE_PILLS));
        assertEquals(CONST.CATEGORY_BOX_IMPORTED_CHOCOLATE, mapToCategory.get(CONST.SN_BOX_IMPORTED_CHOCOLATE));

    }

}