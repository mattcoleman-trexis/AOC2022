package days

import kotlin.math.abs

class Day10 : Day(10) {
    var register = 1
    var sum = 0
    var cycle = 0

    var currentRow = 0
    var crtOutput: MutableList<MutableList<Char>> = mutableListOf()


    override fun partOne(): Any {
        register = 1
        sum = 0
        cycle = 0
        inputList.forEachIndexed { index, s ->
            val command = s.split(" ")
            when (command.first()) {
                "addx" -> {
                    incrementCycle()
                    incrementCycle()
                    register += command.last().toInt()
                }
                "noop" -> incrementCycle()
            }
        }

        return sum.toString()
    }

    private fun incrementCycle() {
        cycle++
        when (cycle) {
            20, 60, 100, 140, 180, 220 -> {
                sum += register * cycle
            }
        }
    }

    private fun incrementCyclePart2() {
        cycle++
        if (cycle > 39 && cycle % 40 == 0) {
            currentRow++
        }
        markCursor()
    }

    override fun partTwo(): Any {
        crtOutput = mutableListOf()
        for (i in 1..6) {
            crtOutput.add(createCRTCycle())
        }
        /// create array from 0 to 39
        register = 1
        sum = 0
        cycle = 0
        // mark first row
        markCursor()
        inputList.forEachIndexed { index, s ->
            val command = s.split(" ")
            when (command.first()) {
                "addx" -> {
                    incrementCyclePart2()
                    register += command.last().toInt()
                    incrementCyclePart2()

                }
                "noop" -> incrementCyclePart2()
            }
        }

        return buildCRT()
    }

    private fun buildCRT(): String {
        return "\n" + crtOutput.map { it.joinToString("") }.joinToString("\n")
    }

    private fun markCursor() {
        val centerPosition = (cycle % 40)
        val offset = register
        if (abs(centerPosition - offset) <= 1 && offset >= 0 && offset < 40) {
            crtOutput[currentRow][centerPosition] = '#'
        }
    }

    private fun createCRTCycle(): MutableList<Char> {
        return Array(40) { '.' }.toMutableList()
    }
}