package Store;

import mapper.MapProductToAttribute;
import mapper.MapProductToCategory;
import mapper.MapProductToPrice;
import mapper.MapProductToSerialNumber;

import java.util.HashMap;
import java.util.logging.Logger;

public final class Store {
    private static Store INSTANCE;

    private static HashMap<Integer, String> productsInStore;
    private static HashMap<Integer, Double> productToPriceMap;
    private static HashMap<Integer, ProductCategory> productToCategoryMap;

    private static Logger logger = Logger.getLogger(Store.class.getName());

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
        logger.info("adding product (serial number to name map) in hashmap productsInStore");
        MapProductToAttribute mapProduct = new MapProductToSerialNumber();
        productsInStore = mapProduct.getMap();
    }

    public static void mapProductsToPrice () {
        logger.info("adding product (serial number to price map) in hashmap productsInStore");
        MapProductToAttribute mapProduct = new MapProductToPrice();
        productToPriceMap = mapProduct.getMap();
    }

    public static void mapProductsToCategory () {
        logger.fine("adding product (serial number to category map) in hashmap productsInStore");
        MapProductToAttribute mapProduct = new MapProductToCategory();
        productToCategoryMap = mapProduct.getMap();
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
