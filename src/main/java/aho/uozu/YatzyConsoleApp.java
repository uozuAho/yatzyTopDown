package aho.uozu;

import aho.uozu.score_calculators.*;

import java.util.Arrays;
import java.util.Collection;

public class YatzyConsoleApp
{
    private final YatzyGame _game;

    public static void main(String[] args) {
        var app = new YatzyConsoleApp(
                () -> System.console().readLine(),
                System.out::println);
        app.run();
    }

    public YatzyConsoleApp(TextInput input, TextOutput output) {
        this(input, output, new RandomDiceRoller(), Arrays.asList(ScoreCategory.all()), new DefaultScoreCalculatorFactory());
    }

    public YatzyConsoleApp(TextInput input, TextOutput output, DiceRoller diceRoller) {
        this(input, output, diceRoller, Arrays.asList(ScoreCategory.all()), new DefaultScoreCalculatorFactory());
    }

    public YatzyConsoleApp(TextInput input,
                           TextOutput output,
                           DiceRoller diceRoller,
                           Collection<ScoreCategory> availableCategories) {
        this(input, output, diceRoller, availableCategories, new DefaultScoreCalculatorFactory());
    }

    private YatzyConsoleApp(
            TextInput input,
            TextOutput output,
            DiceRoller diceRoller,
            Collection<ScoreCategory> availableCategories,
            ScoreCalculatorFactory scoreCalculatorFactory)
    {
        _game = new YatzyGame(
                diceRoller,
                availableCategories,
                scoreCalculatorFactory,
                new YatzyConsolePlayerInterface(output, input)
        );
    }

    public void run() {
        _game.run();
    }

    public void doNextTurn() {
        _game.runNextPlayerTurn();
    }

    public boolean isFinished() {
        return _game.isFinished();
    }
}
