package mapper;

import Store.ProductConstants;

import java.util.HashMap;

public class MapKeyToPrice extends MapKeyToAttribute{

    @Override
    public HashMap mapKeyToAttribute() {
        ProductConstants CONST = new ProductConstants();
        HashMap<Integer,Double> keyToPriceMap = new HashMap<>(){{
            put(CONST.KEY_ONE_BOOK, CONST.PRICE_ONE_BOOK);
            put(CONST.KEY_ONE_MUSIC_CD, CONST.PRICE_ONE_MUSIC_CD);
            put(CONST.KEY_ONE_CHOCOLATE_BAR, CONST.PRICE_ONE_CHOCOLATE_BAR);
            put(CONST.KEY_IMPORTED_BOX_CHOCOLATE, CONST.PRICE_IMPORTED_BOX_CHOCOLATE);
            put(CONST.KEY_IMPORTED_BOTTLE_PERFUME_1, CONST.PRICE_IMPORTED_BOTTLE_PERFUME_1);
            put(CONST.KEY_IMPORTED_BOTTLE_PERFUME_2, CONST.PRICE_IMPORTED_BOTTLE_PERFUME_2);
            put(CONST.KEY_BOTTLE_PERFUME, CONST.PRICE_BOTTLE_PERFUME);
            put(CONST.KEY_PACKET_HEADACHE_PILLS, CONST.PRICE_PACKET_HEADACHE_PILLS);
            put(CONST.KEY_BOX_IMPORTED_CHOCOLATE, CONST.PRICE_BOX_IMPORTED_CHOCOLATE);
        }};
        return keyToPriceMap;
    }
}
