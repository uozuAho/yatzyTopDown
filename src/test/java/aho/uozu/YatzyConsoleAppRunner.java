package aho.uozu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class YatzyConsoleAppRunner {
    private YatzyConsoleApp game;
    private ConsoleOutputMock consoleOutput;

    public void start() {
        consoleOutput = new ConsoleOutputMock();
        game = new YatzyConsoleApp(consoleOutput);
    }

    public void displaysRoll() {
        assertEquals(consoleOutput.getOutputLine(0), "you rolled: 1, 1, 1, 1, 1");
    }

    public void playerChoosesCategory(ScoreCategory category) {
    }

    public void displaysScore() {
        assertEquals(consoleOutput.getOutputLine(1), "your score: 0");
    }

    public void gameIsOver() {
        assertTrue(game.isFinished());
    }
}
