# The end

**Good for**
- designing software
- 'just in time' design: no large up-front design effort
- writing readable code & tests
  - e2e tests are readable for non-tech people
  - the application is clearly specified by runnable e2e tests
- flexible tests - e2e tests rarely need to change when implementations change

**Doesn't help**
- designing good software
- test coverage, eg. unit testing corner cases

**Not good for**
- code 'churn' - is it harder for teams to do top-down TDD?

**Other notes**
- There's often a surprising amount of work to get the walking 
  skeleton running and passing the first test

**Future work**
- Try this in an existing project
    - more dependencies
    - multiple people working in the same code base
    - what does the 'walking skeleton' look like for a new feature in an
      existing codebase?
