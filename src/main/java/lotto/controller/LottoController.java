package lotto.controller;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoRankResult;
import lotto.model.PurchasePrice;
import lotto.service.LottoService;
import lotto.strategy.LottoGenerateStrategy;
import lotto.util.InputLoop;
import lotto.util.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final LottoGenerateStrategy lottoGenerateStrategy;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService,  LottoGenerateStrategy lottoGenerateStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService =  lottoService;
        this.lottoGenerateStrategy = lottoGenerateStrategy;
    }

    public void run() {
        PurchasePrice purchasePrice = getPurchasePrice();
        List<Lotto> purchasedLotto = lottoService.generateRandomLottos(purchasePrice.getLottoAmount(), lottoGenerateStrategy);

        outputView.printPurchasedLotto(purchasedLotto);

        Lotto winningLotto = getWinningLotto();
        BonusNumber bonusNumber = getBonusNumber(winningLotto);

        LottoRankResult result = lottoService.getCountResult(winningLotto, bonusNumber, purchasedLotto);
        double profitRate = lottoService.calculateProfitRate(result, purchasePrice);

        outputView.printLottoStatic(result, profitRate);
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
