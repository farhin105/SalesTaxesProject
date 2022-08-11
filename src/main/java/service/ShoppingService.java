package service;

import product.Product;

import java.util.List;

public interface ShoppingService {
    void shop ();
    void showShopScreen ();
    List<Product> getShoppingBasket ();
}
