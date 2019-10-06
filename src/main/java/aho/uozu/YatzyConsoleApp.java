package aho.uozu;

public class YatzyConsoleApp
{
    private final ConsoleInput consoleInput;
    private final ConsoleOutput consoleOutput;

    public static void main(String[] args)
    {
        var app = new YatzyConsoleApp(() -> System.console().readLine(), System.out::println);
    }

    public YatzyConsoleApp(ConsoleInput consoleInput, ConsoleOutput consoleOutput) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;

        consoleOutput.writeLine("you rolled: 1, 1, 1, 1, 1");
        consoleOutput.writeLine("enter a category");
        waitForUserInput();
        consoleOutput.writeLine("your score: 0");
    }

    public boolean isFinished() {
        return true;
    }

    public void waitForUserInput() {
        consoleInput.readLine();
    }
}
