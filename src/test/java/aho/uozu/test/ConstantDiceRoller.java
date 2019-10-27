package aho.uozu.test;

import aho.uozu.DiceRoller;
import aho.uozu.DiceRoll;

public class ConstantDiceRoller implements DiceRoller {

    private final DiceRoll _roll;

    public ConstantDiceRoller(DiceRoll roll) {
        _roll = roll;
    }

    @Override
    public DiceRoll nextRoll() {
        return _roll;
    }
}
