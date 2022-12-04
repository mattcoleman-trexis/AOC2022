package days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4Java extends DayJava {
    static Day4Java instance;

    public Day4Java() {
        super(4);
    }

    public static void main(String[] args) {
        instance = new Day4Java();
        instance.setup();

        System.out.println("Day 1 Part 1: " + instance.partOne());
        System.out.println("Day 1 Part 2: " + instance.partTwo());
    }

    public void setup() {

    }

    public String partOne() {
        int sum = 0;
        for (String line : inputList) {
            List<Sections> elves = getElfSections(line);
            if ((elves.get(0).start >= elves.get(1).start && elves.get(0).stop <= elves.get(1).stop)
                    || (elves.get(1).start >= elves.get(0).start && elves.get(1).stop <= elves.get(0).stop)) {
                sum += 1;
            }
        }
        return String.valueOf(sum);
    }

    private List<Sections> getElfSections(String line) {

        return Arrays.stream(line.split(","))
                .map(sections -> Arrays.stream(sections.split("-"))
                        .mapToInt(Integer::parseInt).toArray()
                ).map(this::toSections).toList();
    }

    private Sections toSections(int[] elf) {
        return new Sections(elf[0], elf[1]);
    }

    public String partTwo() {
        int sum = 0;
        for (String line : inputList) {
            List<Sections> elves = getElfSections(line);

            if (checkAnOverlap(elves.get(0), elves.get(1)) || checkAnOverlap(elves.get(1), elves.get(0))) {
                sum += 1;
            }
        }

        return String.valueOf(sum);
    }

    private boolean checkAnOverlap(Sections elf1, Sections elf2) {
        return ((elf1.start >= elf2.start && elf1.start <= elf2.stop)
                || (elf2.stop >= elf1.start && elf2.stop <= elf1.stop));
    }

    record Sections(int start, int stop) {
    }

}
