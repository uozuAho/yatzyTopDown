package aho.uozu;

import aho.uozu.score_calculators.ScoreCalculatorFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class YatzyGame {
    private final int MAX_REROLLS = 3;

    private final DiceRoller _diceRoller;
    private final ScoreCalculatorFactory _scoreCalculatorFactory;
    private final YatzyPlayerInterface _playerInterface;
    private final HashSet<ScoreCategory> _availableCategories;

    private DiceRoll _currentRoll;

    public YatzyGame(DiceRoller diceRoller, ScoreCalculatorFactory scoreCalculatorFactory, YatzyPlayerInterface playerInterface) {
        _diceRoller = diceRoller;
        _scoreCalculatorFactory = scoreCalculatorFactory;
        _playerInterface = playerInterface;
        _availableCategories = new HashSet<>(Set.of(ScoreCategory.all()));
    }

    public void run() {
        while(!isFinished()) {
            runNextPlayerTurn();
        }
    }

    public void runNextPlayerTurn() {
        PlayerInput input;
        int _availableReRolls = MAX_REROLLS;
        var turnIsOver = false;

        while (!turnIsOver) {
            rollDice();
            _playerInterface.showPlayerRolled(getCurrentRoll());
            _playerInterface.showAvailableCategories(getAvailableCategoriesWithScores());
            if (_availableReRolls > 0) {
                input = _playerInterface.promptForCategoryOrReRoll(_availableCategories);
            } else {
                input = _playerInterface.promptForCategory(_availableCategories);
            }
            if (input.type == PlayerInputType.ReRoll) {
                _availableReRolls--;
            }
            else {
                var category = (ScoreCategory) input.value;
                _availableCategories.remove(category);
                _playerInterface.showPlayerScore(scoreCurrentRoll(category));
                turnIsOver = true;
            }
        }
    }

    void rollDice() {
        _currentRoll = _diceRoller.nextRoll();
    }

    DiceRoll getCurrentRoll() {
        return _currentRoll;
    }

    List<ScoreCategoryWithScore> getAvailableCategoriesWithScores() {
        return _availableCategories.stream()
                .map(category -> new ScoreCategoryWithScore(category, scoreCurrentRoll(category)))
                .collect(Collectors.toList());
    }

    int scoreCurrentRoll(ScoreCategory category) {
        var calculator = _scoreCalculatorFactory.calculatorFor(category);
        return calculator.calculateScore(_currentRoll);
    }

    public boolean isFinished() {
        return _availableCategories.size() == 0;
    }
}
