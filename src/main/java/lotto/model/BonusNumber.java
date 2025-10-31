package lotto.model;

import lotto.constant.ErrorMessage;

public record BonusNumber(int value) {
    public BonusNumber {
        validateBonusNumber(value);
    }

    private void validateBonusNumber(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NEGATIVE_ERROR.getMessage());
        }

        if(value > 45) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE_ERROR.getMessage());
        }
    }
}
