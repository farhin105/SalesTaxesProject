import model.billing.Receipt;
import com.google.inject.Guice;
import com.google.inject.Injector;
import model.product.Product;
import service.ReceiptService;
import service.ShoppingService;
import model.store.Store;

import java.util.List;

public class SalesTaxes {
    public static void main(String[] args) {
        System.out.println("---------- SALES TAXES ----------");
        Store store = Store.getINSTANCE();

        Injector injector = Guice.createInjector(new SalesTaxesGuiceModule());

        ShoppingService shoppingService = injector.getInstance(ShoppingService.class);
        List<Integer> items = shoppingService.shop();
        System.out.println(items);
        List<Product> productList = shoppingService.getProducts(items);
        System.out.println(productList);

        ReceiptService receiptService = injector.getInstance(ReceiptService.class);
        //getReceipt
        Receipt receipt = receiptService.getReceipt(productList);
        receiptService.printReceipt(receipt);
    }
}
