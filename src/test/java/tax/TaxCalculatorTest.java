package tax;

import org.junit.jupiter.api.Test;
import product.BookProduct;
import product.FoodProduct;
import product.MedicalProduct;
import product.OtherProduct;
import store.ProductCategory;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {

    @Test
    void calculateTaxShouldReturnExpectedValueForLocalItemTax() {
        BookProduct bookProduct = new BookProduct("book1", 12.8, ProductCategory.BOOK,false);
        MedicalProduct medicalProduct = new MedicalProduct("medical1", 0.32,ProductCategory.MEDICAL,false);
        FoodProduct foodProduct = new FoodProduct("food1", 11.58,ProductCategory.FOOD,false);
        OtherProduct otherProduct = new OtherProduct("other1", 18.99, ProductCategory.OTHER,false);

        var taxCalculator = new TaxCalculator();

        assertEquals(0.0, taxCalculator.calculateTax(bookProduct));
        assertEquals(0.0, taxCalculator.calculateTax(foodProduct));
        assertEquals(0.0, taxCalculator.calculateTax(medicalProduct));
        assertEquals(1.9, taxCalculator.calculateTax(otherProduct));
    }

    @Test
    void calculateTaxShouldReturnExpectedValueForImportedItemTax() {
        BookProduct bookProduct = new BookProduct("book1", 10.0, ProductCategory.BOOK,true);
        FoodProduct foodProduct = new FoodProduct("food1", 11.25,ProductCategory.FOOD,true);
        MedicalProduct medicalProduct = new MedicalProduct("medical1", 14.52,ProductCategory.MEDICAL,true);
        OtherProduct otherProduct = new OtherProduct("other1", 47.5, ProductCategory.OTHER,true);

        var taxCalculator = new TaxCalculator();

        assertEquals(0.5, taxCalculator.calculateTax(bookProduct));
        assertEquals(0.55, taxCalculator.calculateTax(foodProduct));
        assertEquals(0.75, taxCalculator.calculateTax(medicalProduct));
        assertEquals(7.15, taxCalculator.calculateTax(otherProduct));
    }

}