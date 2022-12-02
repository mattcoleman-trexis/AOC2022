package days;

import util.InputReader;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day1Java extends DayJava {
    static Day1Java instance;
    int elfCount;
    int[] calorieTotalArray;

    public Day1Java() {
        super(1);
    }

    public static void main(String[] args) {
        instance = new Day1Java();
        instance.setup();

        System.out.println("Day 1 Part 1: " + instance.partOne());
        System.out.println("Day 1 Part 2: " + instance.partTwo());
    }

    public void setup() {
        inputList = InputReader.INSTANCE.getInputAsList(1);
        elfCount = (int) (inputList.stream().filter(String::isEmpty).count() + 1);
        calorieTotalArray = new int[instance.elfCount];
    }

    public String partOne() {
        Arrays.fill(calorieTotalArray, 0);

        int activeIndex = 0;
        for (String s : inputList) {
            if (Objects.equals(s, "")) {
                activeIndex++;
            } else {
                calorieTotalArray[activeIndex] += Integer.parseInt(s);
            }
        }
        int max = getMax(calorieTotalArray);

        return String.valueOf(max);
    }

    private int getMax(int[] calorieTotalArray) {
        var max = 0;
        for (Integer i: calorieTotalArray) {
            max = max > i? max : i;
        }
        return max;
    }

    public String partTwo() {
        Arrays.fill(calorieTotalArray, 0);

        int activeIndex = 0;
        for (String s : inputList) {
            if (Objects.equals(s, "")) {
                activeIndex++;
            } else {
                calorieTotalArray[activeIndex] += Integer.parseInt(s);
            }
        }

        int top3Sum = findTopValues(calorieTotalArray, 3);

        return String.valueOf(top3Sum);
    }

    private int findTopValues(int[] calorieTotalArray, int returnCount) {
        int[] maxes = new int[returnCount];
        Arrays.fill(maxes, 0);
        for (Integer calorieTotal: calorieTotalArray) {
            for (int maxesIndex = 0; maxesIndex < maxes.length; maxesIndex++) {
                if(maxes[maxesIndex] < calorieTotal) {
                    // pass down
                    if (maxes.length - 1 - maxesIndex >= 0)
                        System.arraycopy(maxes, maxesIndex, maxes, maxesIndex + 1, maxes.length - 1 - maxesIndex);
                    maxes[maxesIndex] = calorieTotal;
                    break;
                }
            }
        }

        return getSum(maxes);
    }

    private int getSum(int[] values) {
        var sum = 0;
        for (int value: values) {
            sum += value;
        }
        return sum;
    }

}
