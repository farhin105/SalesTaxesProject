package mapper;

import store.ProductCategory;
import store.ProductConstants;

import java.util.HashMap;

public class MapKeyToCategory extends MapKeyToAttribute{

    @Override
    public HashMap mapKeyToAttribute() {
        ProductConstants CONST = new ProductConstants();
        HashMap<Integer, ProductCategory> keyToCategoryMap = new HashMap<>(){{
            put(CONST.KEY_ONE_BOOK, CONST.CATEGORY_ONE_BOOK);
            put(CONST.KEY_ONE_MUSIC_CD, CONST.CATEGORY_ONE_MUSIC_CD);
            put(CONST.KEY_ONE_CHOCOLATE_BAR, CONST.CATEGORY_ONE_CHOCOLATE_BAR);
            put(CONST.KEY_IMPORTED_BOX_CHOCOLATE, CONST.CATEGORY_IMPORTED_BOX_CHOCOLATE);
            put(CONST.KEY_IMPORTED_BOTTLE_PERFUME_1, CONST.CATEGORY_IMPORTED_BOTTLE_PERFUME_1);
            put(CONST.KEY_IMPORTED_BOTTLE_PERFUME_2, CONST.CATEGORY_IMPORTED_BOTTLE_PERFUME_2);
            put(CONST.KEY_BOTTLE_PERFUME, CONST.CATEGORY_BOTTLE_PERFUME);
            put(CONST.KEY_PACKET_HEADACHE_PILLS, CONST.CATEGORY_PACKET_HEADACHE_PILLS);
            put(CONST.KEY_BOX_IMPORTED_CHOCOLATE, CONST.CATEGORY_BOX_IMPORTED_CHOCOLATE);
        }};
        return keyToCategoryMap;
    }
}
