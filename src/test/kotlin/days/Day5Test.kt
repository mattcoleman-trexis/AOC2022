package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class Day5Test {

    private val dayFive = Day5()

    @Test
    fun testPartOne() {
        assertThat(dayFive.partOne(), `is`("CMZ"))
    }

    @Test
    fun testPartTwo() {
        val partTwo = dayFive.partTwo()
        assertThat(partTwo, `is`("MCD"))
    }
}
