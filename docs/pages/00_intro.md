---
layout: page
title:  "Introduction"
date:   2019-12-03 21:36:19 +1100
nav_order: 1
---

# Introduction

This project is an exercise in practicing the top-down or "London School" 
test-driven development (TDD) techniques advocated by
[Growing Object-Oriented Software Guided by Tests][1]. I'll refer to that text
as the 'TDD book' from now on.

# The app

The required app is a console based [Yahtzee][2] game. In short, this is a
game where a player repeatedly rolls 5 dice, then chooses a particular scoring
'category' to score each dice roll. Once all the categories are chosen, the game
is over.

To reduce the time I spent on this, only some of the game features and rules
will be implemented:

![end goal](./img/01_end_goal.jpg)

The requirements:

- single player
- console/text based
- on each turn, the player can either choose a score category, or re-roll
- the player can re-roll all dice up to 3 times per turn
- once a category has been chosen, it cannot be chosen again
- the game finishes when all categories have been chosen


[1]: http://www.growing-object-oriented-software.com/
[2]: https://en.wikipedia.org/wiki/Yahtzee