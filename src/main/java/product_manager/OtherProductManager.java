package product_manager;

import model.product.OtherProduct;
import model.product.Product;
import constant.ProductCategory;

public class OtherProductManager extends ProductManager{
    @Override
    public Product createProduct(String name, Double price, boolean isImported) {
        return new OtherProduct(name, price, ProductCategory.OTHER, isImported);
    }
}