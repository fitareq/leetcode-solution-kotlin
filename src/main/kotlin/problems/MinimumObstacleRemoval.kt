package problems

import java.util.*

/**
 * 2290. Minimum Obstacle Removal to Reach Corner
 * https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/
 *
 * You are given a 0-indexed 2D integer array grid of size m x n. Each cell has one of two values:
 * - 0 represents an empty cell
 * - 1 represents an obstacle that may be removed
 *
 * You can move up, down, left, or right from and to an empty cell.
 *
 * Return the minimum number of obstacles to remove so you can move from the upper left cell (0, 0)
 * to the lower right cell (m - 1, n - 1).
 *
 * Example 1:
 * Input: grid = [[0,1,1],[1,1,0],[1,1,0]]
 * Output: 2
 * Explanation:
 * We can remove the obstacles at (0,1) and (0,2) to create a path from (0,0) to (2,2).
 * It can be shown that we need to remove at least 2 obstacles, so we return 2.
 * Note that there may be other ways to remove 2 obstacles to create a path.
 *
 * Example 2:
 * Input: grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]
 * Output: 0
 * Explanation:
 * We can move from (0,0) to (2,4) without removing any obstacles, so we return 0.
 *
 * Constraints:
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m, n <= 10^5
 * - 2 <= m * n <= 10^5
 * - grid[i][j] is either 0 or 1
 * - grid[0][0] == grid[m-1][n-1] == 0
 */
class MinimumObstacleRemoval {
    /**
     * Time Complexity: O(m * n * log(m * n))
     * - Using priority queue for Dijkstra's algorithm
     * - Each cell can be processed at most once
     * - Where m and n are the dimensions of the grid
     *
     * Space Complexity: O(m * n)
     * - Priority queue can store at most m * n cells
     * - Distance array stores m * n values
     * - Where m and n are the dimensions of the grid
     */
    fun minimumObstacles(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        
        // Directions for moving: right, down, left, up
        val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
        
        // Priority queue to process cells with minimum obstacles first
        // Triple: (obstacles, row, col)
        val pq = PriorityQueue<Triple<Int, Int, Int>> { a, b -> a.first - b.first }
        
        // Distance array to track minimum obstacles needed for each cell
        val dist = Array(m) { IntArray(n) { Int.MAX_VALUE } }
        dist[0][0] = grid[0][0]
        pq.offer(Triple(grid[0][0], 0, 0))
        
        // Process cells using Dijkstra's algorithm
        while (pq.isNotEmpty()) {
            val (obstacles, row, col) = pq.poll()
            
            // If we reached the target cell, return obstacles
            if (row == m - 1 && col == n - 1) {
                return obstacles
            }
            
            // Skip if we found a better path
            if (obstacles > dist[row][col]) {
                continue
            }
            
            // Try all four directions
            for ((dx, dy) in dirs) {
                val newRow = row + dx
                val newCol = col + dy
                
                // Check if new position is valid
                if (newRow in 0 until m && newCol in 0 until n) {
                    val newObstacles = obstacles + grid[newRow][newCol]
                    
                    // If we found a better path, update distance and add to queue
                    if (newObstacles < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newObstacles
                        pq.offer(Triple(newObstacles, newRow, newCol))
                    }
                }
            }
        }
        
        return dist[m - 1][n - 1]
    }
}