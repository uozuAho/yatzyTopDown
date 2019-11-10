package aho.uozu;

import java.util.List;

public interface YatzyPlayerInterface {
    void showPlayerRolled(DiceRoll roll);
    void showAvailableCategories(List<ScoreCategoryWithScore> categories);
    ScoreCategory promptForCategoryInput();
    void showPlayerScore(int score);
}
