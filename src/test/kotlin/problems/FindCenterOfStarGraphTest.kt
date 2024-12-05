package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindCenterOfStarGraphTest {
    private val solution = FindCenterOfStarGraph()

    @Test
    fun `test case 1 - basic star graph`() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(4, 2)
        )
        assertEquals(2, solution.findCenter(edges))
    }

    @Test
    fun `test case 2 - larger star graph`() {
        val edges = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(3, 5),
            intArrayOf(3, 6)
        )
        assertEquals(3, solution.findCenter(edges))
    }

    @Test
    fun `test case 3 - minimum size star graph`() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3)
        )
        assertEquals(2, solution.findCenter(edges))
    }

    @Test
    fun `test case 4 - center is first node`() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 4)
        )
        assertEquals(1, solution.findCenter(edges))
    }

    @Test
    fun `test case 5 - center is last node`() {
        val edges = arrayOf(
            intArrayOf(4, 1),
            intArrayOf(4, 2),
            intArrayOf(4, 3)
        )
        assertEquals(4, solution.findCenter(edges))
    }
}
