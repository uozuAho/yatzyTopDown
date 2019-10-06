package aho.uozu;

import java.util.Deque;
import java.util.LinkedList;

public class ConsoleOutputMock implements ConsoleOutput {

    private final Deque<String> lines;

    ConsoleOutputMock() {
        lines = new LinkedList<>();
    }

    @Override
    public void writeLine(String value) {
        lines.add(value);
    }

    public String readNextLine() {
        return lines.pop();
    }
}
