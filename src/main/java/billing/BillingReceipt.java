package billing;

import product.Product;

import java.util.List;

public class BillingReceipt {
    private List<Product> productList;
    private List<Double> productBillList;
    private Double salesTaxes;
    private Double totalBill;

    public BillingReceipt() {
    }

    public BillingReceipt(List<Product> productList, List<Double> productBillList, Double salesTaxes, Double totalBill) {
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

    public void printReceipt() {
        for (int i = 0; i<productList.size(); i++) {
            System.out.println(productList.get(i).getName()+ " : " + productBillList.get(i));
        }
        System.out.println("Sales Taxes : "+salesTaxes);
        System.out.println("Total Bill : "+ totalBill);
    }
}
