# The end

- I like these style of e2e tests - not only do they serve as a guide to
  implementing the application, they are a clear statement of the application's
  requirements and expected behaviour, which we lack in the bottom-up,
  class-focused TDD that we do.

Pros
- clear set of acceptance tests describing the application's behaviour
- e2e tests rarely need to change when implementations change

Cons
- code 'churn' - harder for teams to do top-down TDD?

Good for
- designing software
- writing readable code
- clearly stating requirements in tests

Doesn't help
- test coverage, eg. unit testing corner cases
- designing good software

Future work
- Try this in an existing project
    - more dependencies
    - multiple people working in the same code base
    - what does the 'walking skeleton' look like for a new feature in an
      existing codebase?
