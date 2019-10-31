package aho.uozu.test;

import aho.uozu.DiceRoll;
import aho.uozu.ScoreCategory;
import aho.uozu.ScoreCategoryWithScore;
import aho.uozu.YatzyPlayerInterface;

import java.util.List;

public class PlayerInterfaceMock implements YatzyPlayerInterface {
    @Override
    public void showPlayerRolled(DiceRoll roll) {
        throw new IllegalStateException("not implemented");
    }

    @Override
    public void showAvailableCategories(List<ScoreCategoryWithScore> categories) {
        throw new IllegalStateException("not implemented");
    }

    @Override
    public ScoreCategory promptForCategoryInput() {
        throw new IllegalStateException("not implemented");
    }

    @Override
    public void showPlayerScore(int score) {
        throw new IllegalStateException("not implemented");
    }
}
