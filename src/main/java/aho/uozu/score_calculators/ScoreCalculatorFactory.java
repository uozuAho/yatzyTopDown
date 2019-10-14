package aho.uozu.score_calculators;

import aho.uozu.ScoreCategory;

public interface ScoreCalculatorFactory {
    ScoreCalculator calculatorFor(ScoreCategory category);
}
