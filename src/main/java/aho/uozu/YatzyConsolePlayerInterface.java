package aho.uozu;

import java.util.List;

public class YatzyConsolePlayerInterface implements YatzyPlayerInterface {
    private TextOutput _output;
    private TextInput _input;

    public YatzyConsolePlayerInterface(TextOutput output, TextInput input) {
        _output = output;
        _input = input;
    }

    public void showPlayerRolled(DiceRoll roll) {
        _output.writeLine("you rolled: " + roll);
    }

    public void showAvailableCategories(List<ScoreCategoryWithScore> categories) {
        _output.writeLine("available categories:");
        for (var cat : categories) {
            _output.writeLine(String.format(
                    "    %s: %d points", cat.category, cat.score));
        }
    }

    public ScoreCategory promptForCategoryInput() {
        _output.writeLine("enter a category");
        return waitForCategoryInput();
    }

    public void showPlayerScore(int score) {
        _output.writeLine("your score: " + score);
    }

    private ScoreCategory waitForCategoryInput() {
        var input = _input.readLine();
        return parseCategory(input);
    }

    private ScoreCategory parseCategory(String userInput) {
        var transformed = userInput.trim().toLowerCase();
        return ScoreCategory.fromString(transformed);
    }
}
