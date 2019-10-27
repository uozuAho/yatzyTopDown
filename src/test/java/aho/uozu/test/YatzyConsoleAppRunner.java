package aho.uozu.test;

import aho.uozu.*;

import static org.hamcrest.CoreMatchers.equalTo;
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

    public void start() {
        _game.start();
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

    public void displayedAvailableCategories(ScoreCategory[] availableCategories) {
        assertThat(_consoleOutput.readNextLine(), is(equalTo("available categories:")));
        for (var category : availableCategories) {
            assertThat(_consoleOutput.readNextLine(), matchesPattern("    " + category + ": \\d+ points"));
        }
    }
}
