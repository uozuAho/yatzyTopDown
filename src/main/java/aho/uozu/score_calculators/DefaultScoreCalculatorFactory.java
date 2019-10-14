package aho.uozu.score_calculators;

import aho.uozu.ScoreCategory;

public class DefaultScoreCalculatorFactory implements ScoreCalculatorFactory {
    @Override
    public ScoreCalculator calculatorFor(ScoreCategory category) {
        return new ChanceScoreCalculator();
    }
}
