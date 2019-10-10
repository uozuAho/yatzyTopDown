package aho.uozu.test;

import aho.uozu.DiceRoller;
import aho.uozu.Roll;
import aho.uozu.TextInput;
import aho.uozu.YatzyConsoleApp;

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

    public void start() {
        _game.start();
    }

    public void displayedRoll(Roll roll) {
        assertThat(_consoleOutput.readNextLine(), is(equalTo("you rolled: " + roll.toString())));
    }

    public void promptedUserForCategory() {
        assertThat(_consoleOutput.readNextLine(), is(equalTo("enter a category")));
    }

    public void displayedScore() {
        assertThat(_consoleOutput.readNextLine(), is(equalTo("your score: 5")));
    }

    public void gameIsOver() {
        assertTrue(_game.isFinished());
    }
}
