package service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.StoreRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
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
    void shopReturnsExpectedList() {

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

}