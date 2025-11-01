package lotto.util;

import java.util.stream.Collectors;
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
}
