package days;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4JavaTest {

    @Test
    void testPartOne() {
        Day4Java dayTwo = new Day4Java();
        assertEquals("2", dayTwo.partOne());

    }

    @Test
    void testPartTwo() {
        Day4Java dayTwo = new Day4Java();
        assertEquals("4", dayTwo.partTwo());
    }

}