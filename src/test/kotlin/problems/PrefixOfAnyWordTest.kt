package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class PrefixOfAnyWordTest {
    val solution = PrefixOfAnyWord()

    @Test
    fun `case 1`() {
        assertEquals(4, solution.isPrefixOfWord("i love eating burger", "burg"))
    }
    @Test
    fun `case 2`() {
        assertEquals(2, solution.isPrefixOfWord("this problem is an easy problem", "pro"))
    }
    @Test
    fun `case 3`() {
        assertEquals(-1, solution.isPrefixOfWord("i am tired", "you"))
    }

    @Test
    fun `case 4`() {
        assertEquals(-1, solution.isPrefixOfWord("hellohello hellohellohello", "ell"))
    }
    @Test
    fun `case 5`() {
        assertEquals(1, solution.isPrefixOfWord("leetcode corona", "leetco"))
    }
}