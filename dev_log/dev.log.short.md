# Yahtzee top down TDD - a short development log

This is a cut down version of my original development log. It's intended to be a
precursor to a publish-able top-down TDD exercise.

This project is an exercise in practicing the top-down or "London School" test-driven
development (TDD) techniques advocated by [Growing Object-Oriented Software Guided by Tests][TDD book].
I'll refer to that text as the 'TDD book' from now on.


# The software

The required software is a console based [Yahtzee][Yahtzee] game. To reduce the time
I spent on this, only some of the game features and rules will be implemented:

![end goal](./img/01_end_goal.jpg)

The requirements:

- single player
- console/text based
- each turn, the player can either choose a score category, or re-roll
- the player can re-roll all dice up to 3 times per turn
- once a category has been chosen, it cannot be chosen again
- the game finishes when all categories have been chosen


# Getting started - building a 'walking skeleton'

The first step in the process is to find a minimal subset of the given requirements and
implement them, so that the development feedback loop can begin. The [TDD book]
authors refer to this as a 'walking skeleton'. It serves a number of purposes:

- to start the development feedback loop
    - the working application and end-to-end test provide two avenues for feedback
- to start integrating with dependent systems as soon as possible, to identify
  any unknowns / incompatibilities etc.

My Yahtzee walking skeleton will be:

- the smallest possible set of requirements
- a playable console application that fulfils the requirements
- an end-to-end test that verifies the application is correct

For the above, I came up with these initial requirements:

![end goal](./img/02_skeleton.jpg)

- The game displays the dice roll to the player
- The player chooses a category
- The game displays a score
- The game ends



# References

[Growing Object-Oriented Software Guided by Tests][tdd book]

[TDD book]: http://www.growing-object-oriented-software.com/
[Yahtzee]: https://en.wikipedia.org/wiki/Yahtzee