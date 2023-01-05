package days

import kotlin.math.abs

class Day11 : Day(11) {

    var monkeys = mutableListOf(Monkey(), Monkey(), Monkey(), Monkey())
    override fun partOne(): Any {

        parseInput()
        for(cycle in 0 .. 19) {
            processMonkeys()
        }
        val result = monkeys.map { it.processedCount }.sortedDescending().take(2).reduce { acc, i -> i*acc }
        return result.toString()
    }

    private fun parseInput() {
        var current = 0
        inputList.forEach {
            if (it.contains("Monkey")) {
                // set current
                current = it.split(" ").last().replace(":", "").toInt()
                if(monkeys.count()-1 < current) {
                    monkeys.add(Monkey())
                }
            } else if (it.contains("Starting")) {
                monkeys[current].items = it.split(":")
                    .last().split(",").map { i -> i.trim().toInt() }.toMutableList()
            } else if (it.contains("Operation")) {
                val regex = "old ([*+-/]) ([a-z0-9]+)".toRegex()
                val groups = regex.find(it)!!.groups
                val operator = groups.get(1)?.value.toString()
                val value = groups.last()?.value.toString()
                monkeys[current].operation = if(value == "old") {
                    {old -> old * old}
                } else {
                    operatorFromChar(operator.first(), value.toInt())
                }
            } else if (it.contains("Test")) {
                monkeys[current].divisibleTestBy = it.split(" ").last().toInt()
            } else if (it.contains("If")) {
                when (it.contains("true")) {
                    true -> monkeys[current].testTrueTo = it.split(" ").last().toInt()
                    false -> monkeys[current].testFalseTo = it.split(" ").last().toInt()
                }
            }
        }
    }

    private fun processMonkeys() {
        monkeys.forEachIndexed { index, monkey ->
            if(monkey.isOut || monkey.items.isEmpty()) {
                monkey.isOut = true
            }
            for (itemIndex in 0 until monkey.items.count()) {
                monkey.processedCount++
                val new = monkey.operation(monkey.items[itemIndex]) / 3
                if(new % monkey.divisibleTestBy == 0) {
                    monkeys[monkey.testTrueTo].items.add(new)
                } else {
                    monkeys[monkey.testFalseTo].items.add(new)
                }
            }
            monkey.items = mutableListOf()
        }
    }

    private fun processMonkeysP2() {

        monkeys.forEach { monkey ->
            if(monkey.items.isEmpty()) {
                monkey.isOut = true
            }
            for (itemIndex in 0 until monkey.items.count()) {
                monkey.processedCount++
                val new = monkey.operation(monkey.items[itemIndex])
                if(new > 0 && new % monkey.divisibleTestBy == 0) {
                    monkeys[monkey.testTrueTo].items.add(new)
                } else {
                    monkeys[monkey.testFalseTo].items.add(new)
                }
            }
            monkey.items = mutableListOf()
        }
    }

    fun operatorFromChar(charOperator: Char, value: Int): (Int) -> Int {
        return when (charOperator) {
            '+' -> { old -> old + value }
            '-' -> { old -> old - value }
            '/' -> { old -> old / value }
            '*' -> { old -> old * value }
            else -> throw Exception("That's not a supported operator")
        }
    }

    override fun partTwo(): Any {
        monkeys = mutableListOf()
        parseInput()
        for(cycle in 0 until 20) {
            processMonkeysP2()
            val processedList = monkeys.map { it.processedCount }
            processedList
        }

        val result = monkeys.map { it.processedCount }.sortedDescending().take(2).map{ it.toLong() }.reduce { acc, i -> i*acc }
        return result.toString()
    }

    inner class Monkey() {
        var items = mutableListOf<Int>()
        var operation: ((Int) -> Int) = { i -> i }
        var divisibleTestBy = 0
        var testTrueTo = 0
        var testFalseTo = 0
        var processedCount = 0
        var isOut = false

        fun test(item: Int) : Int {
            return if(item > 0 && item % divisibleTestBy == 0) {
                testTrueTo
            } else {
                testFalseTo
            }
        }
    }
}