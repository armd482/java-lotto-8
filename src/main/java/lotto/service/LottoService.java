package lotto.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.LottoRankResult;

public class LottoService {
    public List<Lotto> purchaseLotto(int amount) {
        List<Lotto> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchasedLotto.add(new Lotto(lottoNumber));
        }
        return purchasedLotto;
    }

    public LottoRankResult getCountResult(Lotto winningNumber, BonusNumber bonusNumber, List<Lotto> purchasedLotto) {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }

        purchasedLotto.forEach(lotto -> {
            LottoRank rank = LottoRank.getResult(lotto.countMatches(winningNumber), lotto.isContain(bonusNumber.value()));
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        });

        return new LottoRankResult(rankCounts);
    }
}
