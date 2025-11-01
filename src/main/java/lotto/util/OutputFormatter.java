package lotto.util;

import java.util.stream.Collectors;
import lotto.constant.LottoRank;
import lotto.model.Lotto;

public class OutputFormatter {
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String LOTTO_NUMBER_PREFIX = "[";
    private static final String LOTTO_NUMBER_SUFFIX = "]";
    private static final String LOTTO_BONUS_MESSAGE = ", 보너스 볼 일치";

    public static String formatPurchasedLotto(Lotto purchasedLotto) {
        return purchasedLotto.getNumbers().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER, LOTTO_NUMBER_PREFIX, LOTTO_NUMBER_SUFFIX));
    }

    public static String formatLottoResult(LottoRank rank, int count) {
        StringBuilder rankResult = new StringBuilder();

        rankResult.append(String.format("%,d개 일치",rank.getMatchCount()));

        if (rank.isBonusMatch()) {
            rankResult.append(LOTTO_BONUS_MESSAGE);
        }

        rankResult.append(String.format(" (%,d원) - %,d개", rank.getPrize(), count));

        return rankResult.toString();
    }

    public static String formatProfitRate(double profitRate) {
        return String.format("총 수익률은 %,.1f%%입니다.",  profitRate);
    }
}
