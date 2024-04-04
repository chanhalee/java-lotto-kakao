package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class TicketNumbersTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    public void 로또_번호는_중복되지_않는_6개의_수로_이루어져_있다(String numbers) {
        List<Number> numberList = parseNumbers(numbers);
        TicketNumbers ticketNumbers = new TicketNumbers(numberList);
        Assertions.assertThat(ticketNumbers).isInstanceOf(TicketNumbers.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,6,6"})
    public void 로또_번호가_중복되는_경우_예외를_던진다(String numbers) {
        List<Number> numberList = parseNumbers(numbers);
        Assertions.assertThatThrownBy(() -> new TicketNumbers(numberList)).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    public void 로또_번호가_6개가_아닌_경우_예외를_던진다(String numbers) {
        List<Number> numberList = parseNumbers(numbers);
        Assertions.assertThatThrownBy(() -> new TicketNumbers(numberList)).isInstanceOf(RuntimeException.class);
    }

    private static List<Number> parseNumbers(String numbers) {
        List<Number> numberList = Arrays.stream(numbers.split(","))
            .map(Integer::parseInt)
            .map(Number::getNumberInstance)
            .collect(Collectors.toList());
        return numberList;
    }

}
