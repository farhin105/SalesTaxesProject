import Store.Store;

public class SalesTaxes {
    public static void main(String[] args) {
        System.out.println("---------- SALES TAXES ----------");
        Store store = Store.getINSTANCE();
        System.out.println(store.getProductsInStore());
        System.out.println(store.getProductToPriceMap());
        System.out.println(store.getProductToCategoryMap());
    }
}
