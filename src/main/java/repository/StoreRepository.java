package repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import store.ProductCategory;
import store.Store;

import java.util.HashMap;

public class StoreRepository {

    private final Logger logger = LoggerFactory.getLogger(StoreRepository.class);

    Store store;

    public StoreRepository() {
        store = Store.getINSTANCE();
    }

    public HashMap<Integer, String> getProductsInStore() {
        return Store.getProductsInStore();
    }

    public HashMap<Integer, Double> getProductToPriceMap() {
        return Store.getProductToPriceMap();
    }

    public HashMap<Integer, ProductCategory> getProductToCategoryMap() {
        return Store.getProductToCategoryMap();
    }

    public Integer getStoreSize () { return Store.getProductToPriceMap().size(); }

    public String getNameOfItem (Integer key) {
        logger.info("getNameOfItem (Integer key) : getting name corresponding to the key = {}.",key);
        HashMap<Integer, String> productsInStore = Store.getProductsInStore();
        if (productsInStore==null || !productsInStore.containsKey(key)) {
            logger.error("getNameOfItem (Integer key) : key = {}, does not exists.",key);
        }
        return productsInStore.get(key);
    }

    public Double getPriceOfItem (Integer key) {
        logger.info("getPriceOfItem (Integer key) : getting price corresponding to the key = {}.",key);
        HashMap<Integer, Double> prices = Store.getProductToPriceMap();
        if (prices==null || !prices.containsKey(key)) {
            logger.error("getPriceOfItem (Integer key) : key = {}, does not exists.",key);
        }
        return prices.get(key);
    }

    public ProductCategory getCategoryOfItem (Integer key) {
        logger.info("getCategoryOfItem (Integer key) : getting category corresponding to the key = {}.",key);
        HashMap<Integer, ProductCategory> categories = Store.getProductToCategoryMap();
        if (categories==null || !categories.containsKey(key)) {
            logger.error("getCategoryOfItem (Integer key) : key = {}, does not exists.",key);
        }
        return categories.get(key);
    }

    public boolean isItemImported (Integer key) {
        return key==4 || key==5 || key==6 || key==9;
    }
}
