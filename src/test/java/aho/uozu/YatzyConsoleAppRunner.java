package aho.uozu;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class YatzyConsoleAppRunner {
    private YatzyConsoleApp game;
    private TextOutputMock consoleOutput;
    private TextInput consoleInput;

    public YatzyConsoleAppRunner(TextInput input) {
        consoleInput = input;
        consoleOutput = new TextOutputMock();
        game = new YatzyConsoleApp(consoleInput, consoleOutput);
    }

    public void start() {
        game.start();
    }

    public void displayedRoll() {
        assertThat(consoleOutput.readNextLine(), is(equalTo("you rolled: 1, 1, 1, 1, 1")));
    }

    public void promptedUserForCategory() {
        assertThat(consoleOutput.readNextLine(), is(equalTo("enter a category")));
    }

    public void displayedScore() {
        assertThat(consoleOutput.readNextLine(), is(equalTo("your score: 0")));
    }

    public void gameIsOver() {
        assertTrue(game.isFinished());
    }
}
