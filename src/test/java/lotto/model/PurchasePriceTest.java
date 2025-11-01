package lotto.model;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PurchasePriceTest {
    @Test
    @DisplayName("구입 가격 정상 초기화 테스트")
    void purchasePriceInitTest() {
        PurchasePrice purchasePrice = new PurchasePrice(1000);

        assertThat(purchasePrice.price()).isEqualTo(1000);
    }

    @Test
    @DisplayName("구입 가격 음수 테스트")
    void purchasePriceNegativeInitTest() {
        assertThatThrownBy(() -> new PurchasePrice(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PURCHASE_PRICE_NEGATIVE_ERROR.getMessage());
    }

    @Test
    @DisplayName("구입 가격 1000원 단위 테스트")
    void purchasePriceNonThousandUnitInitTest() {
        assertThatThrownBy(() -> new PurchasePrice(1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PURCHASE_PRICE_UNIT_ERROR.getMessage());
    }
}
