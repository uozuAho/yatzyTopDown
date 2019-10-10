package aho.uozu;

import org.junit.Test;

public class YatzyConsoleAppEndToEndTest
{
    @Test
    public void shouldScoreOneCategoryThenFinish()
    {
        var input = new TextInputMock();
        var game = new YatzyConsoleAppRunner(input);
        input.addInputLine("chance");
        game.start();
        var nextDiceRoll = new Roll(new int[] {1, 1, 1, 1, 1});
        game.rollDice(nextDiceRoll);
        game.displayedRoll(nextDiceRoll);
        game.promptedUserForCategory();
        // todo: can we make it clearer that input was received here?
        game.displayedScore(5);
        game.gameIsOver();
    }
}
