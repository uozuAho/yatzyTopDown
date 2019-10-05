package aho.uozu;

import static org.junit.Assert.assertEquals;

public class YatzyConsoleAppRunner {
    private YatzyConsoleApp game;
    private ConsoleOutputMock consoleOutput;

    public void start() {
        consoleOutput = new ConsoleOutputMock();
        game = new YatzyConsoleApp(consoleOutput);
    }

    public void displaysRoll() {
        assertEquals(consoleOutput.getOutputLines()[0], "you rolled: 1, 1, 1, 1, 1");
    }

    public void playerChoosesCategory(ScoreCategory category) {
    }

    public void displaysScore() {
        assertEquals(consoleOutput.getOutputLines()[1], "your score: 0");
    }

    public void isFinished() {
        throw new IllegalStateException("not implemented");
    }
}
