package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindMinimumDiameterAfterMergingTwoTreesTest {
    val solution = FindMinimumDiameterAfterMergingTwoTrees()

    @Test
    fun `case 1`() {
        val edges1 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3)
        )
        val edges2 = arrayOf(
            intArrayOf(0, 1)
        )
        val expected = 3

        val result = solution.minimumDiameterAfterMerge(edges1, edges2)
        assertEquals(expected, result)
    }

    @Test
    fun `case 2`() {
        val edges1 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3),
            intArrayOf(2, 4),
            intArrayOf(2, 5),
            intArrayOf(3, 6),
            intArrayOf(2, 7)
        )
        val edges2 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3),
            intArrayOf(2, 4),
            intArrayOf(2, 5),
            intArrayOf(3, 6),
            intArrayOf(2, 7)
        )
        val expected = 5

        val result = solution.minimumDiameterAfterMerge(edges1, edges2)
        assertEquals(expected, result)
    }

    @Test
    fun `case 3`() {
        val edges1 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(2, 0),
            intArrayOf(3, 2),
            intArrayOf(3, 6),
            intArrayOf(8, 7),
            intArrayOf(4, 8),
            intArrayOf(5, 4),
            intArrayOf(3, 5),
            intArrayOf(3, 9)
        )
        val edges2 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3)
        )
        val expected = 7

        val result = solution.minimumDiameterAfterMerge(edges1, edges2)
        assertEquals(expected, result)
    }
}