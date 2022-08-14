package mapper;

import constant.ProductCategory;
import constant.ProductConstants;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MapKeyToCategoryTest {
    @Test
    void keyShouldMapToExpectedCategory () {
        ProductConstants CONST = new ProductConstants();
        var mapKeyToCategory = new MapKeyToCategory();
        HashMap<Integer, ProductCategory> mapToCategory = mapKeyToCategory.mapKeyToCategory();

        assertEquals(CONST.CATEGORY_ONE_BOOK, mapToCategory.get(CONST.KEY_ONE_BOOK));
        assertEquals(CONST.CATEGORY_ONE_MUSIC_CD, mapToCategory.get(CONST.KEY_ONE_MUSIC_CD));
        assertEquals(CONST.CATEGORY_ONE_CHOCOLATE_BAR, mapToCategory.get(CONST.KEY_ONE_CHOCOLATE_BAR));
        assertEquals(CONST.CATEGORY_IMPORTED_BOX_CHOCOLATE, mapToCategory.get(CONST.KEY_IMPORTED_BOX_CHOCOLATE));
        assertEquals(CONST.CATEGORY_IMPORTED_BOTTLE_PERFUME_1, mapToCategory.get(CONST.KEY_IMPORTED_BOTTLE_PERFUME_1));
        assertEquals(CONST.CATEGORY_IMPORTED_BOTTLE_PERFUME_2, mapToCategory.get(CONST.KEY_IMPORTED_BOTTLE_PERFUME_2));
        assertEquals(CONST.CATEGORY_BOTTLE_PERFUME, mapToCategory.get(CONST.KEY_BOTTLE_PERFUME));
        assertEquals(CONST.CATEGORY_PACKET_HEADACHE_PILLS, mapToCategory.get(CONST.KEY_PACKET_HEADACHE_PILLS));
        assertEquals(CONST.CATEGORY_BOX_IMPORTED_CHOCOLATE, mapToCategory.get(CONST.KEY_BOX_IMPORTED_CHOCOLATE));

    }
}