package productManagerFactory;

import model.product.FoodProduct;
import model.product.Product;
import constant.ProductCategory;

public class FoodProductManager extends ProductManager {
    @Override
    public Product createProduct(String name, Double price, boolean isImported) {
        return new FoodProduct(name, price, ProductCategory.FOOD, isImported);
    }
}