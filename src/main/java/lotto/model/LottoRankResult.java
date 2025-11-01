package lotto.model;

import java.util.Map;
import lotto.constant.LottoRank;

public record LottoRankResult(Map<LottoRank, Integer> rankCounts) {
    public LottoRankResult(Map<LottoRank, Integer> rankCounts) {
        this.rankCounts = Map.copyOf(rankCounts);
    }
}
