package service;

import model.product.*;
import org.junit.jupiter.api.Test;
import repository.StoreRepository;
import constant.ProductCategory;
import constant.ProductConstants;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ProductServiceTest {

    private final StoreRepository storeRepository = mock(StoreRepository.class);

    private final ProductService productService = new ProductService(storeRepository);

    private final BookProduct bookProduct = new BookProduct(ProductConstants.NAME_ONE_BOOK, ProductConstants.PRICE_ONE_BOOK,
            ProductCategory.BOOK,false);
    private final OtherProduct otherProduct = new OtherProduct(ProductConstants.NAME_ONE_BOTTLE_PERFUME,
            ProductConstants.PRICE_BOTTLE_PERFUME,ProductCategory.OTHER,false);
    private final FoodProduct foodProduct = new FoodProduct(ProductConstants.NAME_ONE_IMPORTED_BOX_CHOCOLATE,
            ProductConstants.PRICE_IMPORTED_BOX_CHOCOLATE,ProductCategory.FOOD,true);
    private final MedicalProduct medicalProduct = new MedicalProduct(ProductConstants.NAME_ONE_PACKET_HEADACHE_PILLS,
            ProductConstants.PRICE_PACKET_HEADACHE_PILLS,ProductCategory.MEDICAL,false);


    @Test
    void getProductsFromInputItemsValidInput() {
        List<Integer> inputList = new ArrayList<>(){{
            add(ProductConstants.KEY_ONE_BOOK);
            add(ProductConstants.KEY_BOTTLE_PERFUME);
            add(ProductConstants.KEY_IMPORTED_BOX_CHOCOLATE);
            add(ProductConstants.KEY_PACKET_HEADACHE_PILLS);
        }};

        List<Product> expectedList = new ArrayList<>() {{
            add(bookProduct);
            add(otherProduct);
            add(foodProduct);
            add(medicalProduct);
        }};

        when(storeRepository.getNameOfItem(anyInt())).thenReturn(ProductConstants.NAME_ONE_BOOK)
                .thenReturn(ProductConstants.NAME_ONE_BOTTLE_PERFUME)
                .thenReturn(ProductConstants.NAME_ONE_IMPORTED_BOX_CHOCOLATE)
                .thenReturn(ProductConstants.NAME_ONE_PACKET_HEADACHE_PILLS);

        when(storeRepository.getPriceOfItem(anyInt())).thenReturn(ProductConstants.PRICE_ONE_BOOK)
                .thenReturn(ProductConstants.PRICE_BOTTLE_PERFUME)
                .thenReturn(ProductConstants.PRICE_IMPORTED_BOX_CHOCOLATE)
                .thenReturn(ProductConstants.PRICE_PACKET_HEADACHE_PILLS);

        when(storeRepository.getCategoryOfItem(anyInt())).thenReturn(ProductCategory.BOOK)
                .thenReturn(ProductCategory.OTHER)
                .thenReturn(ProductCategory.FOOD)
                .thenReturn(ProductCategory.MEDICAL);

        when(storeRepository.isItemImported(anyInt())).thenReturn(false)
                .thenReturn(false)
                .thenReturn(true)
                .thenReturn(false);

        when(storeRepository.getStoreSize()).thenReturn(9);

        List<Product> actualList = productService.getProductsFromInputItems(inputList);

        assertEquals(expectedList.size(), actualList.size());
        assertEquals(expectedList.get(0).getClass(),actualList.get(0).getClass());
        assertEquals(expectedList.get(1).getClass(),actualList.get(1).getClass());
        assertEquals(expectedList.get(2).getClass(),actualList.get(2).getClass());
        assertEquals(expectedList.get(3).getClass(),actualList.get(3).getClass());

        assertEquals(expectedList.get(0).getPrice(),actualList.get(0).getPrice());
        assertEquals(expectedList.get(1).getPrice(),actualList.get(1).getPrice());
        assertEquals(expectedList.get(2).getPrice(),actualList.get(2).getPrice());
        assertEquals(expectedList.get(3).getPrice(),actualList.get(3).getPrice());

        assertEquals(expectedList.get(0).isImported(),actualList.get(0).isImported());
        assertEquals(expectedList.get(1).isImported(),actualList.get(1).isImported());
        assertEquals(expectedList.get(2).isImported(),actualList.get(2).isImported());
        assertEquals(expectedList.get(3).isImported(),actualList.get(3).isImported());

    }

    @Test
    /**
     * when getProductForItemKey() returns a null Product obj,
     * it should ignore it and should not add it in result list.
     */
    void getProductsFromInputItemsShouldIgnoreNullProduct() {
        List<Integer> inputList = new ArrayList<>(){{
            add(ProductConstants.KEY_ONE_BOOK);
            add(999);
            add(ProductConstants.KEY_IMPORTED_BOX_CHOCOLATE);
        }};

        List<Product> expectedList = new ArrayList<>() {{
            add(bookProduct);
            add(foodProduct);
        }};

        when(storeRepository.getNameOfItem(anyInt())).thenReturn(ProductConstants.NAME_ONE_BOOK)
                .thenReturn(ProductConstants.NAME_ONE_IMPORTED_BOX_CHOCOLATE);

        when(storeRepository.getPriceOfItem(anyInt())).thenReturn(ProductConstants.PRICE_ONE_BOOK)
                .thenReturn(ProductConstants.PRICE_IMPORTED_BOX_CHOCOLATE);

        when(storeRepository.getCategoryOfItem(anyInt())).thenReturn(ProductCategory.BOOK)
                .thenReturn(ProductCategory.FOOD);

        when(storeRepository.isItemImported(anyInt())).thenReturn(false)
                .thenReturn(true);

        when(storeRepository.getStoreSize()).thenReturn(9);

        List<Product> actualList = productService.getProductsFromInputItems(inputList);

        assertEquals(expectedList.size(), actualList.size());
        assertNotEquals(inputList, actualList);

        assertEquals(expectedList.get(0).getClass(),actualList.get(0).getClass());
        assertEquals(expectedList.get(1).getClass(),actualList.get(1).getClass());
    }

    @Test
    void getProductsFromInputItemsNullInputList() {
        List<Product> actualList = productService.getProductsFromInputItems(null);
        assertNull(actualList);
    }

    @Test
    void getProductsFromInputItemsEmptyInputList() {
        List<Product> actualList = productService.getProductsFromInputItems(new ArrayList<>());
        assertNotNull(actualList);
        assertEquals(0, actualList.size());
    }
}