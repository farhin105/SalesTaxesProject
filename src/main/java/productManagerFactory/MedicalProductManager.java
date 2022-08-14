package productManagerFactory;

import model.product.MedicalProduct;
import model.product.Product;
import constant.ProductCategory;

public class MedicalProductManager extends ProductManager{
    @Override
    public Product createProduct(String name, Double price, boolean isImported) {
        return new MedicalProduct(name, price, ProductCategory.MEDICAL, isImported);
    }
}
