package service;

import org.junit.jupiter.api.Test;
import model.product.BookProduct;
import model.product.FoodProduct;
import model.product.MedicalProduct;
import model.product.OtherProduct;
import constant.ProductCategory;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorServiceTest {
    private final TaxCalculatorService taxCalculatorService = new TaxCalculatorService();

    @Test
    void calculateTaxShouldReturnExpectedValueForLocalItemTax() {

        BookProduct bookProduct = new BookProduct("book1", 12.8, ProductCategory.BOOK,false);
        MedicalProduct medicalProduct = new MedicalProduct("medical1", 0.32,ProductCategory.MEDICAL,false);
        FoodProduct foodProduct = new FoodProduct("food1", 11.58,ProductCategory.FOOD,false);
        OtherProduct otherProduct = new OtherProduct("other1", 18.99, ProductCategory.OTHER,false);


        assertEquals(0.0, taxCalculatorService.calculateTax(bookProduct));
        assertEquals(0.0, taxCalculatorService.calculateTax(foodProduct));
        assertEquals(0.0, taxCalculatorService.calculateTax(medicalProduct));
        assertEquals(1.9, taxCalculatorService.calculateTax(otherProduct));
    }

    @Test
    void calculateTaxShouldReturnExpectedValueForImportedItemTax() {
        BookProduct bookProduct = new BookProduct("book1", 10.0, ProductCategory.BOOK,true);
        FoodProduct foodProduct = new FoodProduct("food1", 11.25,ProductCategory.FOOD,true);
        MedicalProduct medicalProduct = new MedicalProduct("medical1", 14.52,ProductCategory.MEDICAL,true);
        OtherProduct otherProduct = new OtherProduct("other1", 47.5, ProductCategory.OTHER,true);


        assertEquals(0.5, taxCalculatorService.calculateTax(bookProduct));
        assertEquals(0.6, taxCalculatorService.calculateTax(foodProduct));
        assertEquals(0.75, taxCalculatorService.calculateTax(medicalProduct));
        assertEquals(7.15, taxCalculatorService.calculateTax(otherProduct));
    }

}