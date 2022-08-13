package mapper;

import store.ProductConstants;

import java.util.HashMap;

public class MapKeyToName {

    public HashMap<Integer, String> mapKeyToName() {
        ProductConstants CONST = new ProductConstants();

        HashMap<Integer, String> keyToNameMap = new HashMap<>(){{
            put(CONST.KEY_ONE_BOOK, CONST.NAME_ONE_BOOK);
            put(CONST.KEY_ONE_MUSIC_CD, CONST.NAME_ONE_MUSIC_CD);
            put(CONST.KEY_ONE_CHOCOLATE_BAR, CONST.NAME_ONE_CHOCOLATE_BAR);
            put(CONST.KEY_IMPORTED_BOX_CHOCOLATE, CONST.NAME_ONE_IMPORTED_BOX_CHOCOLATE);
            put(CONST.KEY_IMPORTED_BOTTLE_PERFUME_1, CONST.NAME_ONE_IMPORTED_BOTTLE_PERFUME_1);
            put(CONST.KEY_IMPORTED_BOTTLE_PERFUME_2, CONST.NAME_ONE_IMPORTED_BOTTLE_PERFUME_2);
            put(CONST.KEY_BOTTLE_PERFUME, CONST.NAME_ONE_BOTTLE_PERFUME);
            put(CONST.KEY_PACKET_HEADACHE_PILLS, CONST.NAME_ONE_PACKET_HEADACHE_PILLS);
            put(CONST.KEY_BOX_IMPORTED_CHOCOLATE, CONST.NAME_ONE_BOX_IMPORTED_CHOCOLATE);
        }};
        return keyToNameMap;
    }
}
