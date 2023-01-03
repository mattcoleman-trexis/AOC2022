package days;

import kotlin.Triple;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5Java extends DayJava {
    static Day5Java instance;

    List<List<Character>> stacks = List.of(new ArrayList());
    List<Triple<Integer, Integer, Integer>> movements;

    public Day5Java() {
        super(5);
    }

    public static void main(String[] args) {
        instance = new Day5Java();
        instance.setup();

        System.out.println("Day 5 Part 1: " + instance.partOne());
        System.out.println("Day 5 Part 2: " + instance.partTwo());
    }

    public void setup() {
        var split = inputString.split("\n [0-9\\w]+");
        Arrays.stream(split[0].split("\n")).forEachOrdered(s -> {
            for (int x = 0; x < s.length(); x += 4) {
                String column = s.substring(x, Math.min(s.length(), x + 4));
                if(stacks.size() - 1 < x) {
//                    stacks.add(List.of(new ArrayList<>()));
                }
                if (!column.isEmpty()) {
                    var pattern = new Regex("[\\[\\]]");
                    Character c = pattern.replace(column, "").toCharArray()[0];
                    stacks.get(x / 4).add(c);
                }
            }
        });

        Arrays.stream(split[1].split("\n")).forEach(s -> {
            var pattern = new Regex("(\\d+)");
            var matches = pattern.findAll(s, 0).iterator();
            List<Integer> numbers = new ArrayList();
            while (matches.hasNext()) {
                numbers.add(Integer.parseInt(matches.next().getValue()));
            }
            movements.add(new Triple(numbers.get(0), numbers.get(1), numbers.get(2)));
        });
    }

    public String partOne() {


        return String.valueOf(0);
    }


    public String partTwo() {

        return String.valueOf(0);
    }
}
