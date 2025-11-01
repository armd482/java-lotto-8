package lotto.view;

import java.util.Comparator;
import java.util.List;
import lotto.model.LottoRank;
import lotto.model.Lotto;
import lotto.model.LottoRankResult;
import lotto.util.OutputFormatter;

public class OutputView {
    private static final String PURCHASE_LOTTO_MESSAGE = "%d개를 구매했습니다%n";
    private static final String LOTTO_STATIC_HEADER_MESSAGE = "당첨 통계\n---";


    public void printPurchasedLotto(List<Lotto> purchasedLotto) {
        System.out.printf((PURCHASE_LOTTO_MESSAGE), purchasedLotto.size());
        purchasedLotto.forEach((lotto) -> System.out.println(OutputFormatter.formatPurchasedLotto(lotto)));
        System.out.println();
    }

    public void printLottoStatic(LottoRankResult lottoRankResult, double profitRate) {
        System.out.println(LOTTO_STATIC_HEADER_MESSAGE);
        lottoRankResult.rankCounts().keySet().stream()
                .filter(rank -> rank != LottoRank.NONE)
                .sorted(Comparator.comparingInt(LottoRank::getMatchCount).thenComparing(LottoRank::isBonusMatch))
                .forEach(rank -> {
                    System.out.println(OutputFormatter.formatLottoResult(rank, lottoRankResult.rankCounts().get(rank)));
                });
        System.out.println(OutputFormatter.formatProfitRate(profitRate));
    }
}
