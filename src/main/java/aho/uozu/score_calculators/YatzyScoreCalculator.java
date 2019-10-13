package aho.uozu.score_calculators;

import aho.uozu.Roll;

import java.util.Arrays;

public class YatzyScoreCalculator implements ScoreCalculator {
    public int calculateScore(Roll roll) {
        var values = roll.getValues();
        var firstValue = values[0];
        if (Arrays.stream(values).allMatch(value -> value == firstValue)) {
            return 50;
        }
        return 0;
    }
}
