package aho.uozu;

import org.junit.Test;

public class YatzyConsoleAppEndToEndTest
{
    @Test
    public void shouldAnswerWithTrue()
    {
        var game = new YatzyConsoleAppRunner();
        game.start();
        game.displaysRoll();
        game.playerChoosesCategory(ScoreCategory.CHANCE);
        game.displaysScore();
        game.gameIsOver();
    }
}
