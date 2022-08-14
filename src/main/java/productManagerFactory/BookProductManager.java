package productManagerFactory;

import model.product.BookProduct;
import model.product.Product;
import constant.ProductCategory;

public class BookProductManager extends ProductManager{
    @Override
    public Product createProduct(String name, Double price, boolean isImported) {
        return new BookProduct(name, price, ProductCategory.BOOK, isImported);
    }
}
