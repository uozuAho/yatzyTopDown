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
        game.displayedRollAndPromptedUserForCategory();
        game.displayedScore();
        game.gameIsOver();
    }
}
