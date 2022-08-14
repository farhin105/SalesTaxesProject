package service;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.StoreRepository;;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductInputService {

    private static final Logger logger = LoggerFactory.getLogger(ProductInputService.class);

    public static final Integer INVALID_INPUT = 9999;

    private final StoreRepository storeRepository;

    @Inject
    public ProductInputService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Integer> takeProductInput() {
        logger.info("takeProductInput() : shopping processing, taking input for model.billing.product");
        Integer itemKey;

        List<Integer> itemKeys = new ArrayList<>();
        do {
            System.out.println("Please input the mentioned model.billing.product number, or type '0' (zero) to terminate");
            itemKey = takeItemKeyInput();
            if (isInputValid(itemKey)) {
                itemKeys.add(itemKey);
            }
        } while (itemKey != 0);
        logger.info("takeProductInput() : shopping ended, input terminated");
        return itemKeys;
    }

    private Integer takeItemKeyInput() {
        Integer input = scanInput();
        if (!isInputInRange(input)) {
            logger.error("takeItemKeyInput() : input invalid");
            System.out.println("Invalid input.");
            return INVALID_INPUT;
        }
        return input;
    }

    private Integer scanInput() {
        Scanner sc = new Scanner(System.in);
        try {
            Integer input = sc.nextInt();
            return input;
        } catch (InputMismatchException exception) {
            logger.error("takeItemKeyInput() : invalid input: InputMismatchException");
            return INVALID_INPUT;
        }
    }

    private Integer getStoreSize() {
        logger.info("getTotalInputs() : fetching model.store size");
        return storeRepository.getStoreSize();
    }

    private boolean isInputValid(Integer itemKey) {
        return itemKey > 0 && itemKey <= getStoreSize();
    }

    private boolean isInputInRange(Integer itemKey) {
        return itemKey >= 0 && itemKey <= getStoreSize();
    }
}
