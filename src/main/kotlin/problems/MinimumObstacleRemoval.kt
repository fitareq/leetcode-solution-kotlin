package problems

import java.util.PriorityQueue
/**
 * Problem: Minimum Obstacle Removal to Reach Corner
 * https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/
 *
 * You are given a 0-indexed 2D integer array grid of size m x n. Each cell has one of two values:
 * - 0 represents an empty cell
 * - 1 represents an obstacle that may be removed
 *
 * Return the minimum number of obstacles to remove so you can move from the upper left corner (0, 0)
 * to the lower right corner (m - 1, n - 1).
 */
class MinimumObstacleRemoval {
    private data class Cell(val x: Int, val y: Int, val obstacles: Int)
    private val dx = intArrayOf(0, 1, 0, -1)
    private val dy = intArrayOf(1, 0, -1, 0)
    fun minimumObstacles(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val pq = PriorityQueue<Cell>(compareBy { it.obstacles })

        pq.offer(Cell(0, 0, grid[0][0]))
        val visited = Array(m) { BooleanArray(n) }

        while (pq.isNotEmpty()) {
            val curr = pq.poll()
            if (curr.x == m - 1 && curr.y == n - 1) return curr.obstacles

            for (i in 0..3) {
                val newX = curr.x + dx[i]
                val newY = curr.y + dy[i]

                if (newX in 0 until m && newY in 0 until n && !visited[newX][newY]) {
                    visited[newX][newY] = true
                    pq.offer(Cell(newX, newY, curr.obstacles + grid[newX][newY]))
                }
            }
        }
        return -1
    }
}