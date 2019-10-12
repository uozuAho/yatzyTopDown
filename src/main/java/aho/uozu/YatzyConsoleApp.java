package aho.uozu;

import java.util.Arrays;

public class YatzyConsoleApp
{
    private final TextInput _input;
    private final TextOutput _output;
    private final DiceRoller _diceRoller;

    public static void main(String[] args)
    {
        var app = new YatzyConsoleApp(() -> System.console().readLine(), System.out::println, new RandomDiceRoller());
        app.start();
    }

    public YatzyConsoleApp(TextInput input, TextOutput output, DiceRoller diceRoller) {
        _input = input;
        _output = output;
        _diceRoller = diceRoller;
    }

    public void start() {
        var roll = _diceRoller.nextRoll();
        _output.writeLine("you rolled: " + roll);
        _output.writeLine("enter a category");
        waitForUserInput();
        var score = calculateScore(roll);
        _output.writeLine("your score: " + score);
    }

    public boolean isFinished() {
        return true;
    }

    private int calculateScore(Roll roll) {
        return Arrays.stream(roll.getValues()).sum();
    }

    private void waitForUserInput() {
        _input.readLine();
    }
}
