package lotto.model;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class LottoRankTest {
    @Test
    @DisplayName("LottoRank 정상 초기화 테스트")
    void lottoRankInitTest() {
        Map<LottoRank, Integer> lottoRanks = new HashMap<LottoRank, Integer>();

        lottoRanks.put(LottoRank.FIFTH, 2);
        lottoRanks.put(LottoRank.FOURTH, 3);

        LottoRankResult result = new LottoRankResult(lottoRanks);

        assertThat(result.rankCounts())
                .hasSize(2)
                .containsEntry(LottoRank.FIFTH, 2)
                .containsEntry(LottoRank.FOURTH, 3);
    }
}
