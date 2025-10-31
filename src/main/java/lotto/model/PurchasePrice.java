package lotto.model;

import lotto.constant.ErrorMessage;

public record PurchasePrice(int price) {
    public  PurchasePrice(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_PRICE_NEGATIVE_ERROR.getMessage());
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_PRICE_UNIT_ERROR.getMessage());
        }
    }
}
