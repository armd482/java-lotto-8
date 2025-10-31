package lotto.util;

import java.util.function.Supplier;
import lotto.constant.ErrorMessage;

public class InputLoop {
    public static <T> T askUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.PARSE_INTEGER_INPUT.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
