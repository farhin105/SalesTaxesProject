package mapper;

import Store.ProductConst;

import java.util.HashMap;
import java.util.logging.Logger;

public class MapProductToPrice extends MapProductToAttribute{

    @Override
    public HashMap mapProductToAttribute() {
        ProductConst CONST = new ProductConst();
        HashMap<Integer,Double> productToPriceMap = new HashMap<>(){{
            put(CONST.SN_ONE_BOOK, CONST.PRICE_ONE_BOOK);
            put(CONST.SN_ONE_MUSIC_CD, CONST.PRICE_ONE_MUSIC_CD);
            put(CONST.SN_ONE_CHOCOLATE_BAR, CONST.PRICE_ONE_CHOCOLATE_BAR);
        }};
        return productToPriceMap;
    }
}
