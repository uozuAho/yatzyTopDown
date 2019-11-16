package aho.uozu.test.tests;

import aho.uozu.TextInput;

import java.util.LinkedList;
import java.util.Queue;

public class YatzyPlayerMock implements TextInput {

    private Queue<String> _inputs = new LinkedList<>();

    public void enqueueInput(String... inputs) {
        for (var input : inputs) {
            _inputs.add(input);
        }
    }

    @Override
    public String readLine() {
        return _inputs.remove();
    }
}
