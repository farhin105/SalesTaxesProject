package service;

import model.product.Product;

public interface TaxService {
    Double calculateTax(Product product);
}
