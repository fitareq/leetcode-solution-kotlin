package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumLimitOfBallsTest {
    private val solution = MinimumLimitOfBalls()

    @Test
    fun `test case 1 - example from problem`() {
        val nums = intArrayOf(9)
        val maxOperations = 2
        assertEquals(3, solution.minimumSize(nums, maxOperations))
    }

    @Test
    fun `test case 2 - multiple bags`() {
        val nums = intArrayOf(2,4,8,2)
        val maxOperations = 4
        assertEquals(2, solution.minimumSize(nums, maxOperations))
    }

    @Test
    fun `test case 3 - no operations needed`() {
        val nums = intArrayOf(1,2,3)
        val maxOperations = 0
        assertEquals(3, solution.minimumSize(nums, maxOperations))
    }

    @Test
    fun `test case 4 - single operation`() {
        val nums = intArrayOf(7,17)
        val maxOperations = 2
        assertEquals(7, solution.minimumSize(nums, maxOperations))
    }

    @Test
    fun `test case 5 - large numbers`() {
        val nums = intArrayOf(431,922,158,60,192,14,788,146,788,775)
        val maxOperations = 5
        assertEquals(271, solution.minimumSize(nums, maxOperations))
    }

    @Test
    fun `test case 6 - single element with many operations`() {
        val nums = intArrayOf(1000000000)
        val maxOperations = 1000000000
        assertEquals(1, solution.minimumSize(nums, maxOperations))
    }

    @Test
    fun `test case 7 - equal elements`() {
        val nums = intArrayOf(8,8,8,8)
        val maxOperations = 4
        assertEquals(2, solution.minimumSize(nums, maxOperations))
    }

    @Test
    fun `test case 8 - minimum operations needed`() {
        val nums = intArrayOf(16)
        val maxOperations = 1
        assertEquals(8, solution.minimumSize(nums, maxOperations))
    }
}
