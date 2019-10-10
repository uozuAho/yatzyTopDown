package aho.uozu;

public class RandomDiceRoller implements DiceRoller {
    @Override
    public Roll nextRoll() {
        // todo: randomise!
        return new Roll(new int[] {1, 1, 1, 1, 1});
    }
}
