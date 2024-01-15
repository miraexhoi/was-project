package org.example.calculator.domain;

public class PositiveNumber {
    private final int value;

    public PositiveNumber(int value) {
        this.value = value;
    }

    public void PositiveNumber(int value) {
        if (isNagativeNumber(value)) {
            throw new IllegalArgumentException("0또는 음수를 전달할 수 없습니다.");
        }
    }

    private boolean isNagativeNumber(int value) {
        return value <= 0;
    }

    public int toInt() {
        return value;
    }
}
