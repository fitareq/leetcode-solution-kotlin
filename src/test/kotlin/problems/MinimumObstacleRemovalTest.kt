package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class MinimumObstacleRemovalTest {
    private val solution = MinimumObstacleRemoval()

    @Test
    fun `test case 1 - basic example`() {
        val grid = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0)
        )
        assertEquals(2, solution.minimumObstacles(grid))
    }


    @Test
    fun `test case 2 - no obstacles`() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        assertEquals(0, solution.minimumObstacles(grid))
    }

    @Test
    fun `test case 3 - all obstacles except corners`() {
        val grid = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0)
        )
        assertEquals(3, solution.minimumObstacles(grid))
    }

    @Test
    fun `test case 4 - single row`() {
        val grid = arrayOf(
            intArrayOf(0, 1, 0, 0, 0)
        )
        assertEquals(1, solution.minimumObstacles(grid))
    }

    @Test
    fun `test case 5 - single column`() {
        val grid = arrayOf(
            intArrayOf(0),
            intArrayOf(1),
            intArrayOf(0),
            intArrayOf(0)
        )
        assertEquals(1, solution.minimumObstacles(grid))
    }

}
