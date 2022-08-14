package service;

import com.google.inject.Inject;
import model.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import productManagerFactory.*;
import repository.StoreRepository;
import constant.ProductCategory;

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

        logger.info("getProductsFromInputItems(List<Integer> basket) : getting model.billing.product list for input items");
        List<Product> listOfProduct = new ArrayList<>();

        for (Integer inputItem : inputItems) {
            Product product = getProductForItemKey(inputItem);

            logger.debug("getProductsFromInputItems(List<Integer> basket) : got model.billing.product : {}",product);

            if (product!=null) {
                listOfProduct.add(product);
            }
            else {
                logger.error("getProductsFromInputItems(List<Integer> basket) : fetched null model.billing.product : {}", product);
            }
        }
        return listOfProduct;
    }


    private Product getProductForItemKey (Integer itemKey) {
        if (!isInputValid(itemKey)) {
            logger.error("getProductForItemKey (Integer itemKey) : detected invalid itemKey = {} ",itemKey);
            return null;
        }

        ProductCategory category = storeRepository.getCategoryOfItem(itemKey);

        ProductManager productManager = getProductManager(category);

        return productManager.getProduct(storeRepository.getNameOfItem(itemKey),
                storeRepository.getPriceOfItem(itemKey),
                storeRepository.isItemImported(itemKey));
    }

    private ProductManager getProductManager (ProductCategory category) {
        logger.info("getProductManager() : getting expected model.billing.product manager for category : {}",category);
        return switch (category) {
            case BOOK -> new BookProductManager();
            case MEDICAL -> new MedicalProductManager();
            case FOOD -> new FoodProductManager();
            default -> new OtherProductManager();
        };
    }

    private boolean isInputValid (Integer inputItem) {
        logger.info("isInputValid() : checking if the input value, {} is valid or not",inputItem);
        return inputItem!=null && inputItem>0 && inputItem<=storeRepository.getStoreSize();
    }

}
