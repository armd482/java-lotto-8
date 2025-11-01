package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.util.OutputFormatter;

public class OutputView {
    private final String PURCHASE_LOTTO_MESSAGE = "%d개를 구매했습니다%n";

    public void printPurchasedLotto(List<Lotto> purchasedLotto) {
        System.out.printf((PURCHASE_LOTTO_MESSAGE), purchasedLotto.size());
        purchasedLotto.forEach((lotto) -> System.out.println(OutputFormatter.formatPurchasedLotto(lotto)));
        System.out.println();
    }
}
