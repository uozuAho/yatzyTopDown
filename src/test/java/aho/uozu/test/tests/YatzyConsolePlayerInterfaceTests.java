package aho.uozu.test.tests;

import aho.uozu.ScoreCategory;
import aho.uozu.YatzyConsolePlayerInterface;
import aho.uozu.test.TextInputMock;
import aho.uozu.test.TextOutputMock;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class YatzyConsolePlayerInterfaceTests {
    @Test
    @Parameters({"chance", "CHANCE  ", "   ChaNCE"})
    public void validCategoryInputChance(String input) {
        var textInput = new TextInputMock();
        textInput.addInputLine(input);
        var playerInterface = new YatzyConsolePlayerInterface(new TextOutputMock(), textInput);

        var category = playerInterface.promptForCategoryInput();

        assertThat(category, is(equalTo(ScoreCategory.CHANCE)));
    }

    @Test
    @Parameters({"yatzy", "YATZY", "YAtzy    "})
    public void validCategoryInputYatzy(String input) {
        var textInput = new TextInputMock();
        textInput.addInputLine(input);
        var playerInterface = new YatzyConsolePlayerInterface(new TextOutputMock(), textInput);

        var category = playerInterface.promptForCategoryInput();

        assertThat(category, is(equalTo(ScoreCategory.YATZY)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidCategoryInputShouldThrow() {
        var textInput = new TextInputMock();
        textInput.addInputLine("garbage!!!");
        var playerInterface = new YatzyConsolePlayerInterface(new TextOutputMock(), textInput);

        playerInterface.promptForCategoryInput();
    }
}
