package days;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Day1JavaTest {

    private Method getSumMethod() throws NoSuchMethodException {
        Method method = Day1Java.class.getDeclaredMethod("getSum", int[].class);
        method.setAccessible(true);
        return method;
    }

    @Test
    void testPartOne() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Day1Java day1 = new Day1Java();
//        day1.setup();
        assertEquals(0, getSumMethod().invoke());
    }

}