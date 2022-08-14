package service;

import constant.ProductCategory;
import constant.ProductConstants;
import model.product.BookProduct;
import model.product.FoodProduct;
import model.product.OtherProduct;
import model.product.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.StoreRepository;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ShoppingServiceTest {
    private final ProductInputService productInputService = mock(ProductInputService.class);
    private final ProductService productService = mock(ProductService.class);
    private final StoreRepository storeRepository = mock(StoreRepository.class);

    private final ShoppingService shoppingService = new ShoppingService(
            productInputService,
            productService,
            storeRepository
    );

    @Test
    void shopValidInputList() {

        List<Integer> expectedList = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
        when(productInputService.takeProductInput()).thenReturn(expectedList);

        List<Integer> itemList = shoppingService.shop();

        assertEquals(expectedList.size(),itemList.size());
        assertIterableEquals(expectedList, itemList);
    }
    @Test
    void shopInputNull() {

        List<Integer> expectedList = null;
        when(productInputService.takeProductInput()).thenReturn(expectedList);

        List<Integer> itemList = shoppingService.shop();

        assertNull(itemList);
    }
    @Test
    void shopInputEmptyList() {

        List<Integer> expectedList = new ArrayList<>();
        when(productInputService.takeProductInput()).thenReturn(expectedList);

        List<Integer> itemList = shoppingService.shop();

        assertNotNull(itemList);
        assertEquals(0, itemList.size());
    }

    @Test
    void getProductsInputValidList() {
        ProductConstants CONST = new ProductConstants();

        BookProduct bookProduct = new BookProduct(CONST.NAME_ONE_BOOK, CONST.PRICE_ONE_BOOK,
                ProductCategory.BOOK,false);
        OtherProduct otherProduct = new OtherProduct(CONST.NAME_ONE_BOTTLE_PERFUME,
                CONST.PRICE_BOTTLE_PERFUME,ProductCategory.OTHER,false);
        FoodProduct foodProduct = new FoodProduct(CONST.NAME_ONE_IMPORTED_BOX_CHOCOLATE,
                CONST.PRICE_IMPORTED_BOX_CHOCOLATE,ProductCategory.FOOD,true);

        List<Integer> inputList = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
        List<Product> expectedList = new ArrayList<>() {{
            add(bookProduct);
            add(otherProduct);
            add(foodProduct);
        }};
        when(productService.getProductsFromInputItems(inputList))
                .thenReturn(expectedList);

        List<Product> itemList = shoppingService.getProducts(inputList);

        assertEquals(expectedList.size(),itemList.size());
        assertIterableEquals(expectedList, itemList);
    }
    @Test
    void getProductsInputNull() {

        when(productService.getProductsFromInputItems(null))
                .thenReturn(null);

        List<Product> itemList = shoppingService.getProducts(null);

        assertNull(itemList);
    }
    @Test
    void getProductsInputEmptyList() {

        List<Integer> inputList = new ArrayList<>();

        when(productService.getProductsFromInputItems(inputList))
                .thenReturn(new ArrayList<>());

        List<Product> itemList = shoppingService.getProducts(inputList);

        assertNotNull(itemList);
        assertEquals(0, itemList.size());
    }
}