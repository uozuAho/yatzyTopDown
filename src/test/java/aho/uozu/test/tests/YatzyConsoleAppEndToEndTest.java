package aho.uozu.test.tests;

import aho.uozu.DiceRoll;
import aho.uozu.ScoreCategory;
import aho.uozu.ScoreCategoryWithScore;
import aho.uozu.test.ConstantDiceRoller;
import aho.uozu.test.TextInputMock;
import aho.uozu.test.YatzyConsoleAppRunner;
import org.junit.Test;

public class YatzyConsoleAppEndToEndTest
{
    @Test
    public void shouldScoreOneCategoryThenFinish()
    {
        var playerInput = new TextInputMock();
        playerInput.addInputLine("chance");
        final var constantRoll = new DiceRoll(new int[] {1, 1, 1, 1, 1});
        var diceRoller = new ConstantDiceRoller(constantRoll);

        var game = new YatzyConsoleAppRunner(playerInput, diceRoller);

        game.start();
        game.displayedRoll(constantRoll);
        game.displayedAvailableCategories(new ScoreCategoryWithScore[] {
                new ScoreCategoryWithScore(ScoreCategory.CHANCE, 5),
                new ScoreCategoryWithScore(ScoreCategory.YATZY, 50)
        });
        game.promptedUserForCategory();
        game.displayedScore(5);
        game.gameIsOver();
    }

    @Test
    public void whenPlayerChoosesYatzy_shouldGetYatzyScore()
    {
        var playerInput = new TextInputMock();
        playerInput.addInputLine("yatzy");
        final var constantRoll = new DiceRoll(new int[] {3, 3, 3, 3, 3});
        var diceRoller = new ConstantDiceRoller(constantRoll);

        var game = new YatzyConsoleAppRunner(playerInput, diceRoller);

        game.start();
        game.displayedRoll(constantRoll);
        game.displayedAvailableCategories(new ScoreCategoryWithScore[] {
                new ScoreCategoryWithScore(ScoreCategory.CHANCE, 15),
                new ScoreCategoryWithScore(ScoreCategory.YATZY, 50)
        });
        game.promptedUserForCategory();
        game.displayedScore(50);
        game.gameIsOver();
    }
}
