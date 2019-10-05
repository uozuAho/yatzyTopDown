package aho.uozu;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class YatzyConsoleAppRunner {
    private YatzyConsoleApp game;
    private ConsoleOutputMock consoleOutput;

    public YatzyConsoleAppRunner(PlayerMock player) {

    }

    public void start() {
        consoleOutput = new ConsoleOutputMock();
        game = new YatzyConsoleApp(consoleOutput);
    }

    public void displayedRollAndPromptedUserForCategory() {
        assertThat(consoleOutput.getSecondLastLine(), is(equalTo("you rolled: 1, 1, 1, 1, 1")));
        assertThat(consoleOutput.getLastLine(), is(equalTo("enter a category")));
    }

    public void displayedScore() {
        assertThat(consoleOutput.getLastLine(), is(equalTo("your score: 0")));
    }

    public void gameIsOver() {
        assertTrue(game.isFinished());
    }

    public void receivedCategory(ScoreCategory category) {
        throw new IllegalStateException("not implemented");
    }
}
