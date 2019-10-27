package aho.uozu;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DiceRoll {
    private final int[] _diceValues;

    public DiceRoll(int[] diceValues) {
        if (diceValues == null)     throw new NullPointerException();
        if (diceValues.length != 5) throw new IllegalArgumentException("must have 5 dice values");
        if (Arrays.stream(diceValues).anyMatch(value -> !isValidValue(value)))
            throw new IllegalArgumentException("dice values must be between 1-6");

        _diceValues = diceValues;
    }

    @Override
    public String toString() {
        return Arrays.stream(_diceValues)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public int[] getValues() {
        return _diceValues;
    }

    private boolean isValidValue(int i) {
        return i > 0 && i < 7;
    }
}
