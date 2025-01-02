package problems

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CountVowelStringsInRangesTest {
    val solution = CountVowelStringsInRanges()

    @Test
    fun `case 1`() {
        val words = arrayOf("aba", "bcb", "ece", "aa", "e")
        val queries = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(1, 4),
            intArrayOf(1, 1)
        )
        val expected = intArrayOf(2, 3, 0)
        val result = solution.vowelStrings(words, queries)

        assertArrayEquals(expected, result)
    }

    @Test
    fun `case 2`() {
        val words = arrayOf("a", "e", "i")
        val queries = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(0, 1),
            intArrayOf(2, 2)
        )
        val expected = intArrayOf(3, 2, 1)
        val result = solution.vowelStrings(words, queries)

        assertArrayEquals(expected, result)
    }
}