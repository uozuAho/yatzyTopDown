package aho.uozu.test.tests;

import aho.uozu.DiceRoll;
import aho.uozu.ScoreCategory;
import aho.uozu.ScoreCategoryWithScore;
import aho.uozu.test.ConstantDiceRoller;
import aho.uozu.test.YatzyConsoleAppRunner;
import org.junit.Test;

public class YatzyConsoleAppEndToEndTest
{
    @Test
    public void gameShouldContinueUntilAllCategoriesAreChosen()
    {
        final var constantRoll = new DiceRoll(new int[] {1, 1, 1, 1, 1});
        var diceRoller = new ConstantDiceRoller(constantRoll);
        var player = new YatzyPlayerMock();

        player.addNextInput(ScoreCategory.CHANCE);
        player.addNextInput(ScoreCategory.YATZY);

        var game = new YatzyConsoleAppRunner(player.textInput(), diceRoller);
        game.run();

        // turn 1
        game.displayedRoll(constantRoll);
        game.displayedAvailableCategories(new ScoreCategoryWithScore[] {
                new ScoreCategoryWithScore(ScoreCategory.CHANCE, 5),
                new ScoreCategoryWithScore(ScoreCategory.YATZY, 50)
        });
        game.promptedUserForCategory();
        game.displayedScore(5);

        // turn 2
        game.displayedRoll(constantRoll);
        game.displayedAvailableCategories(new ScoreCategoryWithScore[] {
                new ScoreCategoryWithScore(ScoreCategory.YATZY, 50)
        });
        game.promptedUserForCategory();
        game.displayedScore(50);

        game.gameIsOver();
    }
}
