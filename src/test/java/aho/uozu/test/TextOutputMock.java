package aho.uozu.test;

import aho.uozu.TextOutput;

import java.util.LinkedList;
import java.util.Queue;

public class TextOutputMock implements TextOutput {

    private final Queue<String> lines;

    TextOutputMock() {
        lines = new LinkedList<>();
    }

    @Override
    public void writeLine(String value) {
        lines.add(value);
    }

    public String readNextLine() {
        return lines.remove();
    }
}
