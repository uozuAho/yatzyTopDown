package aho.uozu;

public class ConsoleOutputMock implements ConsoleOutput {
    @Override
    public void write(String value) {

    }

    public String[] getOutputLines() {
        return new String[] {"you rolled: 1, 1, 1, 1, 1"};
    }
}
