package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;

public class InputParser {
    private static final String SEPARATOR = ",";

    public static List<Integer> parseWinningNumber(String input) {
        try {
            return Arrays.stream(input.split(SEPARATOR)).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.PARSE_INTEGER_INPUT.getMessage());
        }
    }
}
