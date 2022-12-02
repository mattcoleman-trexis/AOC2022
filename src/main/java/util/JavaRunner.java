package util;

import days.DayJava;
import kotlin.time.TimedValue;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.Set;

class JavaRunner {
//
//    private class TimedValue<T> {
//        Duration duration;
//        T value;
//        TimedValue(T v, Duration d) {
//            value = v;
//            duration = d;
//        }
//    }
//
//    static Reflections reflections = new Reflections("days");
//    public static void main(String[] args) {
//        var instance = new JavaRunner();
//        if (args.length > 0) {
//            var day = 0;
//            try {
//                day = Integer.parseInt(args[0]);
//            } catch (NumberFormatException e) {
//                printError("Day argument must be an integer");
//                return;
//            }
//            int finalDay = day;
//            Class<DayJava> dayClass = (DayJava)(getAllDayClasses()
//                    .stream().filter(c -> Integer.parseInt(c.getSimpleName()) == finalDay).findAny());
//
//            if (dayClass.isPresent()) {
//                instance.printDay(dayClass);
//            } else {
//                printError("Day $day not found");
//            }
//
//        } else {
//            var allDayClasses = getAllDayClasses();
//            if (allDayClasses != null) {
//                allDayClasses.sortedBy {
//                    dayNumber(it.simpleName)
//                }.forEach {
//                    printDay(it)
//                }
//            } else {
//                printError("Couldn't find day classes - make sure you're in the right directory and try building again")
//            }
//        }
//    }
//
//    private static void printError(String message) {
//        System.err.println("\n=== ERROR ===\n$message");
//    }
//
////    public static void main2(String[] args) {
////        if (args.length > 0) {
////            var day = 0;
////            try {
////                day = Integer.parseInt(args[0]);
////            } catch (NumberFormatException e){
////                printError("Day argument must be an integer");
////                return;
////            }
////
////            int finalDay = day;
////            var dayClass = getAllDayClasses()
////                    .stream().filter(c -> Integer.parseInt(c.getSimpleName()) == finalDay).findAny();
////
////            if (dayClass != null) {
////                printDay(dayClass)
////            } else {
////                printError("Day $day not found")
////            }
////        } else {
////            var allDayClasses = getAllDayClasses();
////            if (allDayClasses != null) {
////                allDayClasses.sortedBy {
////                    dayNumber(it.simpleName)
////                }.forEach {
////                    printDay(it)
////                }
////            } else {
////                printError("Couldn't find day classes - make sure you're in the right directory and try building again")
////            }
////        }
////    }
//
//    private static Set<Class<? extends DayJava>> getAllDayClasses()
//    {
//        return reflections.getSubTypesOf(DayJava.class);
//    }
//
//    private void printDay(Class<DayJava> dayClass) throws InvocationTargetException, InstantiationException, IllegalAccessException {
//        System.out.println("\n=== DAY ${dayNumber(dayClass.simpleName)} ===");
//        DayJava day = (DayJava) dayClass.getConstructors()[0].newInstance();
//
//        Instant start = Instant.now();
//        String result1 = day.partOne();
//        Instant finish = Instant.now();
//        long timeElapsed = Duration.between(start, finish).toMillis();
//        var partOne = new TimedValue<String>(result1, Duration.ofMillis(timeElapsed));
//
//        start = Instant.now();
//        String result2 = day.partOne();
//        finish = Instant.now();
//        timeElapsed = Duration.between(start, finish).toMillis();
//        var partTwo = new TimedValue<String>(result2, Duration.ofMillis(timeElapsed));
//
//        printParts(partOne, partTwo)
//    }
//
//    private void printParts(TimedValue partOne, TimedValue partTwo) {
//        val padding = max(partOne.value.toString().length, partTwo.value.toString().length) + 14        // 14 is 8 (length of 'Part 1: ') + 6 more
//        println("Part 1: ${partOne.value}".padEnd(padding, ' ') + "(${partOne.duration})")
//        println("Part 2: ${partTwo.value}".padEnd(padding, ' ') + "(${partTwo.duration})")
//    }
////
////
////
////    private fun dayNumber(dayClassName:String)=dayClassName.replace("Day","").
////
////    toInt()
}
