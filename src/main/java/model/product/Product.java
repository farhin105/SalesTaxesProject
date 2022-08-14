package model.product;

import constant.ProductCategory;

public abstract class Product {
    private String name;
    private Double price;
    private ProductCategory category;
    private boolean isImported;

    public abstract Double calculateTax();

    public Product(){};
    public Product(String name, Double price, ProductCategory category, boolean isImported) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.isImported = isImported;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public boolean isImported() {
        return isImported;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", isImported=" + isImported +
                '}';
    }
}
