package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import product.*;
import repository.StoreRepository;
import store.ProductCategory;
import store.Store;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
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

    @Override
    public Product getProductForItemKey (Integer itemKey) {
        if (!isInputValid(itemKey)) {
            logger.error("getProductForItemKey (Integer itemKey) : detected invalid itemKey = {} ",itemKey);
            return null;
        }

        Store store = Store.getINSTANCE();
        boolean isImported = isProductImported(itemKey);

        if (store.getProductToCategoryMap().get(itemKey) == ProductCategory.BOOK) {
            return new BookProduct(store.getProductsInStore().get(itemKey), store.getProductToPriceMap().get(itemKey),ProductCategory.BOOK, isImported);
        }
        else if (store.getProductToCategoryMap().get(itemKey) == ProductCategory.MEDICAL) {
            return new MedicalProduct(store.getProductsInStore().get(itemKey), store.getProductToPriceMap().get(itemKey),ProductCategory.BOOK, isImported);
        }
        else if (store.getProductToCategoryMap().get(itemKey) == ProductCategory.FOOD) {
            return new FoodProduct(store.getProductsInStore().get(itemKey), store.getProductToPriceMap().get(itemKey),ProductCategory.BOOK, isImported);
        }
        else {
            return new OtherProduct(store.getProductsInStore().get(itemKey), store.getProductToPriceMap().get(itemKey),ProductCategory.BOOK, isImported);
        }
    }

    private boolean isInputValid (Integer inputItem) {
        StoreRepository storeRepository = new StoreRepository();
        return inputItem!=null && inputItem>0 && inputItem<=storeRepository.getStoreSize();
    }

    private boolean isProductImported (Integer inputItem) {
        // dummy implementation. need to implement
        return inputItem==4;
    }
}
