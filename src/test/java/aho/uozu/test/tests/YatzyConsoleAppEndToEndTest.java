package aho.uozu.test.tests;

import aho.uozu.DiceRoll;
import aho.uozu.ScoreCategory;
import aho.uozu.ScoreCategoryWithScore;
import aho.uozu.test.ConstantDiceRoller;
import aho.uozu.test.TextInputMock;
import aho.uozu.test.YatzyConsoleAppRunner;
import org.junit.Test;

import java.util.Collections;

public class YatzyConsoleAppEndToEndTest
{
    @Test
    public void gameShouldContinueUntilAllCategoriesAreChosen()
    {
        final var constantRoll = new DiceRoll(new int[] {1, 1, 1, 1, 1});
        var diceRoller = new ConstantDiceRoller(constantRoll);
        final var chanceScore = 5;
        final var yatzyScore = 50;
        var playerInput = new TextInputMock();

        var game = new YatzyConsoleAppRunner(playerInput, diceRoller);
        game.isNotOver();

        // turn 1
        playerInput.enqueueLine(ScoreCategory.CHANCE.toString());
        game.doNextTurn();
        game.displayedRoll(constantRoll);
        game.displayedAvailableCategoriesInAnyOrder(new ScoreCategoryWithScore[] {
                new ScoreCategoryWithScore(ScoreCategory.CHANCE, chanceScore),
                new ScoreCategoryWithScore(ScoreCategory.YATZY, yatzyScore)
        });
        game.promptedUserForCategoryOrReRoll();
        game.displayedScore(chanceScore);

        // turn 2
        playerInput.enqueueLine(ScoreCategory.YATZY.toString());
        game.doNextTurn();
        game.displayedRoll(constantRoll);
        game.displayedAvailableCategoriesInAnyOrder(new ScoreCategoryWithScore[] {
                new ScoreCategoryWithScore(ScoreCategory.YATZY, yatzyScore)
        });
        game.promptedUserForCategoryOrReRoll();
        game.displayedScore(yatzyScore);

        game.isOver();
    }

    @Test
    public void sameCategoriesAreDisplayedWhenPlayerReRolls() {
        final var constantRoll = new DiceRoll(new int[] {1, 1, 1, 1, 1});
        var diceRoller = new ConstantDiceRoller(constantRoll);
        final var chanceScore = 5;
        final var yatzyScore = 50;
        var playerInput = new TextInputMock();

        var game = new YatzyConsoleAppRunner(playerInput, diceRoller);

        playerInput.enqueueLine(
                "reroll",
                ScoreCategory.CHANCE.toString()
        );
        game.doNextTurn();
        game.displayedRoll(constantRoll);
        game.displayedAvailableCategoriesInAnyOrder(new ScoreCategoryWithScore[] {
                new ScoreCategoryWithScore(ScoreCategory.CHANCE, chanceScore),
                new ScoreCategoryWithScore(ScoreCategory.YATZY, yatzyScore)
        });
        game.promptedUserForCategoryOrReRoll();
        // player re-rolls here
        game.displayedRoll(constantRoll);
        game.displayedAvailableCategoriesInAnyOrder(new ScoreCategoryWithScore[] {
                new ScoreCategoryWithScore(ScoreCategory.CHANCE, chanceScore),
                new ScoreCategoryWithScore(ScoreCategory.YATZY, yatzyScore)
        });
        game.promptedUserForCategoryOrReRoll();
        // playerInput chooses category here
        game.displayedScore(chanceScore);
    }

    @Test
    public void playerCanOnlyReRoll3TimesInOneTurn() {
        final var constantRoll = new DiceRoll(new int[] {1, 1, 1, 1, 1});
        var diceRoller = new ConstantDiceRoller(constantRoll);
        final var chanceScore = 5;
        var playerInput = new TextInputMock();

        var game = new YatzyConsoleAppRunner(playerInput, diceRoller);

        playerInput.enqueueLine(
                "reroll",
                "reroll",
                "reroll",
                "reroll",
                ScoreCategory.CHANCE.toString()
        );

        game.doNextTurn();
        game.displayedRoll(constantRoll);
        game.displayedAvailableCategories(2);
        game.promptedUserForCategoryOrReRoll();
        // re-roll 1 here
        game.displayedRoll(constantRoll);
        game.displayedAvailableCategories(2);
        game.promptedUserForCategoryOrReRoll();
        // re-roll 2 here
        game.displayedRoll(constantRoll);
        game.displayedAvailableCategories(2);
        game.promptedUserForCategoryOrReRoll();
        // re-roll 3 here
        game.displayedRoll(constantRoll);
        game.displayedAvailableCategories(2);
        game.promptedUserForCategory();
        // re-roll attempt 4 here
        game.displayedCannotReRollMessage();
        game.displayedAvailableCategories(2);
        game.promptedUserForCategory();
        // player chooses chance here
        game.displayedScore(chanceScore);
    }

    @Test
    public void repromptWhenInputIsBad() {
        final var constantRoll = new DiceRoll(new int[]{1, 1, 1, 1, 1});
        var diceRoller = new ConstantDiceRoller(constantRoll);
        var playerInput = new TextInputMock();

        var game = new YatzyConsoleAppRunner(playerInput, diceRoller);

        playerInput.enqueueLine("bad input");
        playerInput.enqueueLine(ScoreCategory.CHANCE.toString());
        game.doNextTurn();
        game.displayedRoll(constantRoll);
        game.displayedAvailableCategories(2);
        game.promptedUserForCategoryOrReRoll();
        // bad input here
        game.displayedIncorrectInputMessage();
        game.displayedAvailableCategories(2);
        game.promptedUserForCategoryOrReRoll();
        game.displayedScore();
    }

    @Test
    public void givenUserInputsUnavailableCategory_repromptForCategory() {
        final var constantRoll = new DiceRoll(new int[]{1, 1, 1, 1, 1});
        var diceRoller = new ConstantDiceRoller(constantRoll);
        var playerInput = new TextInputMock();
        var availableCategories = Collections.singletonList(ScoreCategory.YATZY);
        var availableCategory = availableCategories.get(0);
        var unavailableCategory = ScoreCategory.CHANCE;

        var game = new YatzyConsoleAppRunner(playerInput, diceRoller, availableCategories);

        playerInput.enqueueLine(unavailableCategory.toString());
        playerInput.enqueueLine(availableCategory.toString());
        game.doNextTurn();
        game.displayedRoll(constantRoll);
        game.displayedAvailableCategories(1);
        game.promptedUserForCategoryOrReRoll();
        // player chooses unavailable category here
        game.displayedUnavailableCategoryMessage();
        game.displayedAvailableCategories(1);
        game.promptedUserForCategoryOrReRoll();
        // player chooses available category here
        game.displayedScore();
    }
}
