package aho.uozu;

public class YatzyConsoleApp
{
    private final TextInput input;
    private final TextOutput output;
    private final DiceRoller diceRoller;

    public static void main(String[] args)
    {
        var app = new YatzyConsoleApp(() -> System.console().readLine(), System.out::println, new RandomDiceRoller());
        app.start();
    }

    public YatzyConsoleApp(TextInput input, TextOutput output, DiceRoller diceRoller) {
        this.input = input;
        this.output = output;
        this.diceRoller = diceRoller;
    }

    public void start() {
        output.writeLine("you rolled: " + this.diceRoller.nextRoll().toString());
        output.writeLine("enter a category");
        waitForUserInput();
        output.writeLine("your score: 5");
    }

    public boolean isFinished() {
        return true;
    }

    private void waitForUserInput() {
        input.readLine();
    }
}
