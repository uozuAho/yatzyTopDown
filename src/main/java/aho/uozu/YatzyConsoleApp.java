package aho.uozu;

public class YatzyConsoleApp
{
    public static void main(String[] args)
    {
        var app = new YatzyConsoleApp(System.out::println);
    }

    public YatzyConsoleApp(ConsoleOutput consoleOutput) {
        consoleOutput.writeLine("you rolled: 1, 1, 1, 1, 1");
        consoleOutput.writeLine("your score: 0");
    }

    public boolean isFinished() {
        return true;
    }
}
