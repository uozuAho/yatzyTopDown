package aho.uozu;

import aho.uozu.score_calculators.*;

public class YatzyConsoleApp
{
    private final TextInput _input;
    private final TextOutput _output;
    private final DiceRoller _diceRoller;
    private final ScoreCalculatorFactory _scoreCalculatorFactory;

    public static void main(String[] args) {
        var app = new YatzyConsoleApp(
                () -> System.console().readLine(),
                System.out::println);
        app.start();
    }

    public YatzyConsoleApp(TextInput input, TextOutput output) {
        this(input, output, new RandomDiceRoller(), new DefaultScoreCalculatorFactory());
    }

    public YatzyConsoleApp(TextInput input, TextOutput output, DiceRoller diceRoller) {
        this(input, output, diceRoller, new DefaultScoreCalculatorFactory());
    }

    private YatzyConsoleApp(
            TextInput input,
            TextOutput output,
            DiceRoller diceRoller,
            ScoreCalculatorFactory scoreCalculatorFactory)
    {
        _input = input;
        _output = output;
        _diceRoller = diceRoller;
        _scoreCalculatorFactory = scoreCalculatorFactory;
    }

    public void start() {
        var game = new YatzyGame();
        game.rollDice();
        _output.writeLine("you rolled: " + game.getCurrentRoll());
        _output.writeLine("available categories:");
        for (var category : ScoreCategory.all()) {
            _output.writeLine("    " + category);
        }
        _output.writeLine("enter a category");
        var category = waitForCategoryInput();
        var score = calculateScore(game.getCurrentRoll(), category);
        _output.writeLine("your score: " + score);
    }

    public boolean isFinished() {
        return true;
    }

    private int calculateScore(Roll roll, ScoreCategory category) {
        var calculator = _scoreCalculatorFactory.calculatorFor(category);
        return calculator.calculateScore(roll);
    }

    private ScoreCategory waitForCategoryInput() {
        var input = _input.readLine();
        return ScoreCategory.fromString(input);
    }

    private class YatzyGame {
        private Roll _currentRoll;

        public void rollDice() {
            _currentRoll = _diceRoller.nextRoll();
        }

        public Roll getCurrentRoll() {
            return _currentRoll;
        }
    }
}
