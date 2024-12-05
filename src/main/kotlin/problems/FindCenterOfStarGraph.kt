package problems

/**
 * Problem: Find Center of Star Graph
 * https://leetcode.com/problems/find-center-of-star-graph/
 *
 * There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where:
 * - There is exactly one center node
 * - The center node is connected to every other node
 * - No other connections exist
 * Given a 2D array edges where each edges[i] = [ui, vi] indicates that there is an edge between nodes ui and vi,
 * return the center of the given star graph.
 *
 * Example:
 * Input: edges = [[1,2],[2,3],[4,2]]
 * Output: 2
 * Explanation: Node 2 is connected to every other node, so it is the center.
 *
 * Constraints:
 * - 3 <= n <= 10^5
 * - edges.length == n - 1
 * - edges[i].length == 2
 * - 1 <= ui, vi <= n
 * - ui != vi
 * - The given edges represent a valid star graph
 *
 * Time Complexity: O(1) - only need to check first two edges
 * Space Complexity: O(1) - constant extra space
 *
 * @param edges 2D array representing edges of the star graph
 * @return The center node of the star graph
 */
class FindCenterOfStarGraph {
  /*  fun findCenter(edges: Array<IntArray>): Int {
        val n = edges.size
        val edgeCounter = MutableList(n + 2) { 0 }
        for ((a, b) in edges) {
            ++edgeCounter[a]
            ++edgeCounter[b]
        }

        for (i in 1..n + 2) {
            if (edgeCounter[i] == n) return i
        }
        return -1
    }*/

    fun findCenter(edges: Array<IntArray>): Int {
        return if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) edges[0][0]
        else edges[0][1]
    }
}
