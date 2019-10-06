package aho.uozu;

public class YatzyConsoleApp
{
    private final TextInput input;
    private final TextOutput output;

    public static void main(String[] args)
    {
        var app = new YatzyConsoleApp(() -> System.console().readLine(), System.out::println);
    }

    public YatzyConsoleApp(TextInput input, TextOutput output) {
        this.input = input;
        this.output = output;

        output.writeLine("you rolled: 1, 1, 1, 1, 1");
        output.writeLine("enter a category");
        waitForUserInput();
        output.writeLine("your score: 0");
    }

    public boolean isFinished() {
        return true;
    }

    public void waitForUserInput() {
        input.readLine();
    }
}
