package aho.uozu;

import java.util.LinkedList;
import java.util.Queue;

public class ConsoleInputMock implements ConsoleInput {

    private final Queue<String> lines;

    ConsoleInputMock() {
        lines = new LinkedList<>();
    }

    @Override
    public String readLine() {
        if (lines.size() == 0) {
            throw new IllegalStateException("no input to read");
        }
        return lines.remove();
    }

    public void addInputLine(String line) {
        lines.add(line);
    }
}
