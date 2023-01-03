package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class Day8Test {

    private val day = Day8()

    @Test
    fun testPartOne() {
        val p1 = day.partOne()
        assertThat(p1, `is`("21"))
    }

    @Test
    fun testPartTwo() {
        val partTwo = day.partTwo()
        assertThat(partTwo, `is`("8"))
    }
}
