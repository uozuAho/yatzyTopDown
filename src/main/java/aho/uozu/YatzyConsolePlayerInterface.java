package aho.uozu;

import java.util.Collection;

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

    @Override
    public PlayerInput promptForCategory(Collection<ScoreCategoryWithScore> availableCategories) {
        while (true) {
            showAvailableCategories(availableCategories);
            var rawInput = prompt("Enter a category");
            if (isReRoll(rawInput)) {
                _output.writeLine("You have no re-rolls remaining!");
                continue;
            }
            try {
                var category = parseCategory(rawInput);
                if (availableCategories.stream().noneMatch(sc -> sc.category == category)) {
                    _output.writeLine("That category is not available!");
                    continue;
                }
                return new PlayerInput(PlayerInputType.ScoreCategory, category);
            } catch (IllegalArgumentException e) {
                _output.writeLine("bad input");
            }
        }
    }

    @Override
    public PlayerInput promptForCategoryOrReRoll(Collection<ScoreCategoryWithScore> availableCategories) {
        while (true) {
            showAvailableCategories(availableCategories);
            var rawInput = prompt("Enter a category, or 'reroll'");
            if (isReRoll(rawInput)) {
                return new PlayerInput(PlayerInputType.ReRoll);
            } else {
                try {
                    var category = parseCategory(rawInput);
                    if (availableCategories.stream().noneMatch(sc -> sc.category == category)) {
                        _output.writeLine("That category is not available!");
                        continue;
                    }
                    return new PlayerInput(PlayerInputType.ScoreCategory, category);
                } catch (IllegalArgumentException e) {
                    _output.writeLine("bad input");
                }
            }
        }
    }

    @Override
    public void showPlayerScore(int score) {
        _output.writeLine("your score: " + score);
    }

    private String prompt(String promptMessage) {
        outputBlankLine();
        _output.writeLine(promptMessage);
        outputBlankLine();
        return _input.readLine();
    }

    private void showAvailableCategories(Collection<ScoreCategoryWithScore> categories) {
        outputBlankLine();
        _output.writeLine("Available categories:");
        for (var cat : categories) {
            _output.writeLine(String.format(
                    "    %s: %d points", cat.category, cat.score));
        }
    }

    private void outputBlankLine() {
        _output.writeLine("");
    }

    private boolean isReRoll(String rawInput) {
        if (rawInput == null) return false;
        return rawInput.trim().toLowerCase().equals("reroll");
    }

    private ScoreCategory parseCategory(String userInput) {
        var transformed = userInput.trim().toLowerCase();
        return ScoreCategory.fromString(transformed);
    }
}
