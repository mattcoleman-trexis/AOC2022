package days

class Day3 : Day(3) {

    override fun partOne(): Any {
        val split: List<Int> = inputList.map {
            val part1 = it.substring(0, it.length / 2)
            val part2 = it.substring((it.length / 2))

            findCommonOf2(part1, part2)
        }

        val sum = split.sum()
        return sum.toString()
    }

    private fun findCommonOf2(part1: String, part2: String): Int {
        for (c in part1) {
            if (part2.contains(c)) {
                return codeToPoint(c.code)
            }
        }

        return 0
    }

    private fun findCommonOf3(part1: String, part2: String, part3: String): Int {
        for (c in part1) {
            if (part2.contains(c) && part3.contains(c)) {
                return codeToPoint(c.code)
            }
        }

        return 0
    }


    private fun codeToPoint(code: Int) : Int {
        if(code > 96) {
            return code - 96
        }
        return code - 38
    }

    override fun partTwo(): Any {
        val points: List<Int> = inputList.chunked(3).map {
            findCommonOf3(it[0], it[1], it[2])
        }

        return points.sum().toString()
    }
}
