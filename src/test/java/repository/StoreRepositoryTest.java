package repository;

import constant.ProductConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreRepositoryTest {

    private final StoreRepository storeRepository = new StoreRepository();

    @Test
    void getNameOfItemValidInput () {
        assertEquals(ProductConstants.NAME_ONE_BOOK, storeRepository.getNameOfItem(1));
        assertEquals(ProductConstants.NAME_ONE_IMPORTED_BOX_CHOCOLATE, storeRepository.getNameOfItem(4));
        assertEquals(ProductConstants.NAME_ONE_BOX_IMPORTED_CHOCOLATE, storeRepository.getNameOfItem(9));
    }

    @Test
    void getNameOfItemInvalidInput () {
        assertNull( storeRepository.getNameOfItem(9999));
        assertNull(storeRepository.getNameOfItem(10));
        assertNull(storeRepository.getNameOfItem(19));
    }

    @Test
    void getPriceOfItemValidInput () {
        assertEquals(ProductConstants.PRICE_ONE_BOOK, storeRepository.getPriceOfItem(1));
        assertEquals(ProductConstants.PRICE_IMPORTED_BOX_CHOCOLATE, storeRepository.getPriceOfItem(4));
        assertEquals(ProductConstants.PRICE_BOX_IMPORTED_CHOCOLATE, storeRepository.getPriceOfItem(9));
    }

    @Test
    void getPriceOfItemInvalidInput () {
        assertNull( storeRepository.getPriceOfItem(9999));
        assertNull(storeRepository.getPriceOfItem(10));
        assertNull(storeRepository.getPriceOfItem(19));
    }

    @Test
    void getCategoryOfItemValidInput () {
        assertEquals(ProductConstants.CATEGORY_ONE_BOOK, storeRepository.getCategoryOfItem(1));
        assertEquals(ProductConstants.CATEGORY_IMPORTED_BOX_CHOCOLATE, storeRepository.getCategoryOfItem(4));
        assertEquals(ProductConstants.CATEGORY_BOX_IMPORTED_CHOCOLATE, storeRepository.getCategoryOfItem(9));
    }

    @Test
    void getCategoryOfItemInvalidInput () {
        assertNull( storeRepository.getCategoryOfItem(9999));
        assertNull(storeRepository.getCategoryOfItem(10));
        assertNull(storeRepository.getCategoryOfItem(19));
    }

    @Test
    void isItemValidTest () {
        assertTrue(storeRepository.isItemValid(1));
        assertTrue(storeRepository.isItemValid(5));
        assertTrue(storeRepository.isItemValid(9));

        assertFalse(storeRepository.isItemValid(9999));
        assertFalse(storeRepository.isItemValid(25));
        assertFalse(storeRepository.isItemValid(10));
    }

    @Test
    void isItemImportedTest () {
        assertTrue(storeRepository.isItemImported(4));
        assertTrue(storeRepository.isItemImported(5));
        assertTrue(storeRepository.isItemImported(6));
        assertTrue(storeRepository.isItemImported(9));

        assertFalse(storeRepository.isItemImported(9999));
        assertFalse(storeRepository.isItemImported(1));
        assertFalse(storeRepository.isItemImported(8));
    }

}