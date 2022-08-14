package service;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import model.product.Product;

public class BillingService{

    private final Logger logger = LoggerFactory.getLogger(BillingService.class);

    private final TaxCalculatorService taxCalculatorService;

    @Inject
    public BillingService (TaxCalculatorService taxCalculatorService) {
        this.taxCalculatorService = taxCalculatorService;
    }

    public Double calculateBillOfProduct(Product product) {
        return product.getPrice()+ taxCalculatorService.calculateTax(product);
    }


    public Double calculateTaxOfProduct(Product product) {
        return taxCalculatorService.calculateTax(product);
    }
}
