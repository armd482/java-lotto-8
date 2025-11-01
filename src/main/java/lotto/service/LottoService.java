package lotto.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoService {
    public List<Lotto> purchaseLotto(int amount) {
        List<Lotto> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchasedLotto.add(new Lotto(lottoNumber));
        }
        return purchasedLotto;
    }
}
