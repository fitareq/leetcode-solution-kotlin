package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AddingSpacesToAStringTest {
    val solution = AddingSpacesToAString()

    @Test
    fun `case 1`() {
        assertEquals("Leetcode Helps Me Learn", solution.addSpaces("LeetcodeHelpsMeLearn", intArrayOf(8, 13, 15)))
    }
    @Test
    fun `case 2`() {
        assertEquals("i code in py thon", solution.addSpaces("icodeinpython", intArrayOf(1,5,7,9)))
    }

    @Test
    fun `case 3`() {
        assertEquals(" s p a c i n g", solution.addSpaces("spacing", intArrayOf(0,1,2,3,4,5,6)))
    }

    @Test
    fun `case 4`() {
        assertEquals(" s", solution.addSpaces("s", intArrayOf(0)))
    }
}