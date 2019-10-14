package aho.uozu;

import aho.uozu.score_calculators.*;

public class YatzyConsoleApp
{
    private final TextInput _input;
    private final TextOutput _output;
    private final DiceRoller _diceRoller;
    private final ScoreCalculatorFactory _scoreCalculatorFactory;

    public static void main(String[] args)
    {
        var app = new YatzyConsoleApp(
                () -> System.console().readLine(),
                System.out::println,
                new RandomDiceRoller(),
                new DefaultScoreCalculatorFactory());
        app.start();
    }

    public YatzyConsoleApp(
            TextInput input,
            TextOutput output,
            DiceRoller diceRoller,
            ScoreCalculatorFactory scoreCalculatorFactory) {
        _input = input;
        _output = output;
        _diceRoller = diceRoller;
        _scoreCalculatorFactory = scoreCalculatorFactory;
    }

    public void start() {
        var roll = _diceRoller.nextRoll();
        _output.writeLine("you rolled: " + roll);
        _output.writeLine("enter a category");
        var category = waitForCategoryInput();
        var score = calculateScore(roll, category);
        _output.writeLine("your score: " + score);
    }

    public boolean isFinished() {
        return true;
    }

    private int calculateScore(Roll roll, ScoreCategory category) {
        var calculator = _scoreCalculatorFactory.calculatorFor(category);
        return calculator.calculateScore(roll);
    }

    private ScoreCalculator calculatorFor(ScoreCategory category) {
        switch (category) {
            case CHANCE: return new ChanceScoreCalculator();
            case YATZY: return new YatzyScoreCalculator();

            default: throw new IllegalArgumentException("Unknown category: " + category);
        }
    }

    private ScoreCategory waitForCategoryInput() {
        var input = _input.readLine();
        return ScoreCategory.fromString(input);
    }
}
