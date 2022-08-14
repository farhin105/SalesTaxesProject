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
        if (productList==null || productList.size()==0) {
            logger.warn("getReceipt(List<Product> productList) : " +
                    "returning null, as cart is empty/null, inputList of product = {}",productList);
            return null;
        }
        logger.info("getReceipt(List<Product> productList) : preparing bill ");
        List<Double> productBillList = getBillList(productList);
        Double salesTaxes = getSalesTaxes(productList);
        Double totalBill = getTotalBill(productList);

        Receipt receipt =
                new Receipt(productList, productBillList, salesTaxes, totalBill);

        logger.info("getReceipt(List<Product> productList) : returning receipt");
        logger.debug("getReceipt(List<Product> productList) : receipt = {}",receipt);
        return receipt;
    }

    public void printReceipt(Receipt receipt) {
        if (receipt == null) {
            System.out.println("Shopping cart is empty");
            return;
        }
        for (int i = 0; i<receipt.getProductBillList().size(); i++) {
            System.out.println(receipt.getProductList().get(i).getName()+ " : "
                    + receipt.getProductBillList().get(i));
        }
        System.out.println("Sales Taxes : "+receipt.getSalesTaxes());
        System.out.println("Total Bill : "+ receipt.getTotalBill());
    }

    private List<Double> getBillList(List<Product> productList) {
        logger.info("getBillList(List<Product> productList) : getting list of individual item's bill");
        List<Double> productBillList = new ArrayList<>();

        for (Product product : productList) {
            productBillList.add(format(billingService.calculateBillOfProduct(product)));
        }
        logger.info("getBillList(List<Product> productList) : returning list of individual item's bill");
        logger.debug("getBillList(List<Product> productList) : list = {}", productBillList);
        return productBillList;
    }

    private Double getSalesTaxes(List<Product> productList) {
        logger.info("getSalesTaxes(List<Product> productList) : getting sales taxes");
        Double salesTaxes = 0.0;

        for (Product product : productList) {
            salesTaxes += billingService.calculateTaxOfProduct(product);
        }
        logger.info("getSalesTaxes(List<Product> productList) : returning sales taxes");
        logger.debug("getSalesTaxes(List<Product> productList) : sales taxes = {}", format(salesTaxes));
        return format(salesTaxes);
    }

    private Double getTotalBill(List<Product> productList) {
        logger.info("getTotalBill(List<Product> productList) : getting total bill");
        Double totalBill = 0.0;
        for (Product product : productList) {
            totalBill += billingService.calculateBillOfProduct(product);
        }
        logger.info("getTotalBill(List<Product> productList) : returning total bill");
        logger.debug("getTotalBill(List<Product> productList) : total bill = {}", format(totalBill));
        return format(totalBill);
    }

    private Double format (Double value) {
        return Double.valueOf(new DecimalFormat("0.00").format(value));
    }
}
