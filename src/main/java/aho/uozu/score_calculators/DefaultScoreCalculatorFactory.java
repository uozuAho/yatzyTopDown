package aho.uozu.score_calculators;

import aho.uozu.ScoreCategory;

public class DefaultScoreCalculatorFactory implements ScoreCalculatorFactory {
    @Override
    public ScoreCalculator calculatorFor(ScoreCategory category) {
        switch (category) {
            case CHANCE: return new ChanceScoreCalculator();
            case YATZY: return new YatzyScoreCalculator();

            default: throw new IllegalArgumentException("Unknown category: " + category);
        }
    }
}
