package service;

import product.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductsFromInputItems (List<Integer> basket);
    Product getProductForItemKey (Integer itemKey);
}
