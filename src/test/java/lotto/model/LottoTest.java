package lotto.model;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @Test
    @DisplayName("로또 정상 객체 생성")
    void lottoInitTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또 번호를 6개 미만으로 입력한 경우")
    void lottoBelowSizeInitTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_COUNT_ERROR.getMessage());
    }

    @Test
    @DisplayName("로또 번호를 6개 초과해서 입력한 경우")
    void lottoOverSizeInitTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_COUNT_ERROR.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 포함된 경우")
    @Test
    void lottoDuplicateInitTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
    }

    @Test
    @DisplayName("로또 번호에 범위가 벗어난 숫자가 포함된 경우")
    void lottoOutOfRangeInitTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 52, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
    }

    @Test
    @DisplayName("로또 숫자 포함 메소드 테스트")
    void isContainTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.isContain(1)).isTrue();
        assertThat(lotto.isContain(7)).isFalse();
    }

    @Test
    @DisplayName("매칭 개수 메소드 테스트")
    void countMatchesTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        int matches = lotto.countMatches(lotto2);
        assertThat(matches).isEqualTo(3);
    }
}
