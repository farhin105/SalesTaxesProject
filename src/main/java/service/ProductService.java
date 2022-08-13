package service;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import product.*;
import product_manager.*;
import repository.StoreRepository;
import store.ProductCategory;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final StoreRepository storeRepository;

    @Inject
    public ProductService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }


    public List<Product> getProductsFromInputItems(List<Integer> inputItems) {
        if (inputItems==null ) {
            logger.debug("getProductsFromInputItems(List<Integer> basket) : input list is null");
            return null;
        }

        logger.info("getProductsFromInputItems(List<Integer> basket) : getting product list for input items");
        List<Product> listOfProduct = new ArrayList<>();

        for (Integer inputItem : inputItems) {
            Product product = getProductForItemKey(inputItem);

            logger.debug("getProductsFromInputItems(List<Integer> basket) : got product : {}",product);

            if (product!=null) {
                listOfProduct.add(product);
            }
            else {
                logger.error("getProductsFromInputItems(List<Integer> basket) : fetched null product : {}", product);
            }
        }
        return listOfProduct;
    }


    public Product getProductForItemKey (Integer itemKey) {
        if (!isInputValid(itemKey)) {
            logger.error("getProductForItemKey (Integer itemKey) : detected invalid itemKey = {} ",itemKey);
            return null;
        }

        boolean isImported = isProductImported(itemKey);

        ProductCategory category = storeRepository.getProductToCategoryMap().get(itemKey);

        ProductManager productManager = getProductManager(category);

        return productManager.getProduct(storeRepository.getProductsInStore().get(itemKey), storeRepository.getProductToPriceMap().get(itemKey), isImported);
    }

    private ProductManager getProductManager (ProductCategory category) {

        return switch (category) {
            case BOOK -> new BookProductManager();
            case MEDICAL -> new MedicalProductManager();
            case FOOD -> new FoodProductManager();
            default -> new OtherProductManager();
        };
    }

    private boolean isInputValid (Integer inputItem) {
        return inputItem!=null && inputItem>0 && inputItem<=storeRepository.getStoreSize();
    }

    private boolean isProductImported (Integer inputItem) {
        // dummy implementation. need to implement
        return inputItem==4 || inputItem==5 || inputItem==6 || inputItem==9;
    }
}
