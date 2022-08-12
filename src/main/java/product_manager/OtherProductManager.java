package product_manager;

import product.OtherProduct;
import product.Product;
import store.ProductCategory;

public class OtherProductManager extends ProductManager{
    @Override
    public Product createProduct(String name, Double price, boolean isImported) {
        return new OtherProduct(name, price, ProductCategory.OTHER, isImported);
    }
}