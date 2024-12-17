package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstructStringWithRepeatLimitTest {
    private val solution = ConstructStringWithRepeatLimit()
    
    @Test
    fun `test case 1 - basic example`() {
        val s = "cczazcc"
        val repeatLimit = 3
        val expected = "zzcccac"
        assertEquals(expected, solution.repeatLimitedString(s, repeatLimit))
    }
    
    @Test
    fun `test case 2 - not using all characters`() {
        val s = "aababab"
        val repeatLimit = 2
        val expected = "bbabaa"
        assertEquals(expected, solution.repeatLimitedString(s, repeatLimit))
    }
    
    @Test
    fun `test case 3 - single character`() {
        val s = "aaaa"
        val repeatLimit = 2
        val expected = "aa"
        assertEquals(expected, solution.repeatLimitedString(s, repeatLimit))
    }
    
    @Test
    fun `test case 4 - repeat limit 1`() {
        val s = "zzzaaa"
        val repeatLimit = 1
        val expected = "zazaza"
        assertEquals(expected, solution.repeatLimitedString(s, repeatLimit))
    }
    
    @Test
    fun `test case 5 - all different characters`() {
        val s = "abcde"
        val repeatLimit = 2
        val expected = "edcba"
        assertEquals(expected, solution.repeatLimitedString(s, repeatLimit))
    }
    
    @Test
    fun `test case 6 - large repeat limit`() {
        val s = "xyxyx"
        val repeatLimit = 5
        val expected = "yxxyx"
        assertEquals(expected, solution.repeatLimitedString(s, repeatLimit))
    }
    
    @Test
    fun `test case 7 - empty string`() {
        val s = ""
        val repeatLimit = 1
        val expected = ""
        assertEquals(expected, solution.repeatLimitedString(s, repeatLimit))
    }
    
    @Test
    fun `test case 8 - alternating characters`() {
        val s = "ababab"
        val repeatLimit = 1
        val expected = "bababa"
        assertEquals(expected, solution.repeatLimitedString(s, repeatLimit))
    }
}
