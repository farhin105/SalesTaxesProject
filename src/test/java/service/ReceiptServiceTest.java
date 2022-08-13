package service;

import billing.Receipt;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import product.*;
import store.ProductCategory;

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
        }};

        when(billingService.calculateBillOfProduct(any(Product.class)))
                .thenReturn(2.3,2.4,2.3,2.4);

        when(billingService.calculateTaxOfProduct(any(Product.class)))
                .thenReturn(0.3)
                .thenReturn(0.4);


        Receipt receipt = receiptService.getReceipt(productList);

        assertEquals(4.7, receipt.getTotalBill());
        assertEquals(0.7, receipt.getSalesTaxes());
        assertEquals(2, receipt.getProductBillList().size());
        assertEquals(2.3,receipt.getProductBillList().get(0));
        assertEquals(2.4, receipt.getProductBillList().get(1));
    }
}