package aho.uozu;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Roll {
    private final int[] _diceValues;

    public Roll(int[] diceValues) {
        if (diceValues == null) throw new NullPointerException();
        if (diceValues.length != 5) throw new IllegalArgumentException("must have 5 dice values");

        _diceValues = diceValues;
    }

    @Override
    public String toString() {
        return Arrays.stream(_diceValues)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    int[] getValues() {
        return _diceValues;
    }
}
