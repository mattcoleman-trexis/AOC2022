package days

class Day1 : Day(1) {

    override fun partOne(): Any {
        val totalCaloriesList = inputString.split("\n\n")
            .map { it.split("\n").map { it.toInt() }.reduce { acc, s ->  acc + s } }
        val max = totalCaloriesList.max()

        return max.toString()
    }

    override fun partTwo(): Any {
        val totalCaloriesList = inputString.split("\n\n")
            .map { it.split("\n").map { it.toInt() }.reduce { acc, s -> acc + s } }
        val sumTop3 = totalCaloriesList.sortedDescending().subList(0,3).toList().sum()

        return sumTop3.toString()
    }
}
