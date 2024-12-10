package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestSubstringWithoutRepeatingCharactersTest {
    private val solution = LongestSubstringWithoutRepeatingCharacters()

    @Test
    fun `test case 1 - basic example`() {
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"))
    }

    @Test
    fun `test case 2 - all same characters`() {
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"))
    }

    @Test
    fun `test case 3 - mixed characters`() {
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"))
    }

    @Test
    fun `test case 4 - empty string`() {
        assertEquals(0, solution.lengthOfLongestSubstring(""))
    }

    @Test
    fun `test case 5 - single character`() {
        assertEquals(1, solution.lengthOfLongestSubstring("a"))
    }

    @Test
    fun `test case 6 - all unique characters`() {
        assertEquals(26, solution.lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyz"))
    }

    @Test
    fun `test case 7 - with spaces and symbols`() {
        assertEquals(8, solution.lengthOfLongestSubstring("ab cd!@#"))
    }

    @Test
    fun `test case 8 - repeating at end`() {
        assertEquals(5, solution.lengthOfLongestSubstring("abcdeee"))
    }

    @Test
    fun `test case 9 - repeating at start`() {
        assertEquals(5, solution.lengthOfLongestSubstring("aaabcde"))
    }

    @Test
    fun `test case 10 - numbers and letters`() {
        assertEquals(10, solution.lengthOfLongestSubstring("ab123cd4ef"))
    }
}
