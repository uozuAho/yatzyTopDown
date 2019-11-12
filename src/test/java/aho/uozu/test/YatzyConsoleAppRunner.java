package aho.uozu.test;

import aho.uozu.*;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
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

    public void run() {
        _game.run();
    }

    public void displayedRoll(DiceRoll roll) {
        assertThat(_consoleOutput.readNextLine(), is(equalTo("you rolled: " + roll.toString())));
    }

    public void promptedUserForCategory() {
        assertThat(_consoleOutput.readNextLine(), is(equalTo("enter a category")));
    }

    public void displayedScore(int score) {
        assertThat(_consoleOutput.readNextLine(), is(equalTo("your score: " + score)));
    }

    public void gameIsOver() {
        assertTrue(_game.isFinished());
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
}
