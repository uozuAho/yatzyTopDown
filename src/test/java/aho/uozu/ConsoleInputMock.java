package aho.uozu;

public class ConsoleInputMock implements ConsoleInput {
    @Override
    public String readLine() {
        return null;
    }

    public String getLastLine() {
        return "todo: implement me";
    }
}
