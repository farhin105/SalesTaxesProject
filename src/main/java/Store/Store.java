package Store;

import java.util.HashMap;

public final class Store {
    private static Store INSTANCE;

    private static HashMap<Integer, String> productsInStore;
    private static HashMap<Integer, Double> productToPriceMap;
    private static HashMap<Integer, ProductCategory> productToCategoryMap;

    private Store () {

    }

    public static Store getINSTANCE () {
        if (INSTANCE==null) {
            INSTANCE = new Store();
            INSTANCE.initializeStore();
        }
        return INSTANCE;
    }
    public static void initializeStore () {
        addProductsInStore();
        mapProductsToPrice();
        mapProductsToCategory();
    }

    public static void addProductsInStore () {
        ProductConst CONST = new ProductConst();
        productsInStore = new HashMap<>(){{
            put(CONST.SN_ONE_BOOK, CONST.ONE_BOOK);
            put(CONST.SN_ONE_MUSIC_CD, CONST.ONE_MUSIC_CD);
            put(CONST.SN_ONE_CHOCOLATE_BAR, CONST.ONE_CHOCOLATE_BAR);
        }};
    }

    public static void mapProductsToPrice () {
        ProductConst CONST = new ProductConst();
        productToPriceMap = new HashMap<>(){{
            put(CONST.SN_ONE_BOOK, CONST.PRICE_ONE_BOOK);
            put(CONST.SN_ONE_MUSIC_CD, CONST.PRICE_ONE_MUSIC_CD);
            put(CONST.SN_ONE_CHOCOLATE_BAR, CONST.PRICE_ONE_CHOCOLATE_BAR);
        }};
    }

    public static void mapProductsToCategory () {
        ProductConst CONST = new ProductConst();
        productToCategoryMap = new HashMap<>(){{
            put(CONST.SN_ONE_BOOK, CONST.CATEGORY_ONE_BOOK);
            put(CONST.SN_ONE_MUSIC_CD, CONST.CATEGORY_ONE_MUSIC_CD);
            put(CONST.SN_ONE_CHOCOLATE_BAR, CONST.CATEGORY_ONE_CHOCOLATE_BAR);
        }};
    }

    public static HashMap<Integer, String> getProductsInStore() {
        return productsInStore;
    }

    public static HashMap<Integer, Double> getProductToPriceMap() {
        return productToPriceMap;
    }

    public static HashMap<Integer, ProductCategory> getProductToCategoryMap() {
        return productToCategoryMap;
    }
}
