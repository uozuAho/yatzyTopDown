package aho.uozu;

import aho.uozu.score_calculators.ScoreCalculatorFactory;

class YatzyGame {
    private final DiceRoller _diceRoller;
    private final ScoreCalculatorFactory _scoreCalculatorFactory;

    private Roll _currentRoll;

    YatzyGame(DiceRoller diceRoller, ScoreCalculatorFactory scoreCalculatorFactory) {
        _diceRoller = diceRoller;
        _scoreCalculatorFactory = scoreCalculatorFactory;
    }

    void rollDice() {
        _currentRoll = _diceRoller.nextRoll();
    }

    Roll getCurrentRoll() {
        return _currentRoll;
    }

    ScoreCategory[] getAvailableCategories() {
        return ScoreCategory.all();
    }

    int scoreCurrentRoll(ScoreCategory category) {
        var calculator = _scoreCalculatorFactory.calculatorFor(category);
        return calculator.calculateScore(_currentRoll);
    }
}
