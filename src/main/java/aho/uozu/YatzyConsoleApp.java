package aho.uozu;

public class YatzyConsoleApp
{
    public static void main(String[] args)
    {
        var app = new YatzyConsoleApp(System.out::println);
    }

    public YatzyConsoleApp(ConsoleOutput consoleOutput) {
    }

    public boolean isFinished() {
        return true;
    }
}
