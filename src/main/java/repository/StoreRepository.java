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

    public String getNameOfItem (Integer key) {
        return store.getProductsInStore().get(key);
    }

    public Double getPriceOfItem (Integer key) {
        return store.getProductToPriceMap().get(key);
    }

    public ProductCategory getCategoryOfItem (Integer key) {
        return store.getProductToCategoryMap().get(key);
    }

    public boolean isItemImported (Integer key) {
        return key==4 || key==5 || key==6 || key==9;
    }
}
