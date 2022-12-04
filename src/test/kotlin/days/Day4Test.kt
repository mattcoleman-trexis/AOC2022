package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class Day4Test {

    private val dayFour = Day4()

    @Test
    fun testPartOne() {
        assertThat(dayFour.partOne(), `is`("2"))
    }

    @Test
    fun testPartTwo() {
        val partTwo = dayFour.partTwo()
        assertThat(partTwo, `is`("4"))
    }
}
