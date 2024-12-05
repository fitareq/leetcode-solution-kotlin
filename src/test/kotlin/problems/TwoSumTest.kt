package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class TwoSumTest {
    private val solution = TwoSum()

    @Test
    fun `test case 1 - basic example`() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        val expected = intArrayOf(0, 1)
        assertContentEquals(expected, solution.twoSum(nums, target))
    }

    @Test
    fun `test case 2 - numbers not in order`() {
        val nums = intArrayOf(3, 2, 4)
        val target = 6
        val expected = intArrayOf(1, 2)
        assertContentEquals(expected, solution.twoSum(nums, target))
    }

    @Test
    fun `test case 3 - same number twice`() {
        val nums = intArrayOf(3, 3)
        val target = 6
        val expected = intArrayOf(0, 1)
        assertContentEquals(expected, solution.twoSum(nums, target))
    }
}
