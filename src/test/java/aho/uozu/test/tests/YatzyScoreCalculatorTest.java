package aho.uozu.test.tests;

import aho.uozu.Roll;
import aho.uozu.ScoreCalculator;
import aho.uozu.YatzyScoreCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class YatzyScoreCalculatorTest {

    private YatzyScoreCalculator _scoreCalculator;
    private Roll _roll;
    private int _expectedScore;

    @Parameterized.Parameters(name = "score({0}) = {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new Roll(new int[] {1, 1, 1, 1, 1}), 50 },
                { new Roll(new int[] {1, 1, 1, 1, 2}), 0 },
                { new Roll(new int[] {2, 2, 2, 2, 2}), 50 },
        });
    }

    public YatzyScoreCalculatorTest(Roll input, int expectedScore) {
        _roll = input;
        _expectedScore = expectedScore;
    }

    @Before
    public void setup() {
        _scoreCalculator = new YatzyScoreCalculator();
    }

    @Test
    public void test() {
        var score = _scoreCalculator.calculateScore(_roll);
        assertThat(_expectedScore, is(equalTo(score)));
    }
}

