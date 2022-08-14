package service;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import model.product.Product;

public class BillingService{

    private static final Logger logger = LoggerFactory.getLogger(BillingService.class);

    private final TaxCalculatorService taxCalculatorService;

    @Inject
    public BillingService (TaxCalculatorService taxCalculatorService) {
        this.taxCalculatorService = taxCalculatorService;
    }

    public Double calculateBillOfProduct(Product product) {
        logger.info("calculateBillOfProduct(Product product) : calculating bill of a product");
        return product.getPrice()+ taxCalculatorService.calculateTax(product);
    }


    public Double calculateTaxOfProduct(Product product) {
        logger.info("calculateTaxOfProduct(Product product) : calculating tax of a product");
        return taxCalculatorService.calculateTax(product);
    }
}
