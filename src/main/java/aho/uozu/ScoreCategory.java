package aho.uozu;

public enum ScoreCategory {
    CHANCE;

    public static ScoreCategory fromString(String value) {
        switch (value) {
            case "chance": return CHANCE;
            default:
                throw new IllegalArgumentException("Unknown score category: " + value);
        }
    }
}
