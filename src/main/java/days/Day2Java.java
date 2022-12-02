package days;

import java.util.*;

public class Day2Java extends DayJava {
    static Day2Java instance;

    /**
     * Them | You
     * A|X Rock 1
     * B|Y Paper 2
     * C|Z Scissors 3
     * <p>
     * Lose 0
     * Draw 3
     * Win 6
     */
    Map<String, Integer> playMap = Map.of(
            "A X", 4,
            "A Y", 8,
            "A Z", 3,
            "B X", 1,
            "B Y", 5,
            "B Z", 9,
            "C X", 7,
            "C Y", 2,
            "C Z", 6
    );

    /**
     * X means you need to lose, 0
     * Y means you need to end the round in a draw, 3
     * Z means you need to win. 6
     * <p>
     * win pair
     * A Y  Rock 1 PAPER 2
     * B Z  Paper 2 Scissors 3
     * C X  Scissors 3 Rock  1
     */
    Map<String, Integer> strategyMap = Map.of(
            "A X", 3,
            "A Y", 4,
            "A Z", 8,
            "B X", 1,
            "B Y", 5,
            "B Z", 9,
            "C X", 2,
            "C Y", 6,
            "C Z", 7
    );

    public Day2Java() {
        super(2);
    }

    public static void main(String[] args) {
        instance = new Day2Java();
        instance.setup();

        System.out.println("Day 1 Part 1: " + instance.partOne());
        System.out.println("Day 1 Part 2: " + instance.partTwo());
    }

    public void setup() {

    }

    public String partOne() {
        return String.valueOf(
                inputList.stream().mapToInt(input -> playMap.get(input)).sum()
        );
    }


    public String partTwo() {
        return String.valueOf(
                inputList.stream().mapToInt((input) -> strategyMap.get(input)).sum()
        );
    }

}
