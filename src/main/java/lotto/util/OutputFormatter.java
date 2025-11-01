package lotto.util;

import java.util.stream.Collectors;
import lotto.constant.OutputTemplate;
import lotto.model.LottoRank;
import lotto.model.Lotto;

public class OutputFormatter {
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String LOTTO_NUMBER_PREFIX = "[";
    private static final String LOTTO_NUMBER_SUFFIX = "]";


    public static String formatPurchasedLotto(Lotto purchasedLotto) {
        return purchasedLotto.getNumbers().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER, LOTTO_NUMBER_PREFIX, LOTTO_NUMBER_SUFFIX));
    }

    public static String formatLottoResult(LottoRank rank, int count) {
        StringBuilder rankResult = new StringBuilder();

        rankResult.append(OutputTemplate.MATCH.format(rank.getMatchCount()));

        if (rank.isBonusMatch()) {
            rankResult.append(OutputTemplate.BONUS.format());
        }

        rankResult.append(OutputTemplate.PRIZE.format(rank.getPrize(), count));

        return rankResult.toString();
    }

    public static String formatProfitRate(double profitRate) {
        return OutputTemplate.PROFIT.format(profitRate);
    }
}
