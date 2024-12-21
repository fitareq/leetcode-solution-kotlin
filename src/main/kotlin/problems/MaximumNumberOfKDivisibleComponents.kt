package problems

/**
 * 2872.Maximum Number of K-Divisible Components
 * https://leetcode.com/problems/maximum-number-of-k-divisible-components/description
 *
 * There is an undirected tree with n nodes labeled from 0 to n - 1. You are given the integer n and a 2D integer array edges of length n - 1, where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
 *
 * You are also given a 0-indexed integer array values of length n, where values[i] is the value associated with the ith node, and an integer k.
 *
 * A valid split of the tree is obtained by removing any set of edges, possibly empty, from the tree such that the resulting components all have values that are divisible by k, where the value of a connected component is the sum of the values of its nodes.
 *
 * Return the maximum number of components in any valid split.
 * 
 *  Example 1:
 *
 *  Input: n = 5, edges = [[0,2],[1,2],[1,3],[2,4]], values = [1,8,1,4,4], k = 6
 * Output: 2
 * Explanation: We remove the edge connecting node 1 with 2. The resulting split is valid because:
 * - The value of the component containing nodes 1 and 3 is values[1] + values[3] = 12.
 * - The value of the component containing nodes 0, 2, and 4 is values[0] + values[2] + values[4] = 6.
 * It can be shown that no other valid split has more than 2 connected components.
 *
 * Example 2:
 *
 * Input: n = 7, edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]], values = [3,0,6,1,5,2,1], k = 3
 * Output: 3
 * Explanation: We remove the edge connecting node 0 with 2, and the edge connecting node 0 with 1. The resulting split is valid because:
 * - The value of the component containing node 0 is values[0] = 3.
 * - The value of the component containing nodes 2, 5, and 6 is values[2] + values[5] + values[6] = 9.
 * - The value of the component containing nodes 1, 3, and 4 is values[1] + values[3] + values[4] = 6.
 * It can be shown that no other valid split has more than 3 connected components.
 *
 *
 * Constraints:
 *
 * - 1 <= n <= 3 * 104
 * - edges.length == n - 1
 * - edges[i].length == 2
 * - 0 <= ai, bi < n
 * - values.length == n
 * - 0 <= values[i] <= 109
 * - 1 <= k <= 109
 * - Sum of values is divisible by k.
 * - The input is generated such that edges represents a valid tree.
 */
class MaximumNumberOfKDivisibleComponents {
    /**
     * Time Complexity: O(n)
     * - Each node and edge in the tree is visited exactly once during the DFS traversal.
     * - `n` represents the number of nodes in the tree.
     *
     * Space Complexity: O(n)
     * - Space is used for the adjacency list `adj` and the recursion stack during the DFS traversal, which can go as deep as the height of the tree.
     * - In the worst case (a skewed tree), the recursion stack size is `O(n)`. For a balanced tree, it is `O(log n)`.
     */
    private fun dfs(
        adj: Array<ArrayList<Int>>, // Adjacency list representing the tree.
        values: IntArray, // Node values.
        k: Int, // The divisor for divisibility check.
        count: Array<Int>, // Counter for components divisible by `k`.
        curr: Int, // Current node being processed.
        parent: Int // Parent of the current node in the DFS traversal.
    ): Int {
        // Sum the value of the current node.
        var sum = values[curr].toLong()

        // Recursively process all child nodes (excluding the parent).
        for (i in adj[curr]) {
            if (i != parent) {
                sum += dfs(adj, values, k, count, i, curr)
            }
        }

        // Compute the remainder when the sum is divided by `k`.
        sum %= k

        // If the remainder is 0, increment the count of divisible components.
        if (sum == 0L) ++count[0]

        // Return the sum to propagate to the parent node.
        return sum.toInt()
    }


    fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
        // Construct the adjacency list for the tree.
        val adj: Array<ArrayList<Int>> = Array(n) { arrayListOf() }
        for ((node1, node2) in edges) {
            adj[node1].add(node2)
            adj[node2].add(node1)
        }

        // Initialize the counter for divisible components.
        val count = arrayOf(0)

        // Start a DFS traversal from the root node (0) with no parent (-1).
        dfs(adj, values, k, count, 0, -1)

        // Return the total number of `k`-divisible components.
        return count[0]
    }

}