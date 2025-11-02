package lotto.util;

import java.util.List;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class InputParserTest {
    @Test
    @DisplayName("입력 값을 제대로 입력한 경우")
    void validWinnigNumberParseTest() {
        List<Integer> numbers = InputParser.parseWinningNumber("1,2,3,4,5,6");
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("정수가 아닌 숫자를 입력한 경우")
    void invalidWinningNumberParseTest() {
        assertThatThrownBy(() -> InputParser.parseWinningNumber("1,2,3,o,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PARSE_INTEGER_INPUT.getMessage());
    }
}
