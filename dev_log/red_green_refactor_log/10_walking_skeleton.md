# Feature: Walking skeleton

<h2 style="color: white; background: red">RED</h2>

`git tag: walking_skeleton_red`

End-to-end test:

```java
@Test
public void shouldScoreOneCategoryThenFinish()
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

`git tag: walking_skeleton_green`

End-to-end test:

```java
@Test
public void shouldScoreOneCategoryThenFinish()
{
    var input = new ConsoleInputMock(); // <-- needed way of injecting user input
    var game = new YatzyConsoleAppRunner(input);
    input.addInputLine("chance");       // <-- user input must be set up before game.start()
    game.start();
    game.displayedRollAndPromptedUserForCategory();
    game.displayedScore();
    game.gameIsOver();
}
```

Implementation:

![](../svg/walking_skeleton_green.svg)

<h2 style="color: black; background: yellow">REFACTOR</h2>

`git tag: walking_skeleton_refactored`

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

![](../svg/walking_skeleton_refactored_copy.svg)
