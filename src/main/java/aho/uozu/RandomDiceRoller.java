package aho.uozu;

public class RandomDiceRoller implements DiceRoller {
    @Override
    public DiceRoll nextRoll() {
        // todo: randomise!
        return new DiceRoll(new int[] {1, 1, 1, 1, 1});
    }
}
