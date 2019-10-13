package aho.uozu;

import java.util.Arrays;

public class ScoreCalculator {
    public int calculateScore(Roll roll, ScoreCategory category) {
        if (category == ScoreCategory.CHANCE)
            return Arrays.stream(roll.getValues()).sum();
        if (category == ScoreCategory.YATZY)
            return calculateYatzyScore(roll);

        throw new IllegalStateException("Unknown category: " + category);
    }

    private int calculateYatzyScore(Roll roll) {
        var values = roll.getValues();
        var firstValue = values[0];
        if (Arrays.stream(values).allMatch(value -> value == firstValue)) {
            return 50;
        }
        return 0;
    }
}
