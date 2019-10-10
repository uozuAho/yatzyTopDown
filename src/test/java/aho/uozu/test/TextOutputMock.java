package aho.uozu.test;

import aho.uozu.TextOutput;

import java.util.LinkedList;
import java.util.Queue;

public class TextOutputMock implements TextOutput {

    private final Queue<String> _lines;

    TextOutputMock() {
        _lines = new LinkedList<>();
    }

    @Override
    public void writeLine(String value) {
        _lines.add(value);
    }

    public String readNextLine() {
        return _lines.remove();
    }
}
