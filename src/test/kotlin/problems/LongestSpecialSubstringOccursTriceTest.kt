package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestSpecialSubstringOccursTriceTest {
    private val solution = LongestSpecialSubstringOccursThrice()

    @Test
    fun `test case 1 - example from problem`() {
        assertEquals(2, solution.maximumLength("aaaa"))
    }

    @Test
    fun `test case 2 - no special substring`() {
        assertEquals(-1, solution.maximumLength("abcdef"))
    }

    @Test
    fun `test case 3 - single character thrice`() {
        assertEquals(1, solution.maximumLength("abcaba"))
    }

    @Test
    fun `test case 4 - minimum length string`() {
        assertEquals(1, solution.maximumLength("aaa"))
    }

    @Test
    fun `test case 5 - multiple possible lengths`() {
        assertEquals(4, solution.maximumLength("aaaaaa"))
        // Possible substrings: "aa" occurs more than thrice
    }

    @Test
    fun `test case 6 - scattered occurrences`() {
        assertEquals(1, solution.maximumLength("abbaccca"))
        // 'a' appears 3 times but longer sequences don't appear thrice
    }

    @Test
    fun `test case 7 - mixed special substrings`() {
        assertEquals(2, solution.maximumLength("aaabbaaa"))
        // "aa" appears thrice (2 at start, 1 at end)
    }

    @Test
    fun `test case 8 - maximum possible length`() {
        val s = "a".repeat(50)  // Maximum length string with same character
        assertEquals(48, solution.maximumLength(s))
        // Should return length that appears at least thrice
    }

    @Test
    fun `test case 9 - just missing third occurrence`() {
        assertEquals(6, solution.maximumLength("eeeyyyybbbbbbbbssppb"))
        // "aa" appears only twice, but "a" appears four times
    }
}
