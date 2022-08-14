package service;

import model.product.Product;
import constant.ProductCategory;

public class ImportedTaxService implements TaxService{
    @Override
    public Double calculateTax(Product product) {
        if (product.getCategory().equals(ProductCategory.OTHER)) {
            return taxForOtherProduct(product);
        }
        return taxForExemptedProduct(product);
    }

    private Double taxForExemptedProduct (Product product) {
        return product.getPrice()*0.05;
    }

    private Double taxForOtherProduct (Product product) {
        return product.getPrice()*0.15;
    }

}
