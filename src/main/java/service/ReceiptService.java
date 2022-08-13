package service;

import billing.Receipt;
import product.Product;

import java.util.ArrayList;
import java.util.List;

public class ReceiptService {

    public Receipt getBillingReceipt(List<Product> productList) {
        List<Double> productBillList = getAllProductBill(productList);
        Double salesTaxes = getSalexTaxes(productList);
        Double totalBill = getTotalBill(productList);

        Receipt receipt =
                new Receipt(productList, productBillList, salesTaxes, totalBill);
        return receipt;
    }

    public List<Double> getAllProductBill(List<Product> productList) {
        List<Double> productBillList = new ArrayList<>();
        BillingService billingService = new BillingService();

        for (Product product : productList) {
            productBillList.add(billingService.calculateBillOfProduct(product));
        }
        return productBillList;
    }

    public Double getSalexTaxes(List<Product> productList) {
        Double salesTaxes = 0.0;
        BillingService billingService = new BillingService();

        for (Product product : productList) {
            salesTaxes += billingService.calculateTaxOfProduct(product);
        }
        return salesTaxes;
    }

    public Double getTotalBill(List<Product> productList) {
        Double totalBill = 0.0;
        BillingService billingService = new BillingService();
        for (Product product : productList) {
            totalBill += billingService.calculateBillOfProduct(product);
        }
        return totalBill;
    }

}
