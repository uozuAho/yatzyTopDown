package aho.uozu;

import aho.uozu.score_calculators.*;

public class YatzyConsoleApp
{
    private final YatzyGame _game;

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
        _game = new YatzyGame(diceRoller, scoreCalculatorFactory, new YatzyConsolePlayerInterface(output, input));
    }

    public void start() {
        _game.start();
    }

    public boolean isFinished() {
        return _game.isFinished();
    }
}
