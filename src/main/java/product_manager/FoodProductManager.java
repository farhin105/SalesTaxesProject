package product_manager;

import product.FoodProduct;
import product.Product;
import store.ProductCategory;

public class FoodProductManager extends ProductManager {
    @Override
    public Product createProduct(String name, Double price, boolean isImported) {
        return new FoodProduct(name, price, ProductCategory.FOOD, isImported);
    }
}