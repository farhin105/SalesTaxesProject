package repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import constant.ProductCategory;
import model.store.Store;

import java.util.HashMap;

public class StoreRepository {

    private static final Logger logger = LoggerFactory.getLogger(StoreRepository.class);

    private final Store store;

    public StoreRepository() {
        store = Store.getINSTANCE();
    }

    public HashMap<Integer, String> getProductsInStore() {
        return store.getProductsInStore();
    }

    public HashMap<Integer, Double> getProductToPriceMap() {
        return store.getProductToPriceMap();
    }

    public HashMap<Integer, ProductCategory> getProductToCategoryMap() {
        return store.getProductToCategoryMap();
    }

    public Integer getStoreSize () { return store.getProductToPriceMap().size(); }

    public String getNameOfItem (Integer key) {
        logger.info("getNameOfItem (Integer key) : getting name corresponding to the key = {}.",key);
        HashMap<Integer, String> productsInStore = store.getProductsInStore();
        if (productsInStore==null || !productsInStore.containsKey(key)) {
            logger.error("getNameOfItem (Integer key) : key = {}, does not exists.",key);
            return null;
        }
        return productsInStore.get(key);
    }

    public Double getPriceOfItem (Integer key) {
        logger.info("getPriceOfItem (Integer key) : getting price corresponding to the key = {}.",key);
        HashMap<Integer, Double> prices = store.getProductToPriceMap();
        if (prices==null || !prices.containsKey(key)) {
            logger.error("getPriceOfItem (Integer key) : key = {}, does not exists.",key);
            return null;
        }
        return prices.get(key);
    }

    public ProductCategory getCategoryOfItem (Integer key) {
        logger.info("getCategoryOfItem (Integer key) : getting category corresponding to the key = {}.",key);
        HashMap<Integer, ProductCategory> categories = store.getProductToCategoryMap();
        if (categories==null || !categories.containsKey(key)) {
            logger.error("getCategoryOfItem (Integer key) : key = {}, does not exists.",key);
            return null;
        }
        return categories.get(key);
    }

    public boolean isItemImported (Integer key) {
        return store.getImportedProductKeySet().contains(key);
    }
}
