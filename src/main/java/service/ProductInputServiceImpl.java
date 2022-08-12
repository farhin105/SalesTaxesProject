package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductInputServiceImpl implements ProductInputService {
    public static final Integer INVALID_INPUT = 9999;
    public static final Integer TOTAL_INPUTS = 9;
    private static Logger logger = LoggerFactory.getLogger(ProductInputServiceImpl.class);

    @Override
    public List<Integer> takeProductInput() {
        logger.info("takeProductInput() : shopping processing, taking input for product");
        Integer itemKey;

        List<Integer> itemKeys = new ArrayList<>();
        do {
            System.out.println("Please input the mentioned product number, or type '0' (zero) to terminate");
            itemKey = takeItemKeyInput();
            if (isInputValid(itemKey)) {
                itemKeys.add(itemKey);
            }
        } while (itemKey != 0);
        logger.info("takeProductInput() : shopping ended, input terminated");
        return itemKeys;
    }

    public Integer takeItemKeyInput() {
        Integer input = scanInput();
        if (!isInputInRange(input)) {
            logger.error("takeItemKeyInput() : input invalid");
            System.out.println("Invalid input.");
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
            logger.error("takeItemKeyInput() : invalid input: InputMismatchException");
            return INVALID_INPUT;
        }
    }

    private boolean isInputValid(Integer itemKey) {
        return itemKey > 0 && itemKey <= TOTAL_INPUTS;
    }

    private boolean isInputInRange(Integer itemKey) {
        return itemKey >= 0 && itemKey <= TOTAL_INPUTS;
    }
}
