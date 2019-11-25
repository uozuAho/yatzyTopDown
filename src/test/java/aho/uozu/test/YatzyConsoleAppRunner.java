package aho.uozu.test;

import aho.uozu.*;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesPattern;
import static org.junit.Assert.*;

public class YatzyConsoleAppRunner {
    private YatzyConsoleApp _game;
    private TextOutputMock _consoleOutput;
    private TextInput _consoleInput;

    public YatzyConsoleAppRunner(TextInput input, DiceRoller diceRoller) {
        _consoleInput = input;
        _consoleOutput = new TextOutputMock();
        _game = new YatzyConsoleApp(_consoleInput, _consoleOutput, diceRoller);
    }

    public YatzyConsoleAppRunner(TextInput input, DiceRoller diceRoller, Collection<ScoreCategory> availableCategories) {
        // todo: consolidate with above constructor
        _consoleInput = input;
        _consoleOutput = new TextOutputMock();
        _game = new YatzyConsoleApp(_consoleInput, _consoleOutput, diceRoller, availableCategories);
    }

    public void doNextTurn() {
        _game.doNextTurn();
    }

    public void displayedRoll(DiceRoll roll) {
        assertThat(_consoleOutput.readNextLine(), is(equalTo("you rolled: " + roll.toString())));
    }

    public void promptedUserForCategory() {
        assertThat(_consoleOutput.readNextLine(), is(equalTo("enter a category")));
    }

    public void promptedUserForCategoryOrReRoll() {
        assertThat(_consoleOutput.readNextLine(), is(equalTo("enter a category, or 'reroll'")));
    }

    public void displayedScore() {
        assertThat(_consoleOutput.readNextLine(), startsWith("your score: "));
    }

    public void displayedScore(int score) {
        assertThat(_consoleOutput.readNextLine(), is(equalTo("your score: " + score)));
    }

    public void isOver() {
        assertTrue(_game.isFinished());
    }

    public void isNotOver() {
        assertFalse(_game.isFinished());
    }

    public void displayedAvailableCategories(int numCategories) {
        assertThat(_consoleOutput.readNextLine(), is(equalTo("available categories:")));
        for (int i = 0; i < numCategories; i++) {
            assertThat(_consoleOutput.readNextLine(), matchesPattern("    .+: \\d+ points"));
        }
    }

    public void displayedAvailableCategoriesInAnyOrder(ScoreCategoryWithScore[] catScores) {
        assertThat(_consoleOutput.readNextLine(), is(equalTo("available categories:")));
        var outputLines = new ArrayList<String>();
        for (int i = 0; i < catScores.length; i++) {
            outputLines.add(_consoleOutput.readNextLine());
        }
        for (var catScore : catScores) {
            var expectedDisplay = String.format("    %s: %d points", catScore.category, catScore.score);
            var matchFound = outputLines.stream().anyMatch(outputLine -> expectedDisplay.equals(outputLine));
            assertThat("Found expected category and score in output: " + expectedDisplay, matchFound, is(true));
        }
    }

    public void displayedIncorrectInputMessage() {
        assertThat(_consoleOutput.readNextLine(), is(equalTo("bad input")));
    }

    public void displayedUnavailableCategoryMessage() {
        assertThat(_consoleOutput.readNextLine(), is(equalTo("category not available!")));
    }
}
