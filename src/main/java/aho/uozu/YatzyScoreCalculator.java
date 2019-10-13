package aho.uozu;

import java.util.Arrays;

public class YatzyScoreCalculator implements IScoreCalculator  {
    public int calculateScore(Roll roll) {
        var values = roll.getValues();
        var firstValue = values[0];
        if (Arrays.stream(values).allMatch(value -> value == firstValue)) {
            return 50;
        }
        return 0;
    }
}
