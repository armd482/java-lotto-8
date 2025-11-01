package lotto.controller;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PurchasePrice;
import lotto.service.LottoService;
import lotto.util.InputLoop;
import lotto.util.InputParser;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, LottoService lottoService) {
        this.inputView = inputView;
        this.lottoService =  lottoService;
    }

    public void run() {
        PurchasePrice purchasePrice = getPurchasePrice();
        Lotto winningLotto = getWinningLotto();
        BonusNumber bonusNumber = getBonusNumber(winningLotto);

        lottoService.purchaseLotto(purchasePrice.getLottoAmount()).forEach(System.out::println);

        System.out.println(purchasePrice);
        System.out.println(winningLotto);
        System.out.println(bonusNumber);
    }

    private PurchasePrice getPurchasePrice() {
        return InputLoop.askUntilValid(() -> {
            String purchasePriceInput = inputView.getPurchasePrice();

            int purchasePrice = Integer.parseInt(purchasePriceInput);
            return new PurchasePrice(purchasePrice);
        });
    }

    private Lotto getWinningLotto() {
        return InputLoop.askUntilValid(() -> {
            String winningLottoInput = inputView.getWinningNumber();

            List<Integer> winningNumbers = InputParser.parseWinningNumber(winningLottoInput);
            return new Lotto(winningNumbers);
        });
    }

    private BonusNumber getBonusNumber(Lotto winningLotto) {
        return InputLoop.askUntilValid(() -> {
            String bonusNumberInput = inputView.getBonusNumber();

            int bonusNumber = Integer.parseInt(bonusNumberInput);

            if(winningLotto.isContain(bonusNumber)) {
                throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
            }

            return new BonusNumber(bonusNumber);
        });
    }
}
