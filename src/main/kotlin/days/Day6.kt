package days

class Day6 : Day(6) {

    override fun partOne(): Any {
        return findUniqueSubstringPositionOfLength(4).toString()
    }

    override fun partTwo(): Any {
        return findUniqueSubstringPositionOfLength(14).toString()
    }

    fun findUniqueSubstringPositionOfLength(length: Int) : Int {
        var markerPosition = 0
        for (i in 0 until inputString.length) {
            val sub = inputString.substring(i, length+i)
            if (sub.toCharArray().distinct().count() == length) {
                markerPosition = i + length
                break
            }
        }

        return markerPosition
    }
}
