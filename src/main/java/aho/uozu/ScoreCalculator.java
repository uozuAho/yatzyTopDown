package aho.uozu;

import java.util.Arrays;

public class ScoreCalculator {
    int calculateScore(Roll roll, ScoreCategory category) {
        if (category == ScoreCategory.CHANCE)
            return Arrays.stream(roll.getValues()).sum();
        if (category == ScoreCategory.YATZY)
            return 50;

        throw new IllegalStateException("Unknown category: " + category);
    }
}
