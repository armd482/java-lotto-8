package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;

public class InputParser {
    private static final String SEPARATOR = ",";

    public static List<Integer> parseWinningNumber(String input) {
        validateEmptyInput(input);
        try {
            return Arrays.stream(input.split(SEPARATOR)).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.PARSE_INTEGER_INPUT.getMessage());
        }
    }

    private static void validateEmptyInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }
}
