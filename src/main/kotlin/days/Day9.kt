package days

import kotlin.math.abs
import kotlin.math.sign

class Day9 : Day(9) {
    var headPosition = Position(0, 0)
    var tailPosition = Position(0, 0)
    var tails: MutableList<Position> = mutableListOf()
    var visited: MutableList<Pair<String, Int>> = mutableListOf(
        (tailPosition.x.toString() + ":" + tailPosition.y.toString()) to 1
    )
    var lastHead = headPosition

    override fun partOne(): Any {
        inputList.forEach { s ->
            moveHead(s)
        }
        return visited.count().toString()
    }

    private fun moveHead(movement: String) {
        val (direction, quantity) = movement.split(" ")

        for (step in 1..quantity.toInt()) {
            lastHead = headPosition.copy()
            when (direction) {
                "U" -> headPosition.y += +1
                "D" -> headPosition.y += -1
                "L" -> headPosition.x += -1
                "R" -> headPosition.x +=  1
            }

            if (needTailMoved(headPosition, tailPosition)) {
                tailPosition = lastHead.copy()
                addPositionToVisited(tailPosition)
            }
        }
    }

    private fun moveAll(movement: String) {
        val (direction, quantity) = movement.split(" ")

        for (step in 1..quantity.toInt()) {
            lastHead = headPosition.copy()
            when (direction) {
                "U" -> headPosition.y += +1
                "D" -> headPosition.y += -1
                "L" -> headPosition.x += -1
                "R" -> headPosition.x +=  1
            }
            for(x in 0 until tails.count()) {
                val head = if(x == 0) headPosition else tails[x-1]
                if (needTailMoved(head, tails[x])) {
                    tails[x] = moveTail(head, tails[x])
                    if(x == tails.lastIndex) {
                        addPositionToVisited(tails[x])
                    }
                }
            }
        }
    }

    private fun moveTail(front: Position, back: Position): Position {
        return Position(
            back.x + sign((front.x - back.x).toDouble()).toInt(),
            back.y + sign((front.y - back.y).toDouble()).toInt()
        )
    }

    private fun addPositionToVisited(position: Position) {
        val positionKey = (position.x.toString() + ":" + position.y.toString())
        val currentIndex = visited.indexOfFirst { Position -> Position.first == positionKey }
        if (currentIndex == -1) {
            visited.add(
                positionKey to 1
            )
        }
//        if (currentIndex > -1) {
//            visited.set(currentIndex, positionKey to visited.get(currentIndex).second + 1)
//        } else {
//            visited.add(
//                positionKey to 1
//            )
//        }
    }

    private fun needTailMoved(head: Position, tail: Position): Boolean {
        return (abs(head.x - tail.x) > 1 || abs(head.y - tail.y) > 1)
    }

    override fun partTwo(): Any {
        IntRange(1, 9).forEach {
            tails.add(Position(0, 0))
        }
        visited = mutableListOf(
            (tailPosition.x.toString() + ":" + tailPosition.y.toString()) to 1
        )
        inputList.forEach { s ->
            moveAll(s)
        }
        return visited.count().toString() //2331
    }

    fun draw() {
        val vMax = 30
        val hMax = 30
        var display = ""
        for (v in vMax downTo 0) {
            var line = ""
            for (h in 0 until hMax) {
                val char = if (headPosition.y == v && headPosition.x == h) {
                    "H"
                } else if (tailPosition.y == v && tailPosition.x == h) {
                    "T"
                } else {
                    "."
                }
                line += char
            }
            display += "$line\n"
        }
        print("\r" + display)

        Thread.sleep(500)
        System.out.flush()
    }

    fun drawAll() {
        val vMax = 30
        val hMax = 30
        val offset = 5

        for (v in vMax downTo 0) {
            var line = ""
            for (h in 0 until hMax) {
                var char = "."
                if ((headPosition.y + offset) == v && (headPosition.x + offset)== h) {
                    char = "H"
                } else {
                    tails.forEachIndexed {index, position ->
                        if(char == "." && (position.y + offset) == v && (position.x + offset)== h) {
                            char = (index + 1).toString()
                        }
                    }
                }

                line += char
            }
            println(line)
        }
        println()
    }

    data class Position(
        var x: Int,
        var y: Int
    )
}