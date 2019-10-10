package aho.uozu.test;

import aho.uozu.DiceRoller;
import aho.uozu.Roll;

public class ConstantDiceRoller implements DiceRoller {

    private final Roll _roll;

    ConstantDiceRoller(Roll roll) {
        _roll = roll;
    }

    @Override
    public Roll nextRoll() {
        return _roll;
    }
}
