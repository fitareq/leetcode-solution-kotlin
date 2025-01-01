package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumScoreAfterSplittingAStringTest {
    val solution = MaximumScoreAfterSplittingAString()

    @Test
    fun `case 1`() {
        val s = "011101"
        val expected = 5

        val result = solution.maxScore(s)
        assertEquals(expected, result)
    }
    @Test
    fun `case 2`() {
        val s = "00111"
        val expected = 5

        val result = solution.maxScore(s)
        assertEquals(expected, result)
    }
    @Test
    fun `case 3`() {
        val s = "1111"
        val expected = 3

        val result = solution.maxScore(s)
        assertEquals(expected, result)
    }
    @Test
    fun `case 4`() {
        val s = "000000"
        val expected = 5

        val result = solution.maxScore(s)
        assertEquals(expected, result)
    }
}