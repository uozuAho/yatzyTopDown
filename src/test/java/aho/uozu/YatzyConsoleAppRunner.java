package aho.uozu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class YatzyConsoleAppRunner {
    private YatzyConsoleApp game;
    private ConsoleOutputMock consoleOutput;

    public YatzyConsoleAppRunner(PlayerMock player) {

    }

    public void start() {
        consoleOutput = new ConsoleOutputMock();
        game = new YatzyConsoleApp(consoleOutput);
    }

    public void displaysRoll() {
        assertEquals(consoleOutput.getOutputLine(0), "you rolled: 1, 1, 1, 1, 1");
    }

    public void displaysScore() {
        assertEquals(consoleOutput.getOutputLine(1), "your score: 0");
    }

    public void gameIsOver() {
        assertTrue(game.isFinished());
    }

    public void promptsPlayerForCategory() {
        throw new IllegalStateException("not implemented");
    }

    public void receivedCategory(ScoreCategory category) {
        throw new IllegalStateException("not implemented");
    }
}
