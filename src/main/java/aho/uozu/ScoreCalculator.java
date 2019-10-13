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
        var calculator = new YatzyScoreCalculator();
        return calculator.calculateScore(roll);
    }
}
