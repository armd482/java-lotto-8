package lotto.model;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BonusNumberTest {
    @Test
    @DisplayName("보너스번호 정상 초기화 테스트")
    void bonusNumberInitTest() {
        BonusNumber bonusNumber = new BonusNumber(1);
        assertThat(bonusNumber.value()).isEqualTo(1);
    }

    @Test
    @DisplayName("1보다 작은 보너스 번호 생성 오류 테스트")
    void bonusNumberLowerValueInitTest() {
        assertThatThrownBy(() -> new BonusNumber(-2)).isInstanceOf(IllegalArgumentException.class).hasMessage(
                ErrorMessage.BONUS_NUMBER_RANGE_ERROR.getMessage());
    }

    @Test
    @DisplayName("45보다  보너스 번호 생성 오류큰테스트")
    void bonusNumberHigherValueInitTest() {
        assertThatThrownBy(() -> new BonusNumber(100)).isInstanceOf(IllegalArgumentException.class).hasMessage(
                ErrorMessage.BONUS_NUMBER_RANGE_ERROR.getMessage());
    }
}
