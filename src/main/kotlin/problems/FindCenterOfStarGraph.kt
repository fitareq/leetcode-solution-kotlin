package problems

/**
 * 1791. Find Center of Star Graph
 * https://leetcode.com/problems/find-center-of-star-graph/
 *
 * There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where:
 * - There is exactly one center node.
 * - The center node has exactly n-1 edges that connect it to all other nodes.
 * - No other connections exist.
 *
 * Given a 2D array edges where each edges[i] = [ui, vi] indicates that there is an edge between
 * nodes ui and vi, return the center of the given star graph.
 *
 * Example 1:
 * Input: edges = [[1,2],[2,3],[4,2]]
 * Output: 2
 * Explanation:
 * - Node 2 is connected to nodes 1, 3, and 4
 * - No other node has connections to more than one node
 * - Therefore, 2 is the center node
 *
 * Example 2:
 * Input: edges = [[1,2],[5,1],[1,3],[1,4]]
 * Output: 1
 * Explanation:
 * - Node 1 is connected to nodes 2, 3, 4, and 5
 * - No other node has connections to more than one node
 * - Therefore, 1 is the center node
 *
 * Constraints:
 * - 3 <= n <= 10^5
 * - edges.length == n - 1
 * - edges[i].length == 2
 * - 1 <= ui, vi <= n
 * - ui != vi
 * - The given edges represent a valid star graph
 */
class FindCenterOfStarGraph {
    /**
     * Time Complexity: O(1)
     * - Only need to check first two edges
     * - All operations are constant time
     *
     * Space Complexity: O(1)
     * - Only using constant extra space
     * - No additional data structures needed
     */
    fun findCenter(edges: Array<IntArray>): Int {
        // In a star graph, the center node appears in every edge
        // So we only need to check first two edges to find common node
        val edge1 = edges[0]
        val edge2 = edges[1]
        
        // Return the common node between first two edges
        return if (edge1[0] == edge2[0] || edge1[0] == edge2[1]) {
            edge1[0]
        } else {
            edge1[1]
        }
    }
}
