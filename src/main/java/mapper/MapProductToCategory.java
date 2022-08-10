package mapper;

import Store.ProductCategory;
import Store.ProductConst;

import java.util.HashMap;
import java.util.logging.Logger;

public class MapProductToCategory extends MapProductToAttribute{

    @Override
    public HashMap mapProductToAttribute() {
        ProductConst CONST = new ProductConst();
        HashMap<Integer, ProductCategory> productToCategoryMap = new HashMap<>(){{
            put(CONST.SN_ONE_BOOK, CONST.CATEGORY_ONE_BOOK);
            put(CONST.SN_ONE_MUSIC_CD, CONST.CATEGORY_ONE_MUSIC_CD);
            put(CONST.SN_ONE_CHOCOLATE_BAR, CONST.CATEGORY_ONE_CHOCOLATE_BAR);
        }};
        return productToCategoryMap;
    }
}
