package aho.uozu.score_calculators;

import aho.uozu.Roll;

import java.util.Arrays;

public class ChanceScoreCalculator implements ScoreCalculator {
    public int calculateScore(Roll roll) {
        return Arrays.stream(roll.getValues()).sum();
    }
}
