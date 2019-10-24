package aho.uozu;

class YatzyConsoleInterface {
    private TextOutput _output;

    YatzyConsoleInterface(TextOutput output) {
        _output = output;
    }

    public void showPlayerRolled(Roll roll) {
        _output.writeLine("you rolled: " + roll);
    }
}
