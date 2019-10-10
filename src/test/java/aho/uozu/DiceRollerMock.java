package aho.uozu;

public class DiceRollerMock implements DiceRoller {
    private Roll _roll;

    @Override
    public Roll nextRoll() {
        return null;
    }

    public void setNextRoll(Roll roll) {
        _roll = roll;
    }
}
