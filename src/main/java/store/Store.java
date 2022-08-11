package store;

import mapper.MapKeyToAttribute;
import mapper.MapKeyToCategory;
import mapper.MapKeyToName;
import mapper.MapKeyToPrice;
import org.apache.log4j.Logger;

import java.util.HashMap;

public final class Store {
    private static Store INSTANCE;

    private static HashMap<Integer, String> productsInStore;
    private static HashMap<Integer, Double> productToPriceMap;
    private static HashMap<Integer, ProductCategory> productToCategoryMap;

    private static Logger logger = Logger.getLogger(Store.class);

    private Store () {

    }

    public static Store getINSTANCE () {
        if (INSTANCE==null) {
            logger.info("initiating Store Instance");
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
        logger.info("adding key to name map in hashmap productsInStore");
        MapKeyToAttribute keyToNameMap = new MapKeyToName();
        productsInStore = keyToNameMap.getMap();
    }

    public static void mapProductsToPrice () {
        logger.info("adding key to price map in hashmap productsInStore");
        MapKeyToAttribute keyToPriceMap = new MapKeyToPrice();
        productToPriceMap = keyToPriceMap.getMap();
    }

    public static void mapProductsToCategory () {
        logger.info("adding key to category map in hashmap productsInStore");
        MapKeyToAttribute keyToCategoryMap = new MapKeyToCategory();
        productToCategoryMap = keyToCategoryMap.getMap();
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
