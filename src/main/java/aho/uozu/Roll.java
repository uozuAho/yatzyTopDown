package aho.uozu;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Roll {
    private final int[] _diceValues;

    Roll(int[] diceValues) {
        _diceValues = diceValues;
    }

    @Override
    public String toString() {
        return Arrays.stream(_diceValues)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
