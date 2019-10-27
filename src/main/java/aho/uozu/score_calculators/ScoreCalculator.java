package aho.uozu.score_calculators;

import aho.uozu.DiceRoll;

public interface ScoreCalculator {
    int calculateScore(DiceRoll roll);
}
