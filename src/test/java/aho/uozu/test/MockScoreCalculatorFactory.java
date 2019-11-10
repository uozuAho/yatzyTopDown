package aho.uozu.test;

import aho.uozu.ScoreCategory;
import aho.uozu.score_calculators.ScoreCalculator;
import aho.uozu.score_calculators.ScoreCalculatorFactory;

import java.util.Map;

public class MockScoreCalculatorFactory implements ScoreCalculatorFactory {
    private final Map<ScoreCategory, ScoreCalculator> _calculators;

    public MockScoreCalculatorFactory(Map<ScoreCategory, ScoreCalculator> calculators) {
        _calculators = calculators;
    }

    @Override
    public ScoreCalculator calculatorFor(ScoreCategory category) {
        return _calculators.get(category);
    }
}
