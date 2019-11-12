package aho.uozu.test.tests;

import aho.uozu.ScoreCategory;
import aho.uozu.TextInput;

public class YatzyPlayerMock implements TextInput {

    private ScoreCategory _nextInput;

    public void setNextInput(ScoreCategory category) {
        _nextInput = category;
    }

    @Override
    public String readLine() {
        return _nextInput.toString();
    }
}
