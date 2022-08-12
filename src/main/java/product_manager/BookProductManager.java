package product_manager;

import product.BookProduct;
import product.Product;
import store.ProductCategory;

public class BookProductManager extends ProductManager{
    @Override
    public Product createProduct(String name, Double price, boolean isImported) {
        System.out.println("Im in book product manager");
        return new BookProduct(name, price, ProductCategory.BOOK, isImported);
    }
}
