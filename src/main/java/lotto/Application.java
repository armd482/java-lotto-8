package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.strategy.LottoGenerateStrategy;
import lotto.strategy.RandomLottoGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoService lottoService = new LottoService();
        OutputView outputView = new OutputView();
        LottoGenerateStrategy randomStrategy = new RandomLottoGenerateStrategy();

        LottoController lottoController = new LottoController(inputView, outputView, lottoService,  randomStrategy);
        lottoController.run();
    }
}
