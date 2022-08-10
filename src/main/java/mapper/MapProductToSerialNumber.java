package mapper;

import Store.ProductConst;

import java.util.HashMap;
import java.util.logging.Logger;

public class MapProductToSerialNumber extends MapProductToAttribute{

    @Override
    public HashMap mapProductToAttribute() {
        ProductConst CONST = new ProductConst();
        HashMap<Integer, String> productsToSerialNumberMap = new HashMap<>(){{
            put(CONST.SN_ONE_BOOK, CONST.ONE_BOOK);
            put(CONST.SN_ONE_MUSIC_CD, CONST.ONE_MUSIC_CD);
            put(CONST.SN_ONE_CHOCOLATE_BAR, CONST.ONE_CHOCOLATE_BAR);
        }};
        return productsToSerialNumberMap;
    }
}
