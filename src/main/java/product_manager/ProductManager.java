package product_manager;

import product.Product;

public abstract class ProductManager {
    public Product getProduct (String name, Double price, boolean isImported) {

        return createProduct(name,  price,  isImported);
    }
    public abstract Product createProduct(String name, Double price, boolean isImported);
}