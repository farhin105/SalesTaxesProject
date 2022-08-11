package product;

import store.ProductCategory;

public class MedicalProduct extends Product{

    public MedicalProduct(String name, Double price, ProductCategory category, boolean isImported) {
        super(name, price, category, isImported);
    }
    @Override
    public Double calculateTax() {
        return null;
    }
}