package days

import java.io.File

class Day1 : Day(1) {

    override fun partOne(): Any {
        val data = File(javaClass.classLoader.getResource("input_day_1.txt").toURI()).readText()

        val totalCaloriesList = data.split("\n\n")
            .map { it.split("\n").map { it.toInt() }.reduce { acc, s ->  acc + s } }
        val max = totalCaloriesList.max()

        return max.toString()
    }

    override fun partTwo(): Any {
        val data = File(javaClass.classLoader.getResource("input_day_1.txt").toURI()).readText()

        val totalCaloriesList = data.split("\n\n")
            .map { it.split("\n").reduce { acc, s ->  (acc.toInt() + s.toInt()).toString() } }
            .map { it.toInt() }
        val sumTop3 = totalCaloriesList.sortedDescending().subList(0,3).toList().sum()

        return sumTop3.toString()
    }

    /*
    //            .reduce {acc, s ->  (acc.toInt() + s.toInt()).toString() }
       val sums = mutableListOf<Int>(0)
        var activeindex = 0
        for(it in inputList) {
            if(it.isEmpty()) {
                activeindex++
                sums.add(0)
            } else {
                sums[activeindex] = sums[activeindex] + it.toInt()
            }
        }
     */
}
