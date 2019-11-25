package aho.uozu;

import java.util.Collection;
import java.util.List;

public interface YatzyPlayerInterface {
    void showPlayerRolled(DiceRoll roll);
    void showAvailableCategories(List<ScoreCategoryWithScore> categories);
    PlayerInput promptForCategory(Collection<ScoreCategory> availableCategories);
    PlayerInput promptForCategoryOrReRoll(Collection<ScoreCategory> availableCategories);
    void showPlayerScore(int score);
}
