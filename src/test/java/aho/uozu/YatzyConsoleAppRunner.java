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

    public void displayedRoll() {
        assertEquals(consoleOutput.getLastLine(), "you rolled: 1, 1, 1, 1, 1");
    }

    public void displayedScore() {
        assertEquals(consoleOutput.getLastLine(), "your score: 0");
    }

    public void gameIsOver() {
        assertTrue(game.isFinished());
    }

    public void promptedPlayerForCategory() {
        assertEquals(consoleOutput.getLastLine(), "enter scoring category");
    }

    public void receivedCategory(ScoreCategory category) {
        throw new IllegalStateException("not implemented");
    }
}
