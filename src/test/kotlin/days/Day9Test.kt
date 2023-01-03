package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class Day9Test {

    private val day = Day9()

    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`("13"))
    }

    @Test
    fun testPartTwo() {
        val partTwo = day.partTwo()
        assertThat(partTwo, `is`("36"))
    }
}
