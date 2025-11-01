package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;

public class InputView {
    private final String PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String getPurchasePrice() {
        System.out.println(PURCHASE_PRICE_INPUT_MESSAGE);
        return getInput();
    }

    public String getWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        return getInput();
    }

    public String getBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return getInput();
    }

    private String getInput() {
        String input = Console.readLine().trim();

        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
        return input;
    }
}
