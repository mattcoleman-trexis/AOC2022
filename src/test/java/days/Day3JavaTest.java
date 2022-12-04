package days;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3JavaTest {

    @Test
    void testPartOne() {
        Day3Java dayTwo = new Day3Java();
        assertEquals("157", dayTwo.partOne());

    }

    @Test
    void testPartTwo() {
        Day3Java dayTwo = new Day3Java();
        assertEquals("70", dayTwo.partTwo());
    }

}