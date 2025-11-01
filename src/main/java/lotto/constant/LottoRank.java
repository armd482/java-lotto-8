package lotto.constant;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;

    LottoRank(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public static LottoRank getResult(int matchCount, boolean bonusMatch) {
        List<LottoRank> matchCountRanks = Arrays.stream(LottoRank.values())
                                                .filter(rank -> rank.matchCount == matchCount)
                                                .toList();

        if (matchCountRanks.size() == 1) {
            return matchCountRanks.getFirst();
        }

        if(matchCountRanks.size() > 1) {
            return matchCountRanks.stream()
                                    .filter(rank -> rank.bonusMatch == bonusMatch)
                                    .findFirst()
                                    .orElse(NONE);
        }

        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

}
