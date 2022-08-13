package store;

import mapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.StoreService;

import java.util.HashMap;
import java.util.HashSet;

public final class Store {
    private static Logger logger = LoggerFactory.getLogger(Store.class);

    private static Store INSTANCE;

    private static HashMap<Integer, String> productsInStore;
    private static HashMap<Integer, Double> productToPriceMap;
    private static HashMap<Integer, ProductCategory> productToCategoryMap;
    private static HashSet<Integer> importedProductKeySet;
    private Store () {

    }

    public static Store getINSTANCE () {
        if (INSTANCE==null) {
            logger.info("getINSTANCE() : initiating Store Instance" );
            INSTANCE = new Store();
            INSTANCE.initializeStore();
        }
        return INSTANCE;
    }
    public static void initializeStore () {
        addProductsInStore();
        mapProductsToPrice();
        mapProductsToCategory();
        setImportedProductKeys ();
    }

    private static void addProductsInStore () {
        logger.info("addProductsInStore () : adding key to name map in hashmap productsInStore");

        productsInStore = new StoreService().getNameMap();
    }

    private static void mapProductsToPrice () {
        logger.info("mapProductsToPrice () : adding key to price map in hashmap productsInStore");

        productToPriceMap = new StoreService().getPriceMap();
    }

    private static void mapProductsToCategory () {
        logger.info("mapProductsToCategory () : adding key to category map in hashmap productsInStore");

        productToCategoryMap = new StoreService().getCategoryMap();
    }

    private static void setImportedProductKeys () {
        logger.info("setImportedProductKeys () : adding keys of imported items in hashset productsInStore");

        importedProductKeySet = new StoreService().getImportedProductSet();
    }

    public static HashSet<Integer> getImportedProductKeySet() {
        return importedProductKeySet;
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
