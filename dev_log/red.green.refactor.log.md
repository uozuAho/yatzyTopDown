# Walking skeleton

<h2 style="color: white; background: red">RED</h2>

End-to-end test:

```java
@Test
public void shouldAnswerWithTrue()
{
    var game = new YatzyConsoleAppRunner();
    game.start();
    game.displaysRoll();
    game.playerChoosesCategory(ScoreCategory.CHANCE);
    game.displaysScore();
    game.isFinished();
}
```

<h2 style="color: white; background: green">GREEN</h2>

End-to-end test:

```java
@Test
public void shouldScoreOneCategoryThenFinish()
{
    var input = new ConsoleInputMock();
    var game = new YatzyConsoleAppRunner(input);
    input.addInputLine("chance");
    game.start();
    game.displayedRollAndPromptedUserForCategory();
    game.displayedScore();
    game.gameIsOver();
}
```

Implementation:

![](./svg/walking_skeleton_green.svg)

<h2 style="color: black; background: yellow">REFACTOR</h2>

Test:

```java
@Test
public void shouldScoreOneCategoryThenFinish()
{
    var input = new TextInputMock();
    var game = new YatzyConsoleAppRunner(input);
    input.addInputLine("chance");
    game.start();
    game.displayedRoll();
    game.promptedUserForCategory();
    game.displayedScore();
    game.gameIsOver();
}
```

Implementation:

![](./svg/walking_skeleton_refactored_diff.svg)

# Add dice

<h2 style="color: white; background: red">RED</h2>

End-to-end test:

```java
@Test
public void shouldScoreOneCategoryThenFinish()
{
    var input = new TextInputMock();
    var game = new YatzyConsoleAppRunner(input);
    input.addInputLine("chance");
    game.start();
    var nextDiceRoll = new Roll(new int[] {1, 1, 1, 1, 1}); // <-- added
    game.rollDice(nextDiceRoll);                            // <-- added
    game.displayedRoll(nextDiceRoll);                       // <-- added
    game.promptedUserForCategory();
    game.displayedScore(5);                                 // <-- added expected score
    game.gameIsOver();
}
```

Another e2e test:

```java
@Test
public void withADifferentRoll_shouldScoreOneCategoryThenFinish()
{
    var input = new TextInputMock();
    var game = new YatzyConsoleAppRunner(input);
    input.addInputLine("chance");
    game.start();
    var nextDiceRoll = new Roll(new int[] {2, 2, 2, 2, 2}); // <-- different roll
    game.rollDice(nextDiceRoll);
    game.displayedRoll(nextDiceRoll);
    game.promptedUserForCategory();
    game.displayedScore(10);                                // <-- different expected score
    game.gameIsOver();
}
```