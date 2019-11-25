package aho.uozu;

import java.util.Collection;
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

    @Override
    public PlayerInput promptForCategory(Collection<ScoreCategory> availableCategories) {
        while (true) {
            _output.writeLine("enter a category");
            var rawInput = _input.readLine();
            try {
                var category = parseCategory(rawInput);
                return new PlayerInput(PlayerInputType.ScoreCategory, category);
            } catch (IllegalArgumentException e) {
                _output.writeLine("bad input");
            }
        }
    }

    @Override
    public PlayerInput promptForCategoryOrReRoll(Collection<ScoreCategory> availableCategories) {
        while (true) {
            _output.writeLine("enter a category, or 'reroll'");
            var rawInput = _input.readLine();
            if (isReRoll(rawInput)) {
                return new PlayerInput(PlayerInputType.ReRoll);
            } else {
                try {
                    var category = parseCategory(rawInput);
                    return new PlayerInput(PlayerInputType.ScoreCategory, category);
                } catch (IllegalArgumentException e) {
                    _output.writeLine("bad input");
                }
            }
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
