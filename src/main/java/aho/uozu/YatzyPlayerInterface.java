package aho.uozu;

import java.util.List;

public interface YatzyPlayerInterface {
    void showPlayerRolled(DiceRoll roll);
    void showAvailableCategories(List<ScoreCategoryWithScore> categories);
    PlayerInput promptForCategory();
    PlayerInput promptForCategoryOrReRoll();
    void showPlayerScore(int score);
}
