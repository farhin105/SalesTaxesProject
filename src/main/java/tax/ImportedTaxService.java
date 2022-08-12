package tax;

import product.Product;
import store.ProductCategory;

public class ImportedTaxService implements TaxService{
    @Override
    public Double calculateTax(Product product) {
        if (product.getCategory().equals(ProductCategory.OTHER)) {
            return taxForOtherProduct(product);
        }
        return taxForExemptedProduct(product);
    }

    @Override
    public Double taxForExemptedProduct (Product product) {
        return product.getPrice()*0.05;
    }

    @Override
    public Double taxForOtherProduct (Product product) {
        return product.getPrice()*0.15;
    }

}
