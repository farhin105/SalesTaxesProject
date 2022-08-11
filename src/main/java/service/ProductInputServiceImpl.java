package service;

import org.apache.log4j.Logger;
import store.Store;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductInputServiceImpl implements ProductInputService{
    private static Logger logger = Logger.getLogger(ProductInputServiceImpl.class);
    public static final Integer INVALID_INPUT = 9999;
    public static final Integer TOTAL_INPUTS = 9;

    @Override
    public List<Integer> takeProductInput() {
        logger.info("shopping processing, taking input for product");
        Integer itemKey;

        List<Integer> itemKeys = new ArrayList<>();
        do {
            System.out.println("Please input the mentioned product number, or type '0' (zero) to terminate");
            itemKey = takeItemKeyInput(itemKeys);
        }while (itemKey!=0);
        logger.info("shopping ended, input terminated");
        return itemKeys;
    }

    public Integer takeItemKeyInput (List<Integer> itemKeys) {
        Scanner sc= new Scanner(System.in);
        try {
            Integer input = sc.nextInt();
            if (!isInputValid(input)) {
                logger.error("input number out of range of product numbers");
                throw new InputMismatchException();
            }
            if (input!=0) {
                itemKeys.add(input);
            }
            return input;
        }catch (InputMismatchException exception) {
            logger.error("Invalid input");
            System.out.println("Input do not match product number");
            return INVALID_INPUT;
        }
    }
    private boolean isInputValid (Integer itemKey) {
        return itemKey>=0 && itemKey<=TOTAL_INPUTS;
    }
}
