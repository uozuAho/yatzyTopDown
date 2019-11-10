package aho.uozu.test;

import aho.uozu.DiceRoll;
import aho.uozu.score_calculators.ScoreCalculator;

public class ConstantScoreCalculator implements ScoreCalculator {
    private final int _score;

    public ConstantScoreCalculator(int score) {
        _score = score;
    }

    @Override
    public int calculateScore(DiceRoll roll) {
        return _score;
    }
}
