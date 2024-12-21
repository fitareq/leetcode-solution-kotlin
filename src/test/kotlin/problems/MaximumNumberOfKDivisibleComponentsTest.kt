package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumNumberOfKDivisibleComponentsTest {
    val solution = MaximumNumberOfKDivisibleComponents()

    @Test
    fun `case 1`() {
        val edges = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 4)
        )
        val n = 5
        val values = intArrayOf(1, 8, 1, 4, 4)
        val k = 6
        val expected = 2
        val result = solution.maxKDivisibleComponents(n, edges, values, k)
        assertEquals(expected, result)
    }

    @Test
    fun `case 2`() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 4),
            intArrayOf(2, 5),
            intArrayOf(2, 6)
        )
        val n = 7
        val values = intArrayOf(3, 0, 6, 1, 5, 2, 1)
        val k = 3
        val expected = 3
        val result = solution.maxKDivisibleComponents(n, edges, values, k)
        assertEquals(expected, result)
    }
}