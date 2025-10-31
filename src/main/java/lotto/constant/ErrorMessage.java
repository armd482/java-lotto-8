package lotto.constant;

public enum ErrorMessage {
    EMPTY_INPUT("빈 값을 입력할 수 없습니다."),
    PARSE_INTEGER_INPUT("정수 숫자만 입력할 수 있습니다."),
    PURCHASE_PRICE_NEGATIVE_ERROR("금액은 0보다 커야 합니다."),
    PURCHASE_PRICE_UNIT_ERROR("금액은 1000원 단위여야 합니다."),

    LOTTO_NUMBER_COUNT_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1이상 45이하로 구성되어야 합니다"),
    LOTTO_NUMBER_DUPLICATE_ERROR("로또 번호는 중복되면 안됩니다.");

    private final String message;
    public final String ERROR_PREFIX = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }

}
