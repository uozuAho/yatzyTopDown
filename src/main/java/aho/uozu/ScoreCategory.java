package aho.uozu;

public enum ScoreCategory {
    CHANCE,
    YATZY;

    public static ScoreCategory fromString(String value) {
        switch (value) {
            case "chance": return CHANCE;
            case "yatzy": return YATZY;
            default:
                throw new IllegalArgumentException("Unknown score category: " + value);
        }
    }
}
