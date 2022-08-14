package model.store;

import constant.ProductCategory;
import constant.ProductConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;

public final class Store {
    private static final Logger logger = LoggerFactory.getLogger(Store.class);

    private static Store INSTANCE;

    private HashMap<Integer, String> productsInStore;
    private HashMap<Integer, Double> productToPriceMap;
    private HashMap<Integer, ProductCategory> productToCategoryMap;
    private HashSet<Integer> importedProductKeySet;

    private Store () {
        initializeStore();
    }

    public static Store getINSTANCE () {
        if (INSTANCE==null) {
            logger.info("getINSTANCE() : initiating Store Instance" );
            INSTANCE = new Store();
        }
        return INSTANCE;
    }
    private void initializeStore () {
        setProductsInStore();;
        setProductToPriceMap();
        setProductToCategoryMap();
        setImportedProductKeySet();
    }

    private void setProductsInStore() {
        this.productsInStore = new HashMap<>(){{
            put(ProductConstants.KEY_ONE_BOOK, ProductConstants.NAME_ONE_BOOK);
            put(ProductConstants.KEY_ONE_MUSIC_CD, ProductConstants.NAME_ONE_MUSIC_CD);
            put(ProductConstants.KEY_ONE_CHOCOLATE_BAR, ProductConstants.NAME_ONE_CHOCOLATE_BAR);
            put(ProductConstants.KEY_IMPORTED_BOX_CHOCOLATE, ProductConstants.NAME_ONE_IMPORTED_BOX_CHOCOLATE);
            put(ProductConstants.KEY_IMPORTED_BOTTLE_PERFUME_1, ProductConstants.NAME_ONE_IMPORTED_BOTTLE_PERFUME_1);
            put(ProductConstants.KEY_IMPORTED_BOTTLE_PERFUME_2, ProductConstants.NAME_ONE_IMPORTED_BOTTLE_PERFUME_2);
            put(ProductConstants.KEY_BOTTLE_PERFUME, ProductConstants.NAME_ONE_BOTTLE_PERFUME);
            put(ProductConstants.KEY_PACKET_HEADACHE_PILLS, ProductConstants.NAME_ONE_PACKET_HEADACHE_PILLS);
            put(ProductConstants.KEY_BOX_IMPORTED_CHOCOLATE, ProductConstants.NAME_ONE_BOX_IMPORTED_CHOCOLATE);
        }};
    }

    private void setProductToPriceMap() {
        this.productToPriceMap = new HashMap<>(){{
            put(ProductConstants.KEY_ONE_BOOK, ProductConstants.PRICE_ONE_BOOK);
            put(ProductConstants.KEY_ONE_MUSIC_CD, ProductConstants.PRICE_ONE_MUSIC_CD);
            put(ProductConstants.KEY_ONE_CHOCOLATE_BAR, ProductConstants.PRICE_ONE_CHOCOLATE_BAR);
            put(ProductConstants.KEY_IMPORTED_BOX_CHOCOLATE, ProductConstants.PRICE_IMPORTED_BOX_CHOCOLATE);
            put(ProductConstants.KEY_IMPORTED_BOTTLE_PERFUME_1, ProductConstants.PRICE_IMPORTED_BOTTLE_PERFUME_1);
            put(ProductConstants.KEY_IMPORTED_BOTTLE_PERFUME_2, ProductConstants.PRICE_IMPORTED_BOTTLE_PERFUME_2);
            put(ProductConstants.KEY_BOTTLE_PERFUME, ProductConstants.PRICE_BOTTLE_PERFUME);
            put(ProductConstants.KEY_PACKET_HEADACHE_PILLS, ProductConstants.PRICE_PACKET_HEADACHE_PILLS);
            put(ProductConstants.KEY_BOX_IMPORTED_CHOCOLATE, ProductConstants.PRICE_BOX_IMPORTED_CHOCOLATE);
        }};
    }

    private void setProductToCategoryMap() {
        this.productToCategoryMap = new HashMap<>(){{
            put(ProductConstants.KEY_ONE_BOOK, ProductConstants.CATEGORY_ONE_BOOK);
            put(ProductConstants.KEY_ONE_MUSIC_CD, ProductConstants.CATEGORY_ONE_MUSIC_CD);
            put(ProductConstants.KEY_ONE_CHOCOLATE_BAR, ProductConstants.CATEGORY_ONE_CHOCOLATE_BAR);
            put(ProductConstants.KEY_IMPORTED_BOX_CHOCOLATE, ProductConstants.CATEGORY_IMPORTED_BOX_CHOCOLATE);
            put(ProductConstants.KEY_IMPORTED_BOTTLE_PERFUME_1, ProductConstants.CATEGORY_IMPORTED_BOTTLE_PERFUME_1);
            put(ProductConstants.KEY_IMPORTED_BOTTLE_PERFUME_2, ProductConstants.CATEGORY_IMPORTED_BOTTLE_PERFUME_2);
            put(ProductConstants.KEY_BOTTLE_PERFUME, ProductConstants.CATEGORY_BOTTLE_PERFUME);
            put(ProductConstants.KEY_PACKET_HEADACHE_PILLS, ProductConstants.CATEGORY_PACKET_HEADACHE_PILLS);
            put(ProductConstants.KEY_BOX_IMPORTED_CHOCOLATE, ProductConstants.CATEGORY_BOX_IMPORTED_CHOCOLATE);
        }};
    }

    private void setImportedProductKeySet() {
        this.importedProductKeySet = new HashSet<>(){{
            add(4);
            add(5);
            add(6);
            add(9);
        }};
    }

    public HashSet<Integer> getImportedProductKeySet() {
        return importedProductKeySet;
    }

    public HashMap<Integer, String> getProductsInStore() {
        return productsInStore;
    }

    public HashMap<Integer, Double> getProductToPriceMap() {
        return productToPriceMap;
    }

    public HashMap<Integer, ProductCategory> getProductToCategoryMap() {
        return productToCategoryMap;
    }
}
