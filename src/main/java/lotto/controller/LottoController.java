package lotto.controller;

import lotto.constant.ErrorMessage;
import lotto.model.PurchasePrice;
import lotto.util.Validator;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private final String ERROR_PRIFIX = "[ERROR] ";

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        PurchasePrice purchasePrice = getPurchasePrice();
        System.out.println(purchasePrice);
    }

    private PurchasePrice getPurchasePrice() {
        while(true) {
            try {
                String purchasePriceInput = inputView.getPurchasePrice();
                Validator.validateEmptyInput(purchasePriceInput);

                int price = Integer.parseInt(purchasePriceInput);

                return new PurchasePrice(price);
            } catch(NumberFormatException e) {
                System.out.println(ERROR_PRIFIX + ErrorMessage.PARSE_INTEGER_INPUT.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PRIFIX + e.getMessage());
            }
        }

    }
}
