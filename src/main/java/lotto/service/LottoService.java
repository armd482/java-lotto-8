package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoService {
    private final List<Lotto> purchasedLotto = new ArrayList<>();

    public void purchaseLotto(int amount) {
        for (int i = 0; i < amount; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchasedLotto.add(new Lotto(lottoNumber));
        }
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }
}
