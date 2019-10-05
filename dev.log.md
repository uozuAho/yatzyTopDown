# Yatzy top down TDD development log

- sketched an end goal: a playable yatzy console app
- sketched a "walking skeleton" (working? walking?)
- wrote and skeleton e2e test, started implementing required classes
- made tests and game runnable from console

At this point, I realised that the game doesn't work from the console.
The end to end test passes, but it isn't really end to end - it doesn't
run the application destined to be deployed to users' machines. To do this,
I think I'd need an over-elaborate way to fake console IO. I can't be
bothered figuring out how I'd do this, so I'll stick to running the
YatzyConsoleApp class. I note at this point that I'm not really doing this.
Most of the e2e test actions don't interact with the game. To make the e2e
test closer to the 'end', I should run the YatzyConsoleApp class via its
main() method.

Hmm "do the simplest thing that will pass the test" seems like the wrong
strategy when writing the skeleton. I've made the skeleton e2e test pass by
doing the simplest thing - putting all the expected console output directly
in the mock console output. I think this is defeating the purpose of the
skeleton, which is to hook up a minimal working set of _real_ application
classes. So for now I'll add a constraint that the "simplest thing" must be
done with real application classes, not mocks :)
