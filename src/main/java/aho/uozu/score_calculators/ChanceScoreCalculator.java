package aho.uozu.score_calculators;

import aho.uozu.DiceRoll;

import java.util.Arrays;

public class ChanceScoreCalculator implements ScoreCalculator {
    public int calculateScore(DiceRoll roll) {
        return Arrays.stream(roll.getValues()).sum();
    }
}
