package product;

import store.ProductCategory;

public class OtherProduct extends Product{
    public OtherProduct (String name, Double price, ProductCategory category, boolean isImported) {
        super(name, price, category, isImported);
    }

    @Override
    public Double calculateTax() {
        return null;
    }
}
