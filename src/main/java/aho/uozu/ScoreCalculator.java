package aho.uozu;

public class ScoreCalculator {
    public int calculateScore(Roll roll, ScoreCategory category) {
        if (category == ScoreCategory.CHANCE)
            return calculateChanceScore(roll);
        if (category == ScoreCategory.YATZY)
            return calculateYatzyScore(roll);

        throw new IllegalStateException("Unknown category: " + category);
    }

    private int calculateChanceScore(Roll roll) {
        var calculator = new ChanceScoreCalculator();
        return calculator.calculateScore(roll);
    }

    private int calculateYatzyScore(Roll roll) {
        var calculator = new YatzyScoreCalculator();
        return calculator.calculateScore(roll);
    }
}
