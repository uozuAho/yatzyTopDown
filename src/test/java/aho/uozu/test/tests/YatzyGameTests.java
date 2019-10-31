package aho.uozu.test.tests;

import aho.uozu.DiceRoll;
import aho.uozu.ScoreCategory;
import aho.uozu.YatzyGame;
import aho.uozu.test.ConstantDiceRoller;
import aho.uozu.test.ConstantScoreCalculator;
import aho.uozu.test.MockScoreCalculatorFactory;
import aho.uozu.test.PlayerInterfaceMock;
import org.junit.Test;

import java.util.Map;

public class YatzyGameTests {
    @Test
    public void shouldOutputCorrectScoreWithCategories() {
        final int chanceScore = 3;
        final int yatzyScore = 4;
        var diceRoller = new ConstantDiceRoller(new DiceRoll(new int[] {1, 1, 1, 1, 1}));
        var chanceCalculator = new ConstantScoreCalculator(chanceScore);
        var yatzyCalculator = new ConstantScoreCalculator(yatzyScore);
        var scoreCalculatorFactory = new MockScoreCalculatorFactory(Map.ofEntries(
                Map.entry(ScoreCategory.CHANCE, chanceCalculator),
                Map.entry(ScoreCategory.YATZY, yatzyCalculator)
        ));
        var playerInterface = new PlayerInterfaceMock();
        var game = new YatzyGame(diceRoller, scoreCalculatorFactory, playerInterface);
    }
}
