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
        game.displayedRoll();
        player.willEnterCategory(ScoreCategory.CHANCE);
        game.promptedPlayerForCategory();
        game.receivedCategory(ScoreCategory.CHANCE);
        game.displayedScore();
        game.gameIsOver();
    }
}
