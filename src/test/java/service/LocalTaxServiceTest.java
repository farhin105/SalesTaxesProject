package service;

import org.junit.jupiter.api.Test;
import model.product.BookProduct;
import model.product.FoodProduct;
import model.product.MedicalProduct;
import model.product.OtherProduct;
import constant.ProductCategory;

import static org.junit.jupiter.api.Assertions.*;

class LocalTaxServiceTest {

    private final LocalTaxService localTaxService = new LocalTaxService();

    private final BookProduct bookProduct = new BookProduct("book1", 12.8, ProductCategory.BOOK,false);
    private final MedicalProduct medicalProduct = new MedicalProduct("medical1", 0.32,ProductCategory.MEDICAL,false);
    private final FoodProduct foodProduct = new FoodProduct("food1", 11.58,ProductCategory.FOOD,false);
    private final OtherProduct otherProduct = new OtherProduct("other1", 10.4, ProductCategory.OTHER,false);

    @Test
    void calculateTaxForBookFoodMedical() {

        assertEquals(0.0, localTaxService.calculateTax(bookProduct));
        assertEquals(0.0, localTaxService.calculateTax(foodProduct));
        assertEquals(0.0, localTaxService.calculateTax(medicalProduct));
    }

    @Test
    void calculateTaxForOther() {

        assertEquals(10.4*0.10, localTaxService.calculateTax(otherProduct));
    }
}