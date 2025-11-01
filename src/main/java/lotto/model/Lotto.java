package lotto.model;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoRule;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Boolean isContain(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int countMatches(Lotto otherLotto) {
        return (int) numbers.stream()
                            .filter(otherLotto::isContain)
                            .count();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoRule.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_ERROR.getMessage());
        }

        if (numbers.stream().anyMatch(number -> number < LottoRule.MIN_LOTTO_NUMBER || number > LottoRule.MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }

        if(numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }
}
