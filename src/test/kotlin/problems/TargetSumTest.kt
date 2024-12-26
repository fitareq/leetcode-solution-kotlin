package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TargetSumTest {
    val solution = TargetSum()

    @Test
    fun `case 1`() {
        val nums = intArrayOf(1, 1, 1, 1, 1)
        val target = 3
        val expected = 5
        val result = solution.findTargetSumWays(nums, target)

        assertEquals(expected, result)
    }
}