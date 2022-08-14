package model.product;

import constant.ProductCategory;

public class BookProduct extends Product{
    public BookProduct(String name, Double price, ProductCategory category, boolean isImported) {
        super(name, price, category, isImported);
    }
    @Override
    public Double calculateTax() {
        return null;
    }
}
