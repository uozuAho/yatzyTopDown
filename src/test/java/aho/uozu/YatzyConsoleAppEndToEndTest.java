package aho.uozu;

import org.junit.Test;

public class YatzyConsoleAppEndToEndTest
{
    @Test
    public void shouldScoreOneCategoryThenFinish()
    {
        var input = new TextInputMock();
        var game = new YatzyConsoleAppRunner(input);
        input.addInputLine("chance");
        game.start();
        game.displayedRoll();
        game.promptedUserForCategory();
        // todo: can we make it clearer that input was received here?
        game.displayedScore();
        game.gameIsOver();
    }
}
