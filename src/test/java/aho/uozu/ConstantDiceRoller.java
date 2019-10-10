package aho.uozu;

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
