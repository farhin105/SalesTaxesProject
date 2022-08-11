import service.ShoppingService;
import service.ShoppingServiceImpl;
import store.Store;

public class SalesTaxes {
    public static void main(String[] args) {
        System.out.println("---------- SALES TAXES ----------");
        Store store = Store.getINSTANCE();

        ShoppingService shoppingService = new ShoppingServiceImpl();
        shoppingService.shop();
    }
}
