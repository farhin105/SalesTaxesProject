package service;

import model.billing.Receipt;
import model.product.*;
import org.junit.jupiter.api.Test;
import constant.ProductCategory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ReceiptServiceTest {

    private final BillingService billingService = mock(BillingService.class);

    private final ReceiptService receiptService = new ReceiptService(billingService);


    private final BookProduct bookProduct = new BookProduct("book1", 12.49, ProductCategory.BOOK,false);
    private final MedicalProduct medicalProduct = new MedicalProduct("medical1", 0.32,ProductCategory.MEDICAL,false);
    private final FoodProduct foodProduct = new FoodProduct("food1", 11.58,ProductCategory.FOOD,true);
    private final OtherProduct otherProduct = new OtherProduct("other1", 10.4, ProductCategory.OTHER,false);


    @Test
    void getTotalBillInputCaseOne() {

        List<Product> productList = new ArrayList<>(){{
            add(bookProduct);
            add(foodProduct);
            add(bookProduct);
        }};

        when(billingService.calculateBillOfProduct(any(Product.class)))
                .thenReturn(20.889999999999997,12.49,13.5155555555,
                        20.889999999999997,12.49,13.5155555555);

        when(billingService.calculateTaxOfProduct(any(Product.class)))
                .thenReturn(1.9)
                .thenReturn(0.0)
                .thenReturn(0.25);


        Receipt receipt = receiptService.getReceipt(productList);

        assertEquals(46.9, receipt.getTotalBill());
        assertEquals(2.15, receipt.getSalesTaxes());
        assertEquals(3, receipt.getProductBillList().size());
        assertEquals(20.89,receipt.getProductBillList().get(0));
        assertEquals(12.49, receipt.getProductBillList().get(1));
        assertEquals(13.52, receipt.getProductBillList().get(2));
    }
}