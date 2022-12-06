package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class Day6Test {

    private val daySix = Day6()

    @Test
    fun testPartOne() {
        assertThat(daySix.partOne(), `is`("7"))
    }

    @Test
    fun testPartTwo() {
        val partTwo = daySix.partTwo()
        assertThat(partTwo, `is`("19"))
    }
}
