package aho.uozu;

import java.util.Random;

public class RandomDiceRoller implements DiceRoller {

    private Random _rng = new Random();

    @Override
    public DiceRoll nextRoll() {
        return new DiceRoll(_rng.ints(5, 1, 7).toArray());
    }
}
