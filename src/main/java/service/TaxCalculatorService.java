package service;

import model.product.Product;

public class TaxCalculatorService {
    public Double calculateTax(Product product) {
        TaxService taxService = getTaxService(product);
        return roundValue(taxService.calculateTax(product));
    }

    private TaxService getTaxService(Product product) {
        if (product.isImported()) {
            return new ImportedTaxService();
        } else {
            return new LocalTaxService();
        }
    }

    private Double roundValue (Double value) {
        return (Math.ceil(value * 20.0) )/ 20.0;
    }
}
