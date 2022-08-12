package repository;

import store.ProductCategory;
import store.Store;

import java.util.HashMap;

public class StoreRepository {
    Store store;

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
}
