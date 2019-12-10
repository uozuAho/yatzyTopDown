---
layout: page
title:  "The walking skeleton"
date:   2019-12-03 21:36:19 +1100
categories: test
nav_order: 10
---

# The walking skeleton

The first step in the process is to find a minimal subset of the given
requirements and implement them, so that the development feedback loop can
begin. The [TDD book][1] authors refer to this as a 'walking skeleton'. It
serves a number of purposes:

- to start the development feedback loop
    - the working application and end-to-end test provide two avenues for
      feedback
- to start integrating with dependent systems as soon as possible, to identify
  any unknowns / incompatibilities etc.
- to have something to put in your CI/CD pipeline, so that you can get that set
  up

For my walking skeleton, I came up with these initial requirements:

![end goal](./img/02_skeleton.jpg)

- The game displays the dice roll to the player
- The player chooses a category
- The game displays a score
- The game ends

## The first test

Before we add any functionality, we write an end-to-end test. My first test
ended up looking like this:

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

This test is quite different to the tests that I'm used to reading. The
assertions are hidden away in the `YatzyConsoleAppRunner`. As a result, the test
essentially reads as a list of steps in the game.

After a lot more effort than expected, I ended up with this:

![skeleton implementation](./img/02_skeleton_e2e_plus_runner.png)

- **todo:** There was some refactoring in here. Document if it fits.
- **note:** At this point in development, I hadn't checked the correct spelling
            of Yahtzee :facepalm:

Not pictured, but also included:

- maven config that runs tests & builds the package
- a script to run the game
- a readme documenting how to run the game and run the tests

git tag: `02_better_skeleton`


[1]: http://www.growing-object-oriented-software.com/
