package service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingServiceTest {
    @Test
    void shopShouldCallShowShopScreen() {
        ShoppingService spyShoppingService = Mockito.spy(ShoppingService.class);

        Mockito.doReturn(null).when(spyShoppingService).takeInputItems();

        spyShoppingService.shop();
        Mockito.verify(spyShoppingService, Mockito.times(1)).showShopScreen();
    }

    @Test
    void shopShouldReturnExpectedList() {
        ShoppingService spyShoppingService = Mockito.spy(ShoppingService.class);

        List<Integer> expectedList = new ArrayList<>(){{
            add(4);
            add(3);
            add(5);
        }};

        Mockito.doReturn(expectedList).when(spyShoppingService).takeInputItems();

        assertIterableEquals(expectedList, spyShoppingService.shop());
    }
}