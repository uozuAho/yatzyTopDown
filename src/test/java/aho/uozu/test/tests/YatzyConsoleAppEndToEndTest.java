package aho.uozu.test.tests;

import aho.uozu.Roll;
import aho.uozu.test.ConstantDiceRoller;
import aho.uozu.test.TextInputMock;
import aho.uozu.test.YatzyConsoleAppRunner;
import org.junit.Test;

public class YatzyConsoleAppEndToEndTest
{
    @Test
    public void shouldScoreOneCategoryThenFinish()
    {
        var input = new TextInputMock();
        input.addInputLine("chance");
        final var constantRoll = new Roll(new int[] {1, 1, 1, 1, 1});
        var diceRoller = new ConstantDiceRoller(constantRoll);

        var game = new YatzyConsoleAppRunner(input, diceRoller);

        game.start();
        game.displayedRoll(constantRoll);
        game.promptedUserForCategory();
        // todo: can we make it clearer that input was received here?
        game.displayedScore(5);
        game.gameIsOver();
    }

    @Test
    public void withADifferentRoll_shouldScoreOneCategoryThenFinish()
    {
        var input = new TextInputMock();
        input.addInputLine("chance");
        final var constantRoll = new Roll(new int[] {2, 2, 2, 2, 2});
        var diceRoller = new ConstantDiceRoller(constantRoll);

        var game = new YatzyConsoleAppRunner(input, diceRoller);

        game.start();
        game.displayedRoll(constantRoll);
        game.promptedUserForCategory();
        // todo: can we make it clearer that input was received here?
        game.displayedScore(10);
        game.gameIsOver();
    }
}
