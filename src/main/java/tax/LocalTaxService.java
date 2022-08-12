package tax;

import product.Product;
import store.ProductCategory;

public class LocalTaxService implements TaxService{
    @Override
    public Double calculateTax(Product product) {
        if (product.getCategory().equals(ProductCategory.OTHER)) {
            return taxForOtherProduct(product);
        }
        return taxForExemptedProduct(product);
    }

    @Override
    public Double taxForExemptedProduct (Product product) {
        return 0.0;
    }

    @Override
    public Double taxForOtherProduct (Product product) {
        return product.getPrice()*0.10;
    }

}
