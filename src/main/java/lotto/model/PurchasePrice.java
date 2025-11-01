package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoRule;

public record PurchasePrice(int price) {
    public PurchasePrice {
        validatePrice(price);
    }

    public int getLottoAmount() {
        return price / LottoRule.LOTTO_PRICE;
    }

    private void validatePrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_PRICE_NEGATIVE_ERROR.getMessage());
        }
        if (price % LottoRule.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_PRICE_UNIT_ERROR.getMessage());
        }
    }
}
