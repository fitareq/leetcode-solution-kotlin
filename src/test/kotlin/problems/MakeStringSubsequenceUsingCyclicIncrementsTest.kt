package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MakeStringSubsequenceUsingCyclicIncrementsTest {
    val solution = MakeStringSubsequenceUsingCyclicIncrements()

    @Test
    fun `test case 1 - basic example`() {
        val str1 = "abc"
        val str2 = "ad"
        assertTrue(solution.canMakeSubsequence(str1, str2))
    }

    @Test
    fun `test case 2 - impossible match`() {
        val str1 = "abc"
        val str2 = "ae"
        assertFalse(solution.canMakeSubsequence(str1, str2))
    }

    @Test
    fun `test case 3 - cyclic z to a`() {
        val str1 = "xyz"
        val str2 = "xa"
        assertTrue(solution.canMakeSubsequence(str1, str2))
    }

    @Test
    fun `test case 4 - str2 longer than str1`() {
        val str1 = "abc"
        val str2 = "abcd"
        assertFalse(solution.canMakeSubsequence(str1, str2))
    }

    @Test
    fun `test case 5 - exact match`() {
        val str1 = "aaa"
        val str2 = "a"
        assertTrue(solution.canMakeSubsequence(str1, str2))
    }

    @Test
    fun `test case 6 - all increments needed`() {
        val str1 = "aaaaaa"
        val str2 = "bbb"
        assertTrue(solution.canMakeSubsequence(str1, str2))
    }

    @Test
    fun `test case 7 - empty str2`() {
        val str1 = "abc"
        val str2 = ""
        assertTrue(solution.canMakeSubsequence(str1, str2))
    }

    @Test
    fun `test case 8 - complex sequence`() {
        val str1 = "zzzzz"
        val str2 = "aaa"
        assertTrue(solution.canMakeSubsequence(str1, str2))
    }
}