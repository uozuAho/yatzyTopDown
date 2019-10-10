package aho.uozu.test;

import aho.uozu.TextInput;

import java.util.LinkedList;
import java.util.Queue;

public class TextInputMock implements TextInput {

    private final Queue<String> lines;

    TextInputMock() {
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
