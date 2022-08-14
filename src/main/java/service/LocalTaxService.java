package service;

import model.product.Product;
import constant.ProductCategory;

public class LocalTaxService implements TaxService{
    @Override
    public Double calculateTax(Product product) {
        if (product.getCategory().equals(ProductCategory.OTHER)) {
            return taxForOtherProduct(product);
        }
        return taxForExemptedProduct(product);
    }

    private Double taxForExemptedProduct (Product product) {
        return 0.0;
    }

    private Double taxForOtherProduct (Product product) {
        return product.getPrice()*0.10;
    }

}
