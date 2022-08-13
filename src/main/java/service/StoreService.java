package service;

import mapper.MapKeyToCategory;
import mapper.MapKeyToName;
import mapper.MapKeyToPrice;
import store.ProductCategory;
import store.ProductConstants;

import java.util.HashMap;
import java.util.HashSet;

public class StoreService {
    public HashMap<Integer, String> getNameMap () {
        return new MapKeyToName().mapKeyToName();
    }

    public HashMap<Integer, ProductCategory> getCategoryMap() {
        return new MapKeyToCategory().mapKeyToCategory();
    }

    public HashMap<Integer, Double> getPriceMap () {
        return new MapKeyToPrice().mapKeyToPrice();
    }

    public HashSet<Integer> getImportedProductSet () {
        return new HashSet<Integer>(){{
            add(4);
            add(5);
            add(6);
            add(9);
        }};
    }
}
