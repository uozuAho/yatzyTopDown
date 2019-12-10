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

# Run github pages locally

See https://help.github.com/en/github/working-with-github-pages/testing-your-github-pages-site-locally-with-jekyll

then

    cd docs
    bundle exec jekyll serve

# todo

- YatzyConsoleApp, game, others - too many constructors - builder?
- write 'directors cut' of dev log
- make nice readable github page
