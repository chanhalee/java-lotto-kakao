package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManuallyChosenNumbers extends Numbers {

    public ManuallyChosenNumbers(List<Number> regularNumbers) {
        this(new HashSet<>(regularNumbers));
    }

    public ManuallyChosenNumbers(Set<Number> regularNumbers) {
        super(regularNumbers);
        validateWinningNumber(regularNumbers);
    }

    private void validateWinningNumber(Set<Number> regularNumbers) {
        if (regularNumbers.size() != 6) {
            throw new RuntimeException("로또 번호는 중복되지 않는 6개의 수로 구성되어야 합니다.");
        }
    }
}
