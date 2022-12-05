package days

class Day5 : Day(5) {
    var stacks: MutableList<MutableList<Char>> = mutableListOf()
    var movements: MutableList<Triple<Int, Int, Int>> = mutableListOf()

    override fun partOne(): Any {
        parseInput()

        for (movement in movements) {
            for (m in 0 until movement.first) {
                val item = stacks.get(movement.second - 1).removeLast()
                stacks.get(movement.third - 1).add(item)
            }
        }

        val message = stacks.map { it.last() }.joinToString("")


        return message
    }


    private fun parseInput() {
        stacks = mutableListOf()
        movements = mutableListOf()

        var section = 1
        for (line in inputList) {
            if (section < 2 && line.contains(" 1   2   3")) {
                section = 2
                continue
            }
            if (line.isBlank()) continue
            when (section) {
                1 -> {
                    line.chunked(4).forEachIndexed { index, s ->
                        if (stacks.lastIndex < index) {
                            stacks.add(mutableListOf())
                        }
                        if (s.isNotBlank()) {
                            stacks.get(index).add(s.replace("""[\[\]]""".toRegex(), "").first())
                        }
                    }
                }
                2 -> {
                    val instructionSet = "(\\d+)".toRegex().findAll(line).map(MatchResult::value).map(String::toInt)
                        .toList()
                    movements.add(Triple(instructionSet[0], instructionSet[1], instructionSet[2]))
                }
            }
        }
        stacks = stacks.map { it.reversed().toMutableList() }.toMutableList()
    }

    override fun partTwo(): Any {
        parseInput()
        for (movement in movements) {
            val moveStack = mutableListOf<Char>()
            moveStack.addAll(stacks.get(movement.second - 1).takeLast(movement.first))
            for (m in 0 until movement.first) {
                stacks.get(movement.second - 1).removeLast()
            }
            stacks.get(movement.third - 1).addAll(moveStack)
        }
        val message = stacks.map { it.last() }.joinToString("")

        return message
    }
}
