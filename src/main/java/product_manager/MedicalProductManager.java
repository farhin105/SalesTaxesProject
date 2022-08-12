package product_manager;

import product.MedicalProduct;
import product.Product;
import store.ProductCategory;

public class MedicalProductManager extends ProductManager{
    @Override
    public Product createProduct(String name, Double price, boolean isImported) {
        return new MedicalProduct(name, price, ProductCategory.MEDICAL, isImported);
    }
}
