package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaxChunksToMakeSortedTest {
    val solution = MaxChunksToMakeSorted()

    @Test
    fun `test case 1`() {
        val arr = intArrayOf(4, 3, 2, 1, 0)
        val expected = 1

        assertEquals(expected, solution.maxChunksToSorted(arr))
    }
    @Test
    fun `test case 2`() {
        val arr = intArrayOf(1,0,2,3,4)
        val expected = 4

        assertEquals(expected, solution.maxChunksToSorted(arr))
    }
    @Test
    fun `test case 3`() {
        val arr = intArrayOf(4,3,2,1,0,5,7,6)
        val expected = 3

        assertEquals(expected, solution.maxChunksToSorted(arr))
    }
    @Test
    fun `test case 4`() {
        val arr = intArrayOf(2,0,1)
        val expected = 1

        assertEquals(expected, solution.maxChunksToSorted(arr))
    }
}