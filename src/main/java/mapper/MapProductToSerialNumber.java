package mapper;

import Store.ProductConst;

import java.util.HashMap;

public class MapProductToSerialNumber extends MapProductToAttribute{

    @Override
    public HashMap mapProductToAttribute() {
        ProductConst CONST = new ProductConst();
        HashMap<Integer, String> productsToSerialNumberMap = new HashMap<>(){{
            put(CONST.SN_ONE_BOOK, CONST.ONE_BOOK);
            put(CONST.SN_ONE_MUSIC_CD, CONST.ONE_MUSIC_CD);
            put(CONST.SN_ONE_CHOCOLATE_BAR, CONST.ONE_CHOCOLATE_BAR);
            put(CONST.SN_IMPORTED_BOX_CHOCOLATE, CONST.ONE_IMPORTED_BOX_CHOCOLATE);
            put(CONST.SN_IMPORTED_BOTTLE_PERFUME_1, CONST.ONE_IMPORTED_BOTTLE_PERFUME_1);
            put(CONST.SN_IMPORTED_BOTTLE_PERFUME_2, CONST.ONE_IMPORTED_BOTTLE_PERFUME_2);
            put(CONST.SN_BOTTLE_PERFUME, CONST.ONE_BOTTLE_PERFUME);
            put(CONST.SN_PACKET_HEADACHE_PILLS, CONST.ONE_PACKET_HEADACHE_PILLS);
            put(CONST.SN_BOX_IMPORTED_CHOCOLATE, CONST.ONE_BOX_IMPORTED_CHOCOLATE);
        }};
        return productsToSerialNumberMap;
    }
}
