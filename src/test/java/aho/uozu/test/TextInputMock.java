package aho.uozu.test;

import aho.uozu.TextInput;

import java.util.LinkedList;
import java.util.Queue;

public class TextInputMock implements TextInput {

    private final Queue<String> _lines;

    public TextInputMock() {
        _lines = new LinkedList<>();
    }

    @Override
    public String readLine() {
        if (_lines.size() == 0) {
            throw new IllegalStateException("no input to read");
        }
        return _lines.remove();
    }

    public void enqueueLine(String... lines) {
        for (var line : lines) {
            _lines.add(line);
        }
    }
}
