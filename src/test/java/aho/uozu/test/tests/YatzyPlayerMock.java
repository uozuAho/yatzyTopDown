package aho.uozu.test.tests;

import aho.uozu.ScoreCategory;
import aho.uozu.TextInput;
import aho.uozu.test.TextInputMock;

import java.util.LinkedList;
import java.util.Queue;

public class YatzyPlayerMock {

    private final Queue<ScoreCategory> _categoryChoices;

    public YatzyPlayerMock() {
        _categoryChoices = new LinkedList<>();
    }

    public void addNextInput(ScoreCategory category) {
        _categoryChoices.add(category);
    }

    public TextInput textInput() {
        var input = new TextInputMock();
        for (var category : _categoryChoices) {
            input.addInputLine(category.toString());
        }
        return input;
    }
}
