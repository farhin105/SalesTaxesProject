package product_manager;

import model.product.BookProduct;
import model.product.Product;
import constant.ProductCategory;

public class BookProductManager extends ProductManager{
    @Override
    public Product createProduct(String name, Double price, boolean isImported) {
        System.out.println("Im in book model.billing.product manager");
        return new BookProduct(name, price, ProductCategory.BOOK, isImported);
    }
}
