package aho.uozu;

import java.util.Arrays;

public class ScoreCalculator {
    int calculateScore(int[] diceValues, ScoreCategory category) {
        if (category == ScoreCategory.CHANCE)
            return Arrays.stream(diceValues).sum();
        if (category == ScoreCategory.YATZY)
            return 50;

        throw new IllegalStateException("Unknown category: " + category);
    }
}
