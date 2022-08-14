package service;

import model.billing.Receipt;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import model.product.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ReceiptService {

    private final Logger logger = LoggerFactory.getLogger(ReceiptService.class);

    private final BillingService billingService;

    @Inject
    public ReceiptService(BillingService billingService) {
        this.billingService = billingService;
    }

    public Receipt getReceipt(List<Product> productList) {
        List<Double> productBillList = getBillList(productList);
        Double salesTaxes = getSalexTaxes(productList);
        Double totalBill = getTotalBill(productList);

        Receipt receipt =
                new Receipt(productList, productBillList, salesTaxes, totalBill);
        return receipt;
    }

    public void printReceipt(Receipt receipt) {
        for (int i = 0; i<receipt.getProductBillList().size(); i++) {
            System.out.println(receipt.getProductList().get(i).getName()+ " : "
                    + receipt.getProductBillList().get(i));
        }
        System.out.println("Sales Taxes : "+receipt.getSalesTaxes());
        System.out.println("Total Bill : "+ receipt.getTotalBill());
    }

    private List<Double> getBillList(List<Product> productList) {
        List<Double> productBillList = new ArrayList<>();

        for (Product product : productList) {
            productBillList.add(format(billingService.calculateBillOfProduct(product)));
        }
        return productBillList;
    }

    private Double getSalexTaxes(List<Product> productList) {
        Double salesTaxes = 0.0;

        for (Product product : productList) {
            salesTaxes += billingService.calculateTaxOfProduct(product);
        }
        return format(salesTaxes);
    }

    private Double getTotalBill(List<Product> productList) {
        Double totalBill = 0.0;
        for (Product product : productList) {
            totalBill += billingService.calculateBillOfProduct(product);
        }

        return format(totalBill);
    }

    private Double format (Double value) {
        return Double.valueOf(new DecimalFormat("0.00").format(value));
    }
}
