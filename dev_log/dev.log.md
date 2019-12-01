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


## Next slice: add dice

I added a dice roll to the e2e test. The test failed. All I had to do to get
it to pass was to change the canned output coming from YatzyConsoleApp.
That feels like cheating. Let's add another test to prevent that cheating!

I originally decided to add dice and show the correct score for this slice,
but it quickly became evident that that was too big a slice. I put the score
display in the todo list.

So I've added the ability to set the next dice roll in the game, and the roll
is correctly displayed. I did it in quite a barbaric way, and now it's time to 
refactor.

<5 minutes later>

I just checked the console app, and it fails with a null pointer exception.
So much for an 'end to end' test! I feel like I've broken some kind of rule
here though, since the code I've added to pass the test is _very_ hacky. I didn't
keep enough separation between the test and the application code.

I added DiceRoller. Now the tests are failing the same null pointer exception
as the console app. This is a good sign.

I injected DiceRoller into the game, and now the console app is working again.

I added RandomDiceRoller, which currently returns the same roll every time. I don't
really know how to test this class, as testing for randomness is prone to flakiness.
Thus, we have passing e2e tests, but the game isn't really correct. I figure this
is because we haven't implemented enough features yet, so I'll forgive that for 
now. I am a little worried though.

git tag: `03_add_dice`

OK, we have dice. Nice.


## Next slice: score based on roll

git tag: `04_score_roll`

Well that was easy. Next!


## Next slice: add a category

git tag: `05_mid_score_calc_refactoring`

Adding a category and scoring based on the given category involved some
refactoring: The ScoreCalculator interface was created, and
ScoreCalculatorFactory created to keep the responsibility of creating
calculators separate from the console app class.

![mid score refactoring](./img/05_score_calculator_factory.jpg)

I was thinking at this point: Is top-down less amenable to distributing
work amongst a team? If design is constantly emerging, and pieces of code
are being ripped apart, there's going to be a lot of merge conflicts. There
doesn't look to be anything on this in the TDD book, and a quick google
didn't show any promising results. I guess I'll just have to try it...


## Next slice: show available categories, then prompt

git tag: `06_show_categories`

Got display of available categories working nice and fast, but something's
not feeling right ... I think I need to separate YatzyGame and YatzyConsoleApp.
YatzyConsoleApp is currently running the gameplay, and dealing with sending
& receiving user io.

The rough idea is to separate the console app into a 'model' and a 'view',
like in the MVC pattern:

![extract_view](./img/06_game_view_separation.jpg)

Tune in next time.

## Refactor: extract game from console app

OK it's next time.

git commit: `39d720b`

At this point I've got a game, console app, and console interface classes.
The console app is driving the interface and updating the game. Although
this seems to fit an MVC model, it doesn't feel right. I think the game should
be deciding when to execute game operations, and prompt players for actions etc.
The controller (console app) is currently implementing a lot of the game logic
that I'd expect to find in the game.

git commit: `76e49d4`

Now console app just sets up the game class with console io. Makes more sense!
Here's a UML-ish diagram of the classes/concepts at this point:

![player_interface](./img/07_uml-ish.jpg)

Now instead of the view controlling game flow and updating the game state, the
`YatzyGame` class is now responsible for this. The game is initialised with an
interface, and uses the interface, rather than the other way around. 

![player_interface](./img/07_game_to_playerInterface.jpg)

I briefly thought that the e2e test should use the game class instead, but
that would reduce its end-to-end-iness.

I also thought about adding some unit tests for the new classes: YatzyGame,
YatzyConsolePlayerInterface. YatzyGame probably needs them, since it's implementing
the game logic. However, the logic is quite simple at the moment, and is
sufficiently covered by the end to end tests.

git tag: `07_extract_game`


## Next slice: show potential score with displayed categories

git commit: `41732488`

I tried using JMock to test output of available categories with their scores. It's
horrible. Much more verbose and hard to follow than the end to end tests. To the bin!
I haven't come to terms with the way JMock works yet... So much boilerplate...

Actually I'll keep the YatzyGameTests class for now, since I'll probably want to 
test the game class more, later, and I don't want to have to re-learn how to use JMock.


## Next slice: game continues until player has chosen all categories

git commit: `1ffe5a2`

Rewrote the e2e test to run until all categories have been selected by the player.
This breaks the game unit test. Rather than fixing that test, it seems more useful
to be able to step the game through from the outside, rather than having it run the
entire game in a closed manner.


## Next slice: player can re-roll dice

Done. That was pretty easy. I didn't bother implementing re-rolling specific dies.

## Next slice: maximum 3 re-rolls

git commit: `49d0186`

Done. Didn't bother refactoring...

## Next slice: handle bad input

git commit: `c89fb2a`

I wrote a unit test for handling unavailable categories, which passed, but then
the console game still allowed it! It's a pretty suitable test for an e2e test
too. I haven't figured out a good rule for where tests should live yet. Testing
multiple permutations seems unit-y. Maybe everything else should be as high as
possible without impeding test times?

git commit: `6f6c368`

I fixed the bug and added a unit test to cover the gap. The e2e test fails since
the listing of available categories doesn't happen on a re-prompt. I'm not sure
who's responsibility this should be - YatzyGame or the player interface. I'm thinking
it should be the interface...

git commit: `e206c11`

I put the re-prompt behaviour in the player interface. This means the game has
to pass more information to the player interface - the available categories and
their associated scores. I think this is OK, since other interfaces such as GUIs
wouldn't have the issue of a player entering incorrect commands/categories, so
it's more of a user interface concern.

The two methods doing re-prompting for correct input in `YatzyConsolePlayerInterface`
stink of duplication, but I couldn't find a satisfactory way to remove that duplication
without creating the same or many more lines of code. If there were more input prompts,
splitting out an 'input re-prompter' class may be beneficial.


## Next slice: nearing the end, cleanup


# todo
- YatzyConsoleApp, game, others - too many constructors - builder?
- keep adding to thoughts below
- write 'directors cut' of dev log
- make nice readable github page

# Thoughts

It's getting towards the end, and I'd better start noting down my thoughts
before I forget them all. 

Random thoughts
- I didn't end up with many unit tests. Partly because I'm lazy, partly
  because JMock is too verbose, which led to hard to read tests, which
  led to me deleting them in favour of the e2e tests that didn't use
  JMock.
- This took a _long_ time to complete. I hope it's not because top down
  TDD is inherently harder and involves a lot more rework... Rather,
  java's not my preferred language, I'm used to bottom up TDD, JMock sucks...
  anything else?
- Is the 'test pyramid' right? The e2e tests have been much more helpful
  in this project than the unit tests. I guess it depends on the definition
  of a 'unit'. Is it a class? I understand that slow tests with external 
  dependencies are annoying, but so are unit tests for every single class,
  that need to change every time that class changes. Maybe a 'test diamond'
  is better...
- TDD/tests don't completely negate the need for manual verification. A number
  of times after getting the test suite green, I played the game, and found that
  the aesthetics were bad, or that there was a test case I hadn't thought of,
  resulting in a bug.

Top down TDD:
pros
- encourages BDD style e2e tests, which:
    - describe system behaviour in an easy to read way
    - force implementations to focus on readability

cons
- initial skeleton takes a while to get working
- hard to do in a team?
    - never tried in practice, but this exercise has involved changing
      many classes each time a feature is implemented (todo: has it?),
      which means higher chance of merge conflicts in a team