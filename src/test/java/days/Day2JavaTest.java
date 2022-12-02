package days;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2JavaTest {

    @Test
    void testPartOne() {
        Day2Java dayTwo = new Day2Java();
        assertEquals("15", dayTwo.partOne());

    }

    @Test
    void testPartTwo() {
        Day2Java dayTwo = new Day2Java();
        assertEquals("12", dayTwo.partTwo());
    }

}