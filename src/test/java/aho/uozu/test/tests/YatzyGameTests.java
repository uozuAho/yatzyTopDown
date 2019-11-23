package aho.uozu.test.tests;

import aho.uozu.*;
import aho.uozu.score_calculators.ScoreCalculator;
import aho.uozu.score_calculators.ScoreCalculatorFactory;
import aho.uozu.test.ConstantDiceRoller;
import aho.uozu.test.ConstantScoreCalculator;
import aho.uozu.test.MockScoreCalculatorFactory;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class YatzyGameTests {
    @Rule
    public final JUnitRuleMockery context = new JUnitRuleMockery();

    final int chanceScore = 3;
    final int yatzyScore = 4;
    private final DiceRoller diceRoller = new ConstantDiceRoller(new DiceRoll(new int[] {1, 1, 1, 1, 1}));
    private final ScoreCalculator chanceCalculator = new ConstantScoreCalculator(chanceScore);
    private final ScoreCalculator yatzyCalculator = new ConstantScoreCalculator(yatzyScore);
    private final ScoreCalculatorFactory scoreCalculatorFactory = new MockScoreCalculatorFactory(
            Map.ofEntries(
                    Map.entry(ScoreCategory.CHANCE, chanceCalculator),
                    Map.entry(ScoreCategory.YATZY, yatzyCalculator)
            )
    );
    private final YatzyPlayerInterface playerInterface = context.mock(YatzyPlayerInterface.class);

    private final YatzyGame game = new YatzyGame(diceRoller, scoreCalculatorFactory, playerInterface);

    @Test
    public void shouldOutputCorrectScoreWithCategories() {
        context.checking(new Expectations() {{
            // todo: ignore this?
            allowing(playerInterface).showPlayerRolled(with(any(DiceRoll.class)));

            oneOf(playerInterface).promptForCategoryOrReRoll(); will(returnValue(new PlayerInput(PlayerInputType.ScoreCategory, ScoreCategory.CHANCE)));

            // todo: ignore this?
            allowing(playerInterface).showPlayerScore(with(any(int.class)));

            oneOf(playerInterface).showAvailableCategories(with(
                    new AvailableCategoriesMatcher(
                            new ScoreCategoryWithScore(ScoreCategory.CHANCE, chanceScore),
                            new ScoreCategoryWithScore(ScoreCategory.YATZY, yatzyScore))
            ));
        }});

        game.runNextPlayerTurn();
    }

    // surely there's a more succint way of doing this?!?!?!??!!1
    private class AvailableCategoriesMatcher extends TypeSafeMatcher<List<ScoreCategoryWithScore>> {

        private final List<ScoreCategoryWithScore> _expectedCategoriesWithScores;

        public AvailableCategoriesMatcher(ScoreCategoryWithScore... scoreCategoryWithScores) {
            _expectedCategoriesWithScores = Arrays.asList(scoreCategoryWithScores);
        }

        @Override
        protected boolean matchesSafely(List<ScoreCategoryWithScore> scoreCats) {
            for (var scoreCat : scoreCats) {
                var matchingScoreCats = _expectedCategoriesWithScores.stream().filter(
                        s -> s.category == scoreCat.category && s.score == scoreCat.score
                ).collect(Collectors.toList());
                if (matchingScoreCats.size() != 1) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public void describeTo(Description description) {}
    }
}
