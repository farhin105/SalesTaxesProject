package service;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import product.Product;
import tax.TaxCalculator;

public class BillingService{

    private final Logger logger = LoggerFactory.getLogger(BillingService.class);

    private final TaxCalculator taxCalculator;

    @Inject
    public BillingService (TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public Double calculateBillOfProduct(Product product) {
        return product.getPrice()+taxCalculator.calculateTax(product);
    }


    public Double calculateTaxOfProduct(Product product) {
        return taxCalculator.calculateTax(product);
    }
}
