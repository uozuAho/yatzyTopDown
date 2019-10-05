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
        game.displayedRollAndPromptedUserForCategory();
        player.willEnterCategory(ScoreCategory.CHANCE);
        game.receivedCategory(ScoreCategory.CHANCE);
        game.displayedScore();
        game.gameIsOver();
    }
}
