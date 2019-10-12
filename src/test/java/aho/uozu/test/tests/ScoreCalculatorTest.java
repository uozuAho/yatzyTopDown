package aho.uozu.test.tests;

import aho.uozu.Roll;
import aho.uozu.ScoreCalculator;
import aho.uozu.ScoreCategory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ScoreCalculatorTest {

    private ScoreCalculator _scoreCalculator;
    private Roll _roll;
    private ScoreCategory _category;
    private int _expectedScore;

    @Parameterized.Parameters(name = "score({0}, {1}) = {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                // chance
                { new Roll(new int[] {1, 1, 1, 1, 1}), ScoreCategory.CHANCE, 5 },
                { new Roll(new int[] {1, 2, 3, 4, 5}), ScoreCategory.CHANCE, 15 },

                // yatzy
                { new Roll(new int[] {1, 1, 1, 1, 1}), ScoreCategory.YATZY, 50 },
                { new Roll(new int[] {1, 1, 1, 1, 2}), ScoreCategory.YATZY, 0 },
                { new Roll(new int[] {2, 2, 2, 2, 2}), ScoreCategory.YATZY, 50 },
        });
    }

    public ScoreCalculatorTest(Roll input, ScoreCategory category, int expectedScore) {
        _roll = input;
        _category = category;
        _expectedScore = expectedScore;
    }

    @Before
    public void setup() {
        _scoreCalculator = new ScoreCalculator();
    }

    @Test
    public void test() {
        var score = _scoreCalculator.calculateScore(_roll, _category);
        assertThat(_expectedScore, is(equalTo(score)));
    }
}
