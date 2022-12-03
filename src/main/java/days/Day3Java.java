package days;

import java.util.List;
import java.util.Map;

public class Day3Java extends DayJava {
    static Day3Java instance;

    public Day3Java() {
        super(3);
    }

    public static void main(String[] args) {
        instance = new Day3Java();
        instance.setup();

        System.out.println("Day 1 Part 1: " + instance.partOne());
        System.out.println("Day 1 Part 2: " + instance.partTwo());
    }

    public void setup() {

    }

    public String partOne() {
        return String.valueOf(
                inputList.stream().mapToInt(s -> charToPoint(findCommon(s))).sum()
        );
    }

    private Character findCommon(String s) {
        for (int c = 0; c <= (s.length() / 2); c++) {
            for (int x = (s.length() / 2); x < s.length(); x++) {
                if (s.charAt(c) == s.charAt(x)) {
                    return s.charAt(c);
                }
            }
        }

        return ' ';
    }

    private int charToPoint(Character c) {
        var code = (int) c;
        if (code > 96) {
            return code - 96;
        }

        return code - 38;
    }


    public String partTwo() {
        var sum =0;
        for (int l = 0; l < inputList.size(); l += 3) {
            sum += charToPoint(findCommonOf3(inputList.get(l), inputList.get(l + 1), inputList.get(l + 2)));
        }

        return String.valueOf(sum);
    }

    private Character findCommonOf3(String s1, String s2, String s3) {
        for (int c = 0; c <= s1.length(); c++) {
            if(s2.contains(String.valueOf(s1.charAt(c))) && s3.contains(String.valueOf(s1.charAt(c)))) {
                return s1.charAt(c);
            }
        }

        return ' ';
    }

}
