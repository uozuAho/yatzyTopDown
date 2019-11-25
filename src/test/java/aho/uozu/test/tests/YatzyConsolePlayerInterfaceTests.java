package aho.uozu.test.tests;

import aho.uozu.PlayerInputType;
import aho.uozu.ScoreCategory;
import aho.uozu.YatzyConsolePlayerInterface;
import aho.uozu.test.TextInputMock;
import aho.uozu.test.TextOutputMock;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class YatzyConsolePlayerInterfaceTests {
    private Collection<ScoreCategory> _allCategoriesAvailable = Arrays.asList(ScoreCategory.all());

    @Test
    @Parameters({"chance", "CHANCE  ", "   ChaNCE"})
    public void validCategoryInputChance(String input) {
        var textInput = new TextInputMock();
        textInput.enqueueLine(input);
        var playerInterface = new YatzyConsolePlayerInterface(new TextOutputMock(), textInput);

        var playerInput = playerInterface.promptForCategoryOrReRoll(_allCategoriesAvailable);

        assertThat(playerInput.type, is(equalTo(PlayerInputType.ScoreCategory)));
        assertThat(playerInput.value, is(equalTo(ScoreCategory.CHANCE)));
    }

    @Test
    @Parameters({"yatzy", "YATZY", "YAtzy    "})
    public void validCategoryInputYatzy(String input) {
        var textInput = new TextInputMock();
        textInput.enqueueLine(input);
        var playerInterface = new YatzyConsolePlayerInterface(new TextOutputMock(), textInput);

        var playerInput = playerInterface.promptForCategoryOrReRoll(_allCategoriesAvailable);

        assertThat(playerInput.type, is(equalTo(PlayerInputType.ScoreCategory)));
        assertThat(playerInput.value, is(equalTo(ScoreCategory.YATZY)));
    }

    @Test
    public void shouldReturnReroll() {
        var textInput = new TextInputMock();
        textInput.enqueueLine("reroll");
        var playerInterface = new YatzyConsolePlayerInterface(new TextOutputMock(), textInput);

        var playerInput = playerInterface.promptForCategoryOrReRoll(_allCategoriesAvailable);

        assertThat(playerInput.type, is(equalTo(PlayerInputType.ReRoll)));
    }

    @Test
    public void shouldRepromptUntilGoodInput() {
        var textInput = new TextInputMock();
        textInput.enqueueLine("garbage!!!");
        textInput.enqueueLine("garbage!!!");
        textInput.enqueueLine(ScoreCategory.CHANCE.toString());
        var playerInterface = new YatzyConsolePlayerInterface(new TextOutputMock(), textInput);

        var input = playerInterface.promptForCategoryOrReRoll(_allCategoriesAvailable);

        assertThat(input.value, is(equalTo(ScoreCategory.CHANCE)));
    }

    @Test
    public void promptForCategoryShouldRepromptOnReroll() {
        var textInput = new TextInputMock();
        textInput.enqueueLine("reroll");
        textInput.enqueueLine(ScoreCategory.CHANCE.toString());
        var playerInterface = new YatzyConsolePlayerInterface(new TextOutputMock(), textInput);

        var input = playerInterface.promptForCategory(_allCategoriesAvailable);

        assertThat(input.value, is(equalTo(ScoreCategory.CHANCE)));
    }

    @Test
    public void shouldRepromptUntilAvailableCategoryIsChosen() {
        var textOutput = new TextOutputMock();
        var textInput = new TextInputMock();
        var consoleInterface = new YatzyConsolePlayerInterface(textOutput, textInput);
        textInput.enqueueLine(ScoreCategory.CHANCE.toString());
        textInput.enqueueLine(ScoreCategory.CHANCE.toString());
        textInput.enqueueLine(ScoreCategory.YATZY.toString());

        var input = consoleInterface.promptForCategory(Collections.singletonList(ScoreCategory.YATZY));

        assertThat(input.value, is(equalTo(ScoreCategory.YATZY)));
    }
}
