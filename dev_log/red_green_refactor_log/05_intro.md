# Evolutionary design, using top-down TDD

Heavily influenced by: ![](../img/GOOSGBT_cover.jpg)

# General conventions

In each slide, I add a feature, and cover a red-green-refactor 'round'

<h2 style="color: white; background: red">RED</h2>

`git tag: tagged_commit_around_where_these_changes_happened`

E2E test change to cover the new feature:

```java
public void EndToEndTestForANewFeature() {
    Assert.SomethingHappened();
}
```

- Only end-to-end (E2E) / acceptance test code is shown
- No unit tests are shown (but they're there).

<h2 style="color: white; background: green">GREEN</h2>

Class diagram

- Only application classes are shown (no tests)

<h2 style="color: black; background: yellow">REFACTOR</h2>

Notes on any refactoring.
