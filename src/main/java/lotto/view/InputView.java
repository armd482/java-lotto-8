package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;
import lotto.constant.InputMessage;

public class InputView {
    public String getPurchasePrice() {
        System.out.println(InputMessage.PURCHASE_PRICE.getMessage());
        return getInput();
    }

    public String getWinningNumber() {
        System.out.println(InputMessage.WINNING_NUMBER.getMessage());
        return getInput();
    }

    public String getBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER.getMessage());
        return getInput();
    }

    private String getInput() {
        String input = Console.readLine().trim();
        System.out.println();

        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
        return input;
    }
}
