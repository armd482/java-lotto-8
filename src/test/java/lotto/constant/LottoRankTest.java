package lotto.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @Test
    @DisplayName("6개 일치")
    void firstRankTest() {
        assertThat(LottoRank.getResult(6, false)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("5개 + 보너스")
    void secondRankTest() {
        assertThat(LottoRank.getResult(5, true)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("5개")
    void thirdRankTest() {
        assertThat(LottoRank.getResult(5, false)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("4개")
    void fourthRankTest() {
        assertThat(LottoRank.getResult(4, true)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.getResult(4, false)).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("3개")
    void fifthRankTest() {
        assertThat(LottoRank.getResult(3, true)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.getResult(3, false)).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("0~2개")
    void noneRankTest() {
        assertThat(LottoRank.getResult(2, true)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.getResult(1, false)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.getResult(0, false)).isEqualTo(LottoRank.NONE);
    }
}
