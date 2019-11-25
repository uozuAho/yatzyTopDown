package aho.uozu.test.tests;

import aho.uozu.ScoreCategory;
import aho.uozu.YatzyConsolePlayerInterface;
import aho.uozu.test.TextInputMock;
import aho.uozu.test.TextOutputMock;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class YatzyConsoleInterfaceTests {
    @Test
    public void shouldRepromptUntilAvailableCategoryIsChosen() {
        var textOutput = new TextOutputMock();
        var textInput = new TextInputMock();
        var consoleInterface = new YatzyConsolePlayerInterface(textOutput, textInput);
        textInput.enqueueLine(ScoreCategory.CHANCE.toString());
        textInput.enqueueLine(ScoreCategory.YATZY.toString());

        var input = consoleInterface.promptForCategory(ScoreCategory.YATZY);

        assertThat(input.value, is(equalTo(ScoreCategory.YATZY)));
    }
}
