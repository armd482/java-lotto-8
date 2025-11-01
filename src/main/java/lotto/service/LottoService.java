package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoRankResult;
import lotto.model.PurchasePrice;
import lotto.strategy.LottoGenerateStrategy;

public class LottoService {
    private static final int PROFIT_RATE_SCALE = 1;

    public List<Lotto> generateRandomLottos(int amount, LottoGenerateStrategy strategy) {
        List<Lotto> generatedLotto = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            generatedLotto.add(strategy.generateLotto());
        }
        return generatedLotto;
    }

    public LottoRankResult getCountResult(Lotto winningNumber, BonusNumber bonusNumber, List<Lotto> purchasedLotto) {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }

        purchasedLotto.forEach(lotto -> {
            LottoRank rank = LottoRank.getResult(lotto.countMatches(winningNumber), lotto.isContain(bonusNumber.value()));
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        });

        return new LottoRankResult(rankCounts);
    }

    public double calculateProfitRate(LottoRankResult rankResult, PurchasePrice purchasePrice) {
        BigDecimal totalProfit = BigDecimal.valueOf(calculateTotalProfit(rankResult));
        BigDecimal cost = BigDecimal.valueOf(purchasePrice.price());

        BigDecimal profitRate =  totalProfit
                .divide(cost, PROFIT_RATE_SCALE + 3, RoundingMode.DOWN)
                .multiply(BigDecimal.valueOf(100))
                .setScale(PROFIT_RATE_SCALE, RoundingMode.HALF_UP);

        return profitRate.doubleValue();
    }

    private long calculateTotalProfit(LottoRankResult rankResult) {
        return rankResult.rankCounts().entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
