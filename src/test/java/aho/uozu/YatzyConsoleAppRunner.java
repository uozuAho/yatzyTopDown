package aho.uozu;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class YatzyConsoleAppRunner {
    private YatzyConsoleApp game;
    private ConsoleOutputMock consoleOutput;
    private ConsoleInputMock consoleInput;

    public YatzyConsoleAppRunner(PlayerMock player) {

    }

    public void start() {
        consoleOutput = new ConsoleOutputMock();
        consoleInput = new ConsoleInputMock();
        game = new YatzyConsoleApp(consoleInput, consoleOutput);
    }

    public void displayedRollAndPromptedUserForCategory() {
        assertThat(consoleOutput.readNextLine(), is(equalTo("you rolled: 1, 1, 1, 1, 1")));
        assertThat(consoleOutput.readNextLine(), is(equalTo("enter a category")));
    }

    public void displayedScore() {
        assertThat(consoleOutput.readNextLine(), is(equalTo("your score: 0")));
    }

    public void gameIsOver() {
        assertTrue(game.isFinished());
    }

    public void receivedCategory(ScoreCategory category) {
        game.waitForUserInput();
        var lastInput = consoleInput.getLastLine();
        assertThat(ScoreCategory.fromString(lastInput), is(equalTo(category)));
    }

    public void waitForPlayerInput() {
        consoleInput.readLine();
    }
}
