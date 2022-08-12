package service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import product.*;
import store.ProductCategory;
import store.ProductConstants;

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

    @Test
    void getProductForItemKeyShouldReturnProductOfExpectedClass() {
        ProductConstants CONST = new ProductConstants();
        ProductServiceImpl productService = new ProductServiceImpl();

        assertEquals(BookProduct.class, productService.getProductForItemKey(CONST.KEY_ONE_BOOK).getClass());
        assertEquals(FoodProduct.class, productService.getProductForItemKey(CONST.KEY_BOX_IMPORTED_CHOCOLATE).getClass());
        assertEquals(MedicalProduct.class, productService.getProductForItemKey(CONST.KEY_PACKET_HEADACHE_PILLS).getClass());
        assertEquals(OtherProduct.class, productService.getProductForItemKey(CONST.KEY_BOTTLE_PERFUME).getClass());
    }

    @Test
    void getProductForItemKeyShouldReturnProductWithExpectedImportedField() {
        ProductConstants CONST = new ProductConstants();
        ProductServiceImpl productService = new ProductServiceImpl();

        assertEquals(false, productService.getProductForItemKey(CONST.KEY_ONE_BOOK).isImported());
        assertEquals(true, productService.getProductForItemKey(CONST.KEY_BOX_IMPORTED_CHOCOLATE).isImported());
        assertEquals(false, productService.getProductForItemKey(CONST.KEY_PACKET_HEADACHE_PILLS).isImported());
        assertEquals(false, productService.getProductForItemKey(CONST.KEY_BOTTLE_PERFUME).isImported());
    }

    @Test
    void getProductForItemKeyShouldReturnNullForInvalidInput() {
        ProductServiceImpl productService = new ProductServiceImpl();

        assertEquals(null, productService.getProductForItemKey(99));
        assertEquals(null, productService.getProductForItemKey(0));
        assertEquals(null, productService.getProductForItemKey(9999));
    }

}