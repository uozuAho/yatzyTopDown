package aho.uozu;

public class YatzyConsoleApp
{
    private final TextInput _input;
    private final TextOutput _output;
    private final DiceRoller _diceRoller;
    private final ScoreCalculator _scoreCalculator;

    public static void main(String[] args)
    {
        var app = new YatzyConsoleApp(
                () -> System.console().readLine(),
                System.out::println,
                new RandomDiceRoller(),
                new ScoreCalculator());
        app.start();
    }

    public YatzyConsoleApp(TextInput input, TextOutput output, DiceRoller diceRoller, ScoreCalculator scoreCalculator) {
        _input = input;
        _output = output;
        _diceRoller = diceRoller;
        _scoreCalculator = scoreCalculator;
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
        return _scoreCalculator.calculateScore(roll, category);
    }

    private ScoreCategory waitForCategoryInput() {
        var input = _input.readLine();
        return ScoreCategory.fromString(input);
    }
}
