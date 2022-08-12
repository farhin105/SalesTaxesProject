package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import product.Product;
import repository.StoreRepository;
import store.Store;

import java.util.List;

public class ShoppingServiceImpl implements ShoppingService{
    private List<Product> shoppingBasket;

    private static Logger logger = LoggerFactory.getLogger(ShoppingServiceImpl.class);

    @Override
    public void shop() {
        showShopScreen();
        List<Integer> inputItems = takeInputItems();
        //get List
    }

    @Override
    public void showShopScreen() {
        logger.info("showShopScreen() : showing products on screen");

        StoreRepository storeRepository = new StoreRepository();

        System.out.println("Input corresponding number to purchase the product:");
        for (int i=1; i<=storeRepository.getProductsInStore().size(); i++ ) {
            System.out.println(i+". ["
                    +storeRepository.getProductsInStore().get(i)+" at "
                    +storeRepository.getProductToPriceMap().get(i)+"]");
        }
    }

    @Override
    public List<Product> getShoppingBasket() {
        //needs implementation
        return null;
    }

    private List<Integer> takeInputItems () {
        ProductInputService productInputService = new ProductInputServiceImpl();
        return   productInputService.takeProductInput();
    }
}
