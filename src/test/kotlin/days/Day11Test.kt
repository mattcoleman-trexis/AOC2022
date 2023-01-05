package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class Day11Test {

    private val day = Day11()

    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`("10605"))
    }

    @Test
    fun testPartTwo() {
        val partTwo = day.partTwo()
        assertThat(partTwo, `is`("2713310158"))
    }
}
