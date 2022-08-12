package service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import product.*;
import store.ProductCategory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {
    private BookProduct bookProduct = new BookProduct("book1", 12.8, ProductCategory.BOOK,false);
    private MedicalProduct medicalProduct = new MedicalProduct("medical1", 0.32,ProductCategory.MEDICAL,false);
    private FoodProduct foodProduct = new FoodProduct("food1", 11.58,ProductCategory.FOOD,true);
    private OtherProduct otherProduct = new OtherProduct("other1", 10.4, ProductCategory.OTHER,false);


    @Test
    void getProductsFromInputItemsShouldReturnExpectedProductList() {
        ProductServiceImpl spyProductService = Mockito.spy(ProductServiceImpl.class);

        List<Integer> dummyInputList = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
            add(4);
        }};

        List<Product> expectedList = new ArrayList<>() {{
            add(bookProduct);
            add(otherProduct);
            add(foodProduct);
            add(medicalProduct);
        }};
        Mockito.doReturn(bookProduct)
                .doReturn(otherProduct)
                .doReturn(foodProduct)
                .doReturn(medicalProduct)
                .when(spyProductService).getProductForItemKey(Mockito.anyInt());

        List<Product> actualList = spyProductService.getProductsFromInputItems(dummyInputList);

        assertEquals(expectedList.size(), actualList.size());
        assertIterableEquals(expectedList,actualList);
    }

    @Test
    /**
     * when getProductForItemKey() returns a null Product obj,
     * it should ignore it and should not add it in result list.
     */
    void getProductsFromInputItemsShouldIgnoreNullProduct() {
        ProductServiceImpl spyProductService = Mockito.spy(ProductServiceImpl.class);

        List<Integer> dummyInputList = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
            add(4);
        }};

        List<Product> expectedList = new ArrayList<>() {{
            add(bookProduct);
            add(otherProduct);
            add(medicalProduct);
        }};
        Mockito.doReturn(bookProduct)
                .doReturn(otherProduct)
                .doReturn(null)
                .doReturn(medicalProduct)
                .when(spyProductService).getProductForItemKey(Mockito.anyInt());

        List<Product> actualList = spyProductService.getProductsFromInputItems(dummyInputList);

        assertEquals(expectedList.size(), actualList.size());
        assertIterableEquals(expectedList,actualList);
        assertNotEquals(dummyInputList.size(), actualList.size());
    }

    @Test
    void getProductsFromInputItemsShouldReturnNullForNullInputList() {
        ProductServiceImpl spyProductService = Mockito.spy(ProductServiceImpl.class);

        List<Product> actualList = spyProductService.getProductsFromInputItems(null);

        assertNull(actualList);
    }

}