package tax;

import product.Product;

public interface TaxService {
    Double calculateTax(Product product);
    Double taxForExemptedProduct(Product product);
    Double taxForOtherProduct(Product product);
}
