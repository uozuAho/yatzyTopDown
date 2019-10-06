package aho.uozu;

import org.junit.Test;

public class YatzyConsoleAppEndToEndTest
{
    @Test
    public void shouldScoreOneCategoryThenFinish()
    {
        var player = new PlayerMock();
        var game = new YatzyConsoleAppRunner(player);
        player.willEnterCategory(ScoreCategory.CHANCE);
        game.start();
        game.displayedRollAndPromptedUserForCategory();
        game.waitForPlayerInput();
        game.receivedCategory(ScoreCategory.CHANCE);
        game.displayedScore();
        game.gameIsOver();
    }
}
