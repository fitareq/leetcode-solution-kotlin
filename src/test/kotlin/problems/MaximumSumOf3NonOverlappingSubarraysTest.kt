package problems

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumSumOf3NonOverlappingSubarraysTest {
    val solution = MaximumSumOf3NonOverlappingSubarrays()

    @Test
    fun `case 1`() {
        val nums = intArrayOf(1, 2, 1, 2, 6, 7, 5, 1)
        val k = 2
        val expected = intArrayOf(0, 3, 5)
        val result = solution.maxSumOfThreeSubarrays(nums, k)

        assertArrayEquals(expected, result)
    }


    @Test
    fun `case 2`() {
        val nums = intArrayOf(1, 2, 1, 2, 1, 2, 1, 2, 1)
        val k = 2
        val expected = intArrayOf(0, 2, 4)
        val result = solution.maxSumOfThreeSubarrays(nums, k)

        assertArrayEquals(expected, result)
    }
}