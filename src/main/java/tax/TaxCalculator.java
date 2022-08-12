package tax;

import product.Product;

public class TaxCalculator {
    public Double calculateTax(Product product) {
        TaxService taxService = getAppropriateTaxService(product);
        return roundValue(taxService.calculateTax(product));
    }

    public TaxService getAppropriateTaxService(Product product) {
        if (product.isImported()) {
            return new ImportedTaxService();
        } else {
            return new LocalTaxService();
        }
    }

    private Double roundValue (Double value) {
        return (Math.round(value * 20.0) )/ 20.0;
    }
}
