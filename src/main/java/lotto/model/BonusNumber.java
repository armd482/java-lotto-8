package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoRule;

public record BonusNumber(int value) {
    public BonusNumber {
        validateBonusNumber(value);
    }

    private void validateBonusNumber(int value) {
        if (value < LottoRule.MIN_LOTTO_NUMBER || value > LottoRule.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE_ERROR.getMessage());
        }
    }
}
