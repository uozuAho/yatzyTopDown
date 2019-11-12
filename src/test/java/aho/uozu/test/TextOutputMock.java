package aho.uozu.test;

import aho.uozu.TextOutput;

import java.util.LinkedList;
import java.util.Queue;

public class TextOutputMock implements TextOutput {

    private final Queue<String> _lines;

    public TextOutputMock() {
        _lines = new LinkedList<>();
    }

    @Override
    public void writeLine(String value) {
        _lines.add(value);
    }

    public String readNextLine() {
        if (_lines.isEmpty())
            throw new IllegalStateException("No more lines of output");
        return _lines.remove();
    }
}
