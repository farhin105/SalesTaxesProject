package service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import product.BookProduct;
import product.Product;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptServiceTest {

    private final BillingService billingService = Mockito.spy(BillingService.class);

//    @Test
//    void test() {
//        ReceiptService receiptService = new ReceiptService(billingService);
//
//        Mockito.when(billingService.calculateBillOfProduct(Mockito.any(Product.class)))
//                .thenReturn(2.3);
////        Mockito.doReturn(2.3)
////                .when(billingService).calculateBillOfProduct(Mockito.any(Product.class)));
//
//        assertEquals(2.3, receiptService.getTotalBill(new ArrayList<>(){{
//            add(Mockito.any(Product.class));
//        }}));
//    }
}