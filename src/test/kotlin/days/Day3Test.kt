package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class Day3Test {

    private val dayThree = Day3()

    @Test
    fun testPartOne() {
        assertThat(dayThree.partOne(), `is`("157"))
    }

    @Test
    fun testPartTwo() {
        val partTwo = dayThree.partTwo()
        assertThat(partTwo, `is`("70"))
    }
}
