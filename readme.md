# Yatzy

Relax and play a game of Yatzy.

# Dependencies

- Java 11 (tested using OpenJDK 11 on Windows x64: https://adoptopenjdk.net/)
- Maven (tested using v3.6.1)

# Play the game

Run `run_game.sh` or `run_game.bat`. This will run whatever was built
last time `mvn package` was run. Make sure to run `mvn package` before
running the game, to play the latest version.

# Run all tests

Run `mvn test` on the console.

# Docs

I've tried a number of ways to document the process, and settled on using
vscode's markdown preview for the first draft. This is under
dev_log/red_green_refactor_log. Other docs:

- Original dev log: dev_log/dev.log.md
- Shortened dev log (incomplete): dev_log/dev.log.short.md
- GitHub pages: docs/

# Run github pages locally

See https://help.github.com/en/github/working-with-github-pages/testing-your-github-pages-site-locally-with-jekyll

then

    cd docs
    bundle exec jekyll serve
