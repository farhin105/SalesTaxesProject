package tax;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import product.BookProduct;
import product.FoodProduct;
import product.MedicalProduct;
import product.OtherProduct;
import store.ProductCategory;

import static org.junit.jupiter.api.Assertions.*;

class LocalTaxServiceTest {
    private BookProduct bookProduct = new BookProduct("book1", 12.8, ProductCategory.BOOK,false);
    private MedicalProduct medicalProduct = new MedicalProduct("medical1", 0.32,ProductCategory.MEDICAL,false);
    private FoodProduct foodProduct = new FoodProduct("food1", 11.58,ProductCategory.FOOD,false);
    private OtherProduct otherProduct = new OtherProduct("other1", 10.4, ProductCategory.OTHER,false);

    @Test
    void calculateTaxShouldReturnZeroForBookFoodMedical() {
        var localTaxService = new LocalTaxService();

        assertEquals(0.0, localTaxService.calculateTax(bookProduct));
        assertEquals(0.0, localTaxService.calculateTax(foodProduct));
        assertEquals(0.0, localTaxService.calculateTax(medicalProduct));
    }

    @Test
    void calculateTaxShouldReturnPriceTimesTenPercentForOther() {
        var localTaxService = new LocalTaxService();

        assertEquals(10.4*0.10, localTaxService.calculateTax(otherProduct));
    }
}