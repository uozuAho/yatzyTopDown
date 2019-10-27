package aho.uozu;

public interface YatzyPlayerInterface {
    void showPlayerRolled(DiceRoll roll);
    void showAvailableCategories(ScoreCategory[] categories);
    ScoreCategory promptForCategoryInput();
    void showPlayerScore(int score);
}
