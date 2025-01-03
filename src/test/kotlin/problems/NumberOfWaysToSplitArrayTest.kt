package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberOfWaysToSplitArrayTest {
    val solution = NumberOfWaysToSplitArray()

    @Test
    fun `case 1`() {
        val nums = intArrayOf(10, 4, -8, 7)
        val expected = 2
        val result = solution.waysToSplitArray(nums)
        assertEquals(expected, result)
    }

    @Test
    fun `case 2`() {
        val nums = intArrayOf(0,-1,-2,-3,-4)
        val expected = 2
        val result = solution.waysToSplitArray(nums)
        assertEquals(expected, result)
    }
}