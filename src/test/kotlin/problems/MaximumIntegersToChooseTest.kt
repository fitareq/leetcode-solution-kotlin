package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumIntegersToChooseTest {
    private val solution = MaximumIntegersToChoose()

    @Test
    fun `test case 1 - example from problem`() {
        val banned = intArrayOf(1, 6, 5)
        val n = 5
        val maxSum = 6
        assertEquals(2, solution.maxCount(banned, n, maxSum))
    }

    @Test
    fun `test case 2 - no banned numbers`() {
        val banned = intArrayOf()
        val n = 3
        val maxSum = 5
        assertEquals(2, solution.maxCount(banned, n, maxSum))
    }

    @Test
    fun `test case 3 - all numbers banned`() {
        val banned = intArrayOf(1, 2, 3, 4, 5)
        val n = 5
        val maxSum = 100
        assertEquals(0, solution.maxCount(banned, n, maxSum))
    }

    @Test
    fun `test case 4 - small maxSum`() {
        val banned = intArrayOf(10)
        val n = 10
        val maxSum = 3
        assertEquals(2, solution.maxCount(banned, n, maxSum))
    }

    @Test
    fun `test case 5 - large range small maxSum`() {
        val banned = intArrayOf()
        val n = 1000
        val maxSum = 5
        assertEquals(2, solution.maxCount(banned, n, maxSum))
    }

    @Test
    fun `test case 6 - banned numbers outside range`() {
        val banned = intArrayOf(6, 7, 8)
        val n = 5
        val maxSum = 10
        assertEquals(4, solution.maxCount(banned, n, maxSum))
    }

    @Test
    fun `test case 7 - maxSum equals sum of smallest numbers`() {
        val banned = intArrayOf(4, 5)
        val n = 5
        val maxSum = 6
        assertEquals(3, solution.maxCount(banned, n, maxSum))
    }

    @Test
    fun `test case 8 - single number in range`() {
        val banned = intArrayOf()
        val n = 1
        val maxSum = 1
        assertEquals(1, solution.maxCount(banned, n, maxSum))
    }

    @Test
    fun `test case 9 - large maxSum small range`() {
        val banned = intArrayOf(3)
        val n = 5
        val maxSum = 1000
        assertEquals(4, solution.maxCount(banned, n, maxSum))
    }
}