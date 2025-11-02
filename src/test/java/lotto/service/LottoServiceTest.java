package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoRankResult;
import lotto.model.PurchasePrice;
import lotto.strategy.LottoGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {
    private final LottoService lottoService = new LottoService();
    @Test
    @DisplayName("로또 생성 테스트")
    void generateLottoTest() {
        int amount = 3;

        LottoGenerateStrategy strategy = () -> new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Lotto> generatedLotto = lottoService.generateRandomLottos(amount, strategy);

        assertThat(generatedLotto).hasSize(amount);
        generatedLotto.forEach(lotto -> assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또 결과 테스트")
    void getCountResultTest() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        List<Lotto> purchasedLotto = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                new Lotto(List.of(1, 2, 8, 9, 10, 11))
        );

        LottoRankResult result = lottoService.getCountResult(winningNumber, bonusNumber, purchasedLotto);

        assertThat(result.rankCounts().get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.rankCounts().get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.rankCounts().get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(result.rankCounts().get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(result.rankCounts().get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(result.rankCounts().get(LottoRank.NONE)).isEqualTo(1);

    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateProfitRateTest() {
        LottoRankResult result = new LottoRankResult(Map.of(
                LottoRank.FIRST, 1,
                LottoRank.SECOND, 0,
                LottoRank.THIRD, 0,
                LottoRank.FOURTH, 4,
                LottoRank.FIFTH, 5,
                LottoRank.NONE, 10
        ));

        PurchasePrice purchasePrice = new PurchasePrice(20000);

        double profitRate = lottoService.calculateProfitRate(result, purchasePrice);
        assertThat(profitRate).isCloseTo(10001125.0, within(0.01));
    }
}
