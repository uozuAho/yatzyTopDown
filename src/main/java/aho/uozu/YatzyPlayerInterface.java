package aho.uozu;

import java.util.Collection;

public interface YatzyPlayerInterface {
    void showPlayerRolled(DiceRoll roll);
    PlayerInput promptForCategory(Collection<ScoreCategoryWithScore> availableCategories);
    PlayerInput promptForCategoryOrReRoll(Collection<ScoreCategoryWithScore> availableCategories);
    void showPlayerScore(int score);
}
