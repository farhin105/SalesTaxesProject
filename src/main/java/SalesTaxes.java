import model.billing.Receipt;
import com.google.inject.Guice;
import com.google.inject.Injector;
import model.product.Product;
import service.ReceiptService;
import service.ShoppingService;
import model.store.Store;

import java.util.List;
import java.util.Scanner;

public class SalesTaxes {
    public static void main(String[] args) {
        System.out.println("---------- SALES TAXES ----------");

        Injector injector = Guice.createInjector(new SalesTaxesGuiceModule());

        char continueShopping;
        do {
            ShoppingService shoppingService = injector.getInstance(ShoppingService.class);
            List<Integer> items = shoppingService.shop();
            List<Product> productList = shoppingService.getProducts(items);

            ReceiptService receiptService = injector.getInstance(ReceiptService.class);
            //getReceipt
            Receipt receipt = receiptService.getReceipt(productList);
            receiptService.printReceipt(receipt);

            System.out.println("\ncontinue shopping? [press 'y' continue / any key to terminate]");
            continueShopping = new Scanner(System.in).next().charAt(0);
        } while (continueShopping == 'y');
        System.out.println("\nclosing program....");
    }
}
