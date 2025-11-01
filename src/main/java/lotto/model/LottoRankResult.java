package lotto.model;

import java.util.EnumMap;
import java.util.Map;
import lotto.constant.LottoRank;

public class LottoRankResult {
    private final Map<LottoRank, Integer> rankCounts;

    public LottoRankResult(Map<LottoRank, Integer> rankCounts) {
        this.rankCounts = rankCounts;
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return Map.copyOf(rankCounts);
    }
}
