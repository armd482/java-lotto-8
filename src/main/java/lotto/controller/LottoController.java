package lotto.controller;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoRankResult;
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
        List<Lotto> purchasedLotto = lottoService.purchaseLotto(purchasePrice.getLottoAmount());

        purchasedLotto.forEach(System.out::println);

        Lotto winningLotto = getWinningLotto();
        BonusNumber bonusNumber = getBonusNumber(winningLotto);

        LottoRankResult result = lottoService.getCountResult(winningLotto, bonusNumber, purchasedLotto);

        result.rankCounts().forEach((rank, count) -> System.out.println(rank.toString() + count));

        double profitRate = lottoService.calculateProfitRate(result, purchasePrice);

        System.out.println("Profit rate: " + profitRate);
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
