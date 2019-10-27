package aho.uozu;

public interface YatzyPlayerInterface {
    void showPlayerRolled(Roll roll);
    void showAvailableCategories(ScoreCategory[] categories);
    ScoreCategory promptForCategoryInput();
    void showPlayerScore(int score);
}
