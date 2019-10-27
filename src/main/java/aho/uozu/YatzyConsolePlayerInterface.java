package aho.uozu;

class YatzyConsolePlayerInterface implements YatzyPlayerInterface {
    private TextOutput _output;
    private TextInput _input;

    YatzyConsolePlayerInterface(TextOutput output, TextInput input) {
        _output = output;
        _input = input;
    }

    public void showPlayerRolled(Roll roll) {
        _output.writeLine("you rolled: " + roll);
    }

    public void showAvailableCategories(ScoreCategory[] categories) {
        _output.writeLine("available categories:");
        for (var category : categories) {
            _output.writeLine("    " + category);
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
        return ScoreCategory.fromString(input);
    }
}
