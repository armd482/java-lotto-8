package lotto.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoRule;
import lotto.model.Lotto;

public class RandomLottoGenerateStrategy implements LottoGenerateStrategy {
    public Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoRule.MIN_LOTTO_NUMBER, LottoRule.MAX_LOTTO_NUMBER, LottoRule.LOTTO_NUMBER_SIZE));
    }

}
