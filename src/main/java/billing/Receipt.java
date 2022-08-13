package billing;

import product.Product;

import java.util.List;

public class Receipt {
    private final List<Product> productList;
    private final List<Double> productBillList;
    private final Double salesTaxes;
    private final Double totalBill;

    public Receipt(List<Product> productList, List<Double> productBillList, Double salesTaxes, Double totalBill) {
        this.productList = productList;
        this.productBillList = productBillList;
        this.salesTaxes = salesTaxes;
        this.totalBill = totalBill;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public List<Double> getProductBillList() {
        return productBillList;
    }

    public Double getSalesTaxes() {
        return salesTaxes;
    }

    public Double getTotalBill() {
        return totalBill;
    }

}
