package lotto.util;

import java.util.List;
import lotto.constant.LottoRank;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class OutputFormatterTest {
    @Test
    @DisplayName("구매 로또 출력 포멧 테스트")
    void formatPurchasedLottoTest() {
        Lotto lotto = new Lotto(List.of(3, 1, 4, 5, 6, 7));
        String formattedLotto = OutputFormatter.formatPurchasedLotto(lotto);
        assertThat(formattedLotto).isEqualTo("[1, 3, 4, 5, 6, 7]");
    }

    @Test
    @DisplayName("1등 로또 결과 출력 포멧 테스트")
    void formatFirstLottoResultTest() {
        String result = OutputFormatter.formatLottoResult(LottoRank.FIRST, 3);
        assertThat(result).isEqualTo("6개 일치 (2,000,000,000원) - 3개");
    }

    @Test
    @DisplayName("2등 로또 결과 출력 포멧 테스트")
    void formatSecondLottoResultTest() {
        String result = OutputFormatter.formatLottoResult(LottoRank.SECOND, 1);
        assertThat(result).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개");
    }

    @Test
    @DisplayName("수익률 포멧 테스트")
    void formatProfitRateTest() {
        String msg = OutputFormatter.formatProfitRate(123.45);
        assertThat(msg).isEqualTo("총 수익률은 123.5%입니다.");
    }
}
