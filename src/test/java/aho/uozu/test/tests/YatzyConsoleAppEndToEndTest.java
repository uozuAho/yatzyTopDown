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
        final var chanceScore = 5;
        final var yatzyScore = 50;

        var player = new YatzyPlayerMock();
        player.addNextInput(ScoreCategory.CHANCE);
        player.addNextInput(ScoreCategory.YATZY);

        var game = new YatzyConsoleAppRunner(player.textInput(), diceRoller);
        game.run();

        // turn 1
        game.displayedRoll(constantRoll);
        game.displayedAvailableCategoriesInAnyOrder(new ScoreCategoryWithScore[] {
                new ScoreCategoryWithScore(ScoreCategory.CHANCE, chanceScore),
                new ScoreCategoryWithScore(ScoreCategory.YATZY, yatzyScore)
        });
        game.promptedUserForCategory();
        game.displayedScore(chanceScore);

        // turn 2
        game.displayedRoll(constantRoll);
        game.displayedAvailableCategoriesInAnyOrder(new ScoreCategoryWithScore[] {
                new ScoreCategoryWithScore(ScoreCategory.YATZY, yatzyScore)
        });
        game.promptedUserForCategory();
        game.displayedScore(yatzyScore);

        game.gameIsOver();
    }
}
