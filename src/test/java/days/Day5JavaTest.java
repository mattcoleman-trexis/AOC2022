package days;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day5JavaTest {

    @Test
    void testPartOne() {
        Day5Java day = new Day5Java();
        day.setup();
        assertEquals("2", day.partOne());

    }

    @Test
    void testPartTwo() {
        Day5Java day = new Day5Java();
        assertEquals("4", day.partTwo());
    }

}