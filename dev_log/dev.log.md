# Yatzy top down TDD development log

sketched an end goal: a playable yatzy console app:

![end goal](./img/01_end_goal.jpg)

sketched a "walking skeleton" (working? walking?):

![end goal](./img/02_skeleton.jpg)

- wrote and skeleton e2e test, started implementing required classes
- made tests and game runnable from console

## A non-functional skeleton :(

git tag: `01_skeleton`

At this point, I realised that the game doesn't work from the console.
The end to end test passes, but it isn't really end to end - it doesn't
run the application destined to be deployed to users' machines. To do this,
I think I'd need an over-elaborate way to fake console IO. I can't be
bothered figuring out how I'd do this, so I'll stick to running the
YatzyConsoleApp class. I note at this point that I'm not really doing this.
Most of the e2e test actions don't interact with the game. To make the e2e
test closer to the 'end', I should run the YatzyConsoleApp class via its
main() method.

The "do the simplest thing that will pass the test" strategy seems wrong
when writing the skeleton. I've made the skeleton e2e test pass by doing
the simplest thing - putting all the expected console output directly in
the mock console output. I think this is defeating the purpose of the
skeleton, which is to hook up a minimal working set of _real_ application
classes. So for now I'll add a constraint that the "simplest thing" must be
done with real application classes, not mocks :)

git commit: `a705451`

Well it's been 3h, and I still don't have a working console app! The TDD book
guys express the constant surprise at how long the skeleton step takes, so that
gives me some comfort. They also mention that the example in their book went
through many revisions - they didn't have all the right design insights the first
time through the exercise.

I've been a bit stuck on how to supply console input from the player in the tests,
so I drew how I think it should work, which helped me design the interfaces:

![end goal](./img/03_console_ui.jpg)

----

## A better skeleton

git commit: `3bcb501`

Now the console app behaves as the e2e test describes, but the whole thing is a bit
ugly. I think it's time for some refactoring to make things clearer.

git tag: `02_better_skeleton`

The e2e test reads reasonably well, and the console app behaves accordingly. There's
a few things that aren't quite right, like, where's the dice? However, this is a
decent skeleton. We can mock input/output, and the app runs as expected. Let's
figure out the next slice next time.


## Next slice: add dice, show correct score

I added a dice roll and an expected score to the e2e test. The test failed.
All I had to do to get it to pass was to change the canned output coming from
YatzyConsoleApp. That feels like cheating. Let's add another test to prevent
that cheating!


# todo

- reduce visibility of classes/methods