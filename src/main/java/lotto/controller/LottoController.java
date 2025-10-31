package lotto.controller;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.model.Lotto;
import lotto.model.PurchasePrice;
import lotto.util.InputParser;
import lotto.util.Validator;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        PurchasePrice purchasePrice = getPurchasePrice();
        Lotto winningLotto = getWinningLotto();

        System.out.println(purchasePrice);
        System.out.println(winningLotto);
    }

    private PurchasePrice getPurchasePrice() {
        while(true) {
            try {
                String purchasePriceInput = inputView.getPurchasePrice();
                Validator.validateEmptyInput(purchasePriceInput);

                int price = Integer.parseInt(purchasePriceInput);

                return new PurchasePrice(price);
            } catch(NumberFormatException e) {
                System.out.println(ErrorMessage.PARSE_INTEGER_INPUT.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getWinningLotto() {
        while(true) {
            try {
                String winningLottoInput = inputView.getWinningNumber();
                Validator.validateEmptyInput(winningLottoInput);

                List<Integer> winningNumbers = InputParser.parseWinningNumber(winningLottoInput);
                return new Lotto(winningNumbers);
            } catch(NumberFormatException e) {
                System.out.println(ErrorMessage.PARSE_INTEGER_INPUT.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
