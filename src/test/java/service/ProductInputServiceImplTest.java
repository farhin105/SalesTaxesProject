package service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class ProductInputServiceImplTest {
    @Test
    void takeItemKeyInputShouldReturnExpectedValueForInputBetweenZeroToNine(){
        ProductInputServiceImpl spyProductInputService = Mockito.spy(ProductInputServiceImpl.class);

        Mockito.doReturn(0).doReturn(8).doReturn(9).when(spyProductInputService).scanInput();

        assertEquals(0,spyProductInputService.takeItemKeyInput());
        assertEquals(8,spyProductInputService.takeItemKeyInput());
        assertEquals(9,spyProductInputService.takeItemKeyInput());
    }

    @Test
    void takeItemKeyInputShouldReturnInvalidWhenInputIsNotInRange(){
        ProductInputServiceImpl spyProductInputService = Mockito.spy(ProductInputServiceImpl.class);
        Integer invalid_input = 9999;

        Mockito.doReturn(12).when(spyProductInputService).scanInput();

        assertEquals(invalid_input,spyProductInputService.takeItemKeyInput());
    }

}