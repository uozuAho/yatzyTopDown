package aho.uozu.test.tests.score_calculators;

import aho.uozu.score_calculators.ChanceScoreCalculator;
import aho.uozu.DiceRoll;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(Parameterized.class)
public class ChanceScoreCalculatorTest {

    private ChanceScoreCalculator _scoreCalculator;
    private DiceRoll _roll;
    private int _expectedScore;

    @Parameterized.Parameters(name = "score({0}) = {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new DiceRoll(new int[] {1, 1, 1, 1, 1}), 5 },
                { new DiceRoll(new int[] {1, 2, 3, 4, 5}), 15 },
        });
    }

    public ChanceScoreCalculatorTest(DiceRoll input, int expectedScore) {
        _roll = input;
        _expectedScore = expectedScore;
    }

    @Before
    public void setup() {
        _scoreCalculator = new ChanceScoreCalculator();
    }

    @Test
    public void test() {
        var score = _scoreCalculator.calculateScore(_roll);
        assertThat(_expectedScore, is(equalTo(score)));
    }
}

