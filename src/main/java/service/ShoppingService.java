package service;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import model.product.Product;
import repository.StoreRepository;

import java.util.List;

public class ShoppingService {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingService.class);

    private final ProductInputService productInputService;
    private final ProductService productService;
    private final StoreRepository storeRepository;

    @Inject
    public ShoppingService(ProductInputService productInputService,
                           ProductService productService, StoreRepository storeRepository) {
        this.productInputService = productInputService;
        this.productService = productService;
        this.storeRepository = storeRepository;
    }

    public List<Integer> shop() {
        showShopScreen();
        List<Integer> inputItems = takeInputItems();
        return inputItems;
    }


    private void showShopScreen() {
        logger.info("showShopScreen() : showing products on screen");

        System.out.println("Input corresponding number to purchase the model.billing.product:");
        for (int i=1; i<=storeRepository.getProductsInStore().size(); i++ ) {
            System.out.println(i+". ["
                    +storeRepository.getProductsInStore().get(i)+" at "
                    +storeRepository.getProductToPriceMap().get(i)+"]");
        }
    }


    public List<Product> getProducts (List<Integer> inputItems) {
        logger.info("getProducts (List<Integer> inputItems) : getting productList for the input items");
        return productService.getProductsFromInputItems(inputItems);
    }

    private List<Integer> takeInputItems () {
        logger.info("takeInputItems() : calling productInputService.takeProductInput() to take input ");
        return   productInputService.takeProductInput();
    }
}
