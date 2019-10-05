package aho.uozu;

import org.junit.Test;

public class YatzyConsoleAppEndToEndTest
{
    @Test
    public void shouldScoreOneCategoryThenFinish()
    {
        var player = new PlayerMock();
        var game = new YatzyConsoleAppRunner(player);
        game.start();
        game.displaysRoll();
        player.willEnterCategory(ScoreCategory.CHANCE);
        game.promptsPlayerForCategory();
        game.receivedCategory(ScoreCategory.CHANCE);
        game.displaysScore();
        game.gameIsOver();
    }
}
