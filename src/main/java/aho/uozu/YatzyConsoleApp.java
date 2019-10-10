package aho.uozu;

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
        _output.writeLine("you rolled: " + _diceRoller.nextRoll().toString());
        _output.writeLine("enter a category");
        waitForUserInput();
        _output.writeLine("your score: 5");
    }

    public boolean isFinished() {
        return true;
    }

    private void waitForUserInput() {
        _input.readLine();
    }
}
