package aho.uozu;

import java.util.Deque;
import java.util.LinkedList;

public class TextOutputMock implements TextOutput {

    private final Deque<String> lines;

    TextOutputMock() {
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
