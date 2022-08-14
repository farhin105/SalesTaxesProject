package service;

import constant.ProductCategory;
import constant.ProductConstants;
import model.product.BookProduct;
import model.product.OtherProduct;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BillingServiceTest {

    private final TaxCalculatorService taxCalculatorService = mock(TaxCalculatorService.class);
    private final BillingService billingService = new BillingService(taxCalculatorService);

    private final ProductConstants CONST = new ProductConstants();

    private final BookProduct bookProduct = new BookProduct(CONST.NAME_ONE_BOOK, CONST.PRICE_ONE_BOOK,
            ProductCategory.BOOK,false);
    private final OtherProduct otherProduct = new OtherProduct(CONST.NAME_ONE_BOTTLE_PERFUME,
            CONST.PRICE_BOTTLE_PERFUME,ProductCategory.OTHER,false);


    @Test
    void calculateBillOfProductExpectedOutput () {
        when(taxCalculatorService.calculateTax(bookProduct)).thenReturn(0.0);
        when(taxCalculatorService.calculateTax(otherProduct)).thenReturn(1.9);

        assertEquals(bookProduct.getPrice()+0.0, billingService.calculateBillOfProduct(bookProduct));
        assertEquals(otherProduct.getPrice()+1.9,
                billingService.calculateBillOfProduct(otherProduct));
    }

    @Test
    void calculateTaxOfProductExpectedOutput () {
        when(taxCalculatorService.calculateTax(bookProduct)).thenReturn(0.0);
        when(taxCalculatorService.calculateTax(otherProduct)).thenReturn(1.9);

        assertEquals(0.0, billingService.calculateTaxOfProduct(bookProduct));
        assertEquals(1.9, billingService.calculateTaxOfProduct(otherProduct));
    }

}