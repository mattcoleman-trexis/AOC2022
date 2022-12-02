package days

class Day2 : Day(2) {

    /**
     * Them | You
     * A|X Rock 1
     * B|Y Paper 2
     * C|Z Scissors 3
     *
     * Lose 0
     * Draw 3
     * Win 6
     */
    enum class HandType(val value: Int) {
        ROCK(1),
        PAPER(2),
        SCISSORS(3);

        companion object {
            fun fromString(value: String) = when (value) {
                "X", "A" -> ROCK
                "Y", "B" -> PAPER
                "Z", "C" -> SCISSORS
                else -> throw Exception("Not A Valid HandType")
            }
        }
    }

    /**
     * X means you need to lose,
     * Y means you need to end the round in a draw,
     * Z means you need to win.
     */
    enum class Outcome(val value: Int) {
        WIN(6),
        DRAW(3),
        LOSE(0);

        companion object {
            fun fromString(value: String) = when (value) {
                "X", "A" -> LOSE
                "Y", "B" -> DRAW
                "Z", "C" -> WIN
                else -> throw Exception("Not A Valid Outcome")
            }
        }
    }

    val winMap = mapOf(
        HandType.ROCK to HandType.SCISSORS,
        HandType.PAPER to HandType.ROCK,
        HandType.SCISSORS to HandType.PAPER
    )


    override fun partOne(): Any {
        val pointList: List<Int> = inputList.map {
            val them = HandType.fromString(it.split(' ').first())
            val you = HandType.fromString(it.split(' ').last())
            val points = when(them) {
                you -> (3 + you.value)
                winMap[you] -> (6 + you.value)
                else -> you.value
            }

            points
        }

        return pointList.sum().toString()
    }


    override fun partTwo(): Any {
        val pointList: List<Int> = inputList.map {
            val them = HandType.fromString(it.split(' ').first())
            val outcome = Outcome.fromString(it.split(' ').last())
            var points = outcome.value

            points += when (outcome) {
                Outcome.WIN -> getWinnerTo(them).value
                Outcome.LOSE -> winMap[them]?.value ?: 0
                Outcome.DRAW -> them.value
            }

            points
        }

        return pointList.sum().toString()
    }

    private fun getWinnerTo(them: HandType) = winMap.filter { win -> win.value == them }.keys.first()
}