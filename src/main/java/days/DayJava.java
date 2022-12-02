package days;

import util.InputReader;

import java.util.List;

public abstract class DayJava {
    // lazy delegate ensures the property gets computed only on first access
    public List<String> inputList;
    public String inputString;

    abstract public String partOne();
    abstract public String partTwo();

    DayJava(int dayNumber) {
        inputList = InputReader.INSTANCE.getInputAsList(dayNumber);
        inputString = InputReader.INSTANCE.getInputAsString(dayNumber);
    }
}
