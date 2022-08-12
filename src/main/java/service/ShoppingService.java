package service;

import product.Product;

import java.util.List;

public interface ShoppingService {
    List<Integer> shop ();
    void showShopScreen ();
    List<Product> getProducts (List<Integer> inputItems);
}
