package service;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import product.Product;
import repository.StoreRepository;

import java.util.List;

public class ShoppingService {

    private static Logger logger = LoggerFactory.getLogger(ShoppingService.class);

    private ProductInputService productInputService;
    private ProductService productService;
    private StoreRepository storeRepository;

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


    public void showShopScreen() {
        logger.info("showShopScreen() : showing products on screen");

        System.out.println("Input corresponding number to purchase the product:");
        for (int i=1; i<=storeRepository.getProductsInStore().size(); i++ ) {
            System.out.println(i+". ["
                    +storeRepository.getProductsInStore().get(i)+" at "
                    +storeRepository.getProductToPriceMap().get(i)+"]");
        }
    }


    public List<Product> getProducts (List<Integer> inputItems) {
        return productService.getProductsFromInputItems(inputItems);
    }

    public List<Integer> takeInputItems () {
        return   productInputService.takeProductInput();
    }
}
