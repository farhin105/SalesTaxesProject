package tax;

import org.junit.jupiter.api.Test;
import product.BookProduct;
import product.FoodProduct;
import product.MedicalProduct;
import product.OtherProduct;
import store.ProductCategory;

import static org.junit.jupiter.api.Assertions.*;

class ImportedTaxServiceTest {
    private BookProduct bookProduct = new BookProduct("book1", 12.8, ProductCategory.BOOK,true);
    private MedicalProduct medicalProduct = new MedicalProduct("medical1", 0.32,ProductCategory.MEDICAL,true);
    private FoodProduct foodProduct = new FoodProduct("food1", 11.58,ProductCategory.FOOD,true);
    private OtherProduct otherProduct = new OtherProduct("other1", 10.4, ProductCategory.OTHER,true);

    @Test
    void calculateTaxShouldReturnPriceTimesFivePercentForBookFoodMedical() {
        var importedTaxService = new ImportedTaxService();

        assertEquals(12.8*0.05, importedTaxService.calculateTax(bookProduct));
        assertEquals(11.58*0.05, importedTaxService.calculateTax(foodProduct));
        assertEquals(0.32*0.05, importedTaxService.calculateTax(medicalProduct));
    }

    @Test
    void calculateTaxShouldReturnPriceTimesFifteenPercentForOther() {
        var importedTaxService = new ImportedTaxService();

        assertEquals(10.4*0.15, importedTaxService.calculateTax(otherProduct));
    }

}