package aho.uozu;

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
        game.displayedScore();
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
        game.displayedScore();
        game.gameIsOver();
    }
}
