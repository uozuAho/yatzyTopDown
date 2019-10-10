package aho.uozu;

import org.junit.Test;

public class YatzyConsoleAppEndToEndTest
{
    @Test
    public void shouldScoreOneCategoryThenFinish()
    {
        var input = new TextInputMock();
        input.addInputLine("chance");
        var diceRoller = new DiceRollerMock();
        var nextDiceRoll = new Roll(new int[] {1, 1, 1, 1, 1});
        diceRoller.setNextRoll(nextDiceRoll);

        var game = new YatzyConsoleAppRunner(input, diceRoller);

        game.start();
        game.displayedRoll(nextDiceRoll);
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
        var diceRoller = new DiceRollerMock();
        var nextDiceRoll = new Roll(new int[] {2, 2, 2, 2, 2});
        diceRoller.setNextRoll(nextDiceRoll);

        var game = new YatzyConsoleAppRunner(input, diceRoller);

        game.start();
        game.displayedRoll(nextDiceRoll);
        game.promptedUserForCategory();
        // todo: can we make it clearer that input was received here?
        game.displayedScore();
        game.gameIsOver();
    }
}
