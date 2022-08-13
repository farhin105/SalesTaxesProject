package service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductInputServiceTest {
    @Test
    void takeItemKeyInputShouldReturnExpectedValueForInputBetweenZeroToNine(){
        ProductInputService spyProductInputService = Mockito.spy(ProductInputService.class);

        Mockito.doReturn(0).doReturn(8).doReturn(9).when(spyProductInputService).scanInput();

        assertEquals(0,spyProductInputService.takeItemKeyInput());
        assertEquals(8,spyProductInputService.takeItemKeyInput());
        assertEquals(9,spyProductInputService.takeItemKeyInput());
    }

    @Test
    void takeItemKeyInputShouldReturnInvalidWhenInputIsNotInRange(){
        ProductInputService spyProductInputService = Mockito.spy(ProductInputService.class);
        Integer invalidConst = 9999;

        Mockito.doReturn(12).when(spyProductInputService).scanInput();

        assertEquals(invalidConst,spyProductInputService.takeItemKeyInput());
    }

    @Test
    void takeItemKeyInputShouldReturnInvalidWhenInputInvalidConst(){
        ProductInputService spyProductInputService = Mockito.spy(ProductInputService.class);
        Integer invalidConst = 9999;

        Mockito.doReturn(invalidConst).when(spyProductInputService).scanInput();

        assertEquals(invalidConst,spyProductInputService.takeItemKeyInput());
    }

    @Test
    void takeProductInputShouldReturnExpectedList (){
        ProductInputService spyProductInputService = Mockito.spy(ProductInputService.class);
        Integer invalidConst = 9999;

        Mockito.doReturn(7)
                .doReturn(2)
                .doReturn(invalidConst)
                .doReturn(0).when(spyProductInputService).takeItemKeyInput();

        List<Integer> actualList = spyProductInputService.takeProductInput();

        assertEquals(2,actualList.size());
        assertEquals(7,actualList.get(0));
        assertEquals(2,actualList.get(1));
    }

    @Test
    void takeProductInputShouldNotAddInvalidConst (){
        ProductInputService spyProductInputService = Mockito.spy(ProductInputService.class);
        Integer invalidConst = 9999;

        Mockito.doReturn(invalidConst)
                .doReturn(0).when(spyProductInputService).takeItemKeyInput();

        List<Integer> actualList = spyProductInputService.takeProductInput();

        assertEquals(0,actualList.size());
    }
}