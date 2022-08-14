package service;

import org.junit.jupiter.api.Test;
import model.product.BookProduct;
import model.product.FoodProduct;
import model.product.MedicalProduct;
import model.product.OtherProduct;
import constant.ProductCategory;

import static org.junit.jupiter.api.Assertions.*;

class ImportedTaxServiceTest {
    private final ImportedTaxService importedTaxService = new ImportedTaxService();

    private final BookProduct bookProduct = new BookProduct("book1", 12.8, ProductCategory.BOOK,true);
    private final MedicalProduct medicalProduct = new MedicalProduct("medical1", 0.32,ProductCategory.MEDICAL,true);
    private final FoodProduct foodProduct = new FoodProduct("food1", 11.58,ProductCategory.FOOD,true);
    private final OtherProduct otherProduct = new OtherProduct("other1", 10.4, ProductCategory.OTHER,true);

    @Test
    void calculateTaxForBookFoodMedical() {

        assertEquals(12.8*0.05, importedTaxService.calculateTax(bookProduct));
        assertEquals(11.58*0.05, importedTaxService.calculateTax(foodProduct));
        assertEquals(0.32*0.05, importedTaxService.calculateTax(medicalProduct));
    }

    @Test
    void calculateTaxForOther() {

        assertEquals(10.4*0.15, importedTaxService.calculateTax(otherProduct));
    }

}