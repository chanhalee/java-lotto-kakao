package lotto.domain;

import java.util.Objects;

public class Number {
    private final int number;
    public Number(int number) {
        validateBall(number);
        this.number = number;
    }

    private void validateBall(int number) {
        if (number < 1) {
            throw new RuntimeException("공은 1이상의 정수여야 합니다.");
        }

        if (number > 45) {
            throw new RuntimeException("공은 45이하의 정수여야 합니다.");
        }
    }

    public Integer toInteger() {
        return number;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        Number number = (Number)other;
        return this.number == number.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
