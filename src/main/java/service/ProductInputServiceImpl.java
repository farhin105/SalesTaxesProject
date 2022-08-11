package service;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductInputServiceImpl implements ProductInputService {
    public static final Integer INVALID_INPUT = 9999;
    public static final Integer TOTAL_INPUTS = 9;
    private static Logger logger = Logger.getLogger(ProductInputServiceImpl.class);

    @Override
    public List<Integer> takeProductInput() {
        logger.info("shopping processing, taking input for product");
        Integer itemKey;

        List<Integer> itemKeys = new ArrayList<>();
        do {
            System.out.println("Please input the mentioned product number, or type '0' (zero) to terminate");
            itemKey = takeItemKeyInput();
            if (itemKey != 0) {
                itemKeys.add(itemKey);
            }
        } while (itemKey != 0);
        logger.info("shopping ended, input terminated");
        return itemKeys;
    }

    public Integer takeItemKeyInput() {
        Integer input = scanInput();
        if (!isInputValid(input)) {
            logger.error("input invalid");
            return INVALID_INPUT;
        }
        return input;
    }

    public Integer scanInput() {
        Scanner sc = new Scanner(System.in);
        try {
            Integer input = sc.nextInt();
            return input;
        } catch (InputMismatchException exception) {
            logger.error("invalid input: InputMismatchException");
            return INVALID_INPUT;
        }
    }

    private boolean isInputValid(Integer itemKey) {
        return itemKey >= 0 && itemKey <= TOTAL_INPUTS;
    }
}
