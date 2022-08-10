package mapper;

import Store.ProductConst;

import java.util.HashMap;

public class MapProductToPrice extends MapProductToAttribute{

    @Override
    public HashMap mapProductToAttribute() {
        ProductConst CONST = new ProductConst();
        HashMap<Integer,Double> productToPriceMap = new HashMap<>(){{
            put(CONST.SN_ONE_BOOK, CONST.PRICE_ONE_BOOK);
            put(CONST.SN_ONE_MUSIC_CD, CONST.PRICE_ONE_MUSIC_CD);
            put(CONST.SN_ONE_CHOCOLATE_BAR, CONST.PRICE_ONE_CHOCOLATE_BAR);
            put(CONST.SN_IMPORTED_BOX_CHOCOLATE, CONST.PRICE_IMPORTED_BOX_CHOCOLATE);
            put(CONST.SN_IMPORTED_BOTTLE_PERFUME_1, CONST.PRICE_IMPORTED_BOTTLE_PERFUME_1);
            put(CONST.SN_IMPORTED_BOTTLE_PERFUME_2, CONST.PRICE_IMPORTED_BOTTLE_PERFUME_2);
            put(CONST.SN_BOTTLE_PERFUME, CONST.PRICE_BOTTLE_PERFUME);
            put(CONST.SN_PACKET_HEADACHE_PILLS, CONST.PRICE_PACKET_HEADACHE_PILLS);
            put(CONST.SN_BOX_IMPORTED_CHOCOLATE, CONST.PRICE_BOX_IMPORTED_CHOCOLATE);
        }};
        return productToPriceMap;
    }
}
