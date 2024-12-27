package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BestSightseeingPairTest {
    val solution = BestSightseeingPair()

    @Test
    fun `case 1`() {
        val values = intArrayOf(8, 1, 5, 2, 6)
        val expected = 11
        val result = solution.maxScoreSightseeingPair(values)
        assertEquals(expected, result)
    }

    @Test
    fun `case 2`() {
        val values = intArrayOf(1, 2)
        val expected = 2
        val result = solution.maxScoreSightseeingPair(values)
        assertEquals(expected, result)
    }
}