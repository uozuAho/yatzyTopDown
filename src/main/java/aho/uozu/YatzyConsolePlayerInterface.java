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

    public PlayerInput promptForCategoryOrReRoll() {
        _output.writeLine("enter a category, or 'reroll'");
        var rawInput = _input.readLine();
        if (isReRoll(rawInput)) {
            return new PlayerInput(PlayerInputType.ReRoll);
        } else {
            var category = parseCategory(rawInput);
            return new PlayerInput(PlayerInputType.ScoreCategory, category);
        }
    }

    private boolean isReRoll(String rawInput) {
        if (rawInput == null) return false;
        return rawInput.trim().toLowerCase().equals("reroll");
    }

    public void showPlayerScore(int score) {
        _output.writeLine("your score: " + score);
    }

    private ScoreCategory parseCategory(String userInput) {
        var transformed = userInput.trim().toLowerCase();
        return ScoreCategory.fromString(transformed);
    }
}
