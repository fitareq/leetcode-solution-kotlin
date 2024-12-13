package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindScoreAfterMarkingElementsTest {
    private val solution = FindScoreAfterMarkingElements()

    @Test
    fun `Example 1 - Basic case with unique values`() {
        val nums = intArrayOf(2, 1, 3, 4, 5, 2)
        assertEquals(7, solution.findScore(nums))
    }

    @Test
    fun `Example 2 - Array with duplicate values`() {
        val nums = intArrayOf(2, 3, 5, 1, 3, 2)
        assertEquals(5, solution.findScore(nums))
    }

    @Test
    fun `Single element array`() {
        val nums = intArrayOf(42)
        assertEquals(42, solution.findScore(nums))
    }

    @Test
    fun `Two elements array`() {
        val nums = intArrayOf(2, 1)
        assertEquals(1, solution.findScore(nums))
    }

    @Test
    fun `Array with all same elements`() {
        val nums = intArrayOf(5, 5, 5, 5, 5)
        assertEquals(15, solution.findScore(nums))
    }

    @Test
    fun `Array with alternating values`() {
        val nums = intArrayOf(1, 3, 1, 3, 1)
        assertEquals(3, solution.findScore(nums))
    }

    @Test
    fun `Large values array`() {
        val nums = intArrayOf(1000000, 1, 1000000, 1, 1000000)
        assertEquals(2, solution.findScore(nums))
    }

    @Test
    fun `Sorted array in ascending order`() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(9, solution.findScore(nums))
    }

    @Test
    fun `Sorted array in descending order`() {
        val nums = intArrayOf(5, 4, 3, 2, 1)
        assertEquals(9, solution.findScore(nums))
    }
    @Test
    fun `case 9`() {
        val nums = intArrayOf(10,44,10,8,48,30,17,38,41,27,16,33,45,45,34,30,22,3,42,42)
        assertEquals(212, solution.findScore(nums))
    }
    @Test
    fun `case 10`() {
        val nums = intArrayOf(6,6,6,7,4,3,7)
        assertEquals(15, solution.findScore(nums))
    }
}
