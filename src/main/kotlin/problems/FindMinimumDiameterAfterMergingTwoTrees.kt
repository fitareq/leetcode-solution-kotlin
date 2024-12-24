package problems

import java.util.LinkedList
import java.util.Queue

/**
 * 3203.Find Minimum Diameter After Merging Two Trees
 * https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/description/
 *
 * There exist two undirected trees with n and m nodes, numbered from 0 to n - 1 and from 0 to m - 1, respectively. You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the second tree.
 *
 * You must connect one node from the first tree with another node from the second tree with an edge.
 *
 * Return the minimum possible diameter of the resulting tree.
 *
 * The diameter of a tree is the length of the longest path between any two nodes in the tree.
 *
 * Example 1:
 *
 *
 * Input: edges1 = [[0,1],[0,2],[0,3]], edges2 = [[0,1]]
 * Output: 3
 *
 * Explanation:
 * We can obtain a tree of diameter 3 by connecting node 0 from the first tree with any node from the second tree.
 *
 * Example 2:
 *
 *
 * Input: edges1 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]], edges2 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]
 * Output: 5
 *
 * Explanation:
 * We can obtain a tree of diameter 5 by connecting node 0 from the first tree with node 0 from the second tree.
 *
 *
 *
 * Constraints:
 *
 * - 1 <= n, m <= 105
 * - edges1.length == n - 1
 * - edges2.length == m - 1
 * - edges1[i].length == edges2[i].length == 2
 * - edges1[i] = [ai, bi]
 * - 0 <= ai, bi < n
 * - edges2[i] = [ui, vi]
 * - 0 <= ui, vi < m
 * - The input is generated such that edges1 and edges2 represent valid trees.
 */
class FindMinimumDiameterAfterMergingTwoTrees {
    /**
     * Complexity:
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * - Building the adjacency list takes O(n).
     * - Each BFS traversal visits all nodes once, taking O(n).
     * - Two BFS traversals: O(n) + O(n) = O(n).
     * Space Complexity: O(n).
     * - The adjacency list requires O(n) space.
     * - The BFS queue and visited array each require O(n) space.
     */

    fun minimumDiameterAfterMerge(edges1: Array<IntArray>, edges2: Array<IntArray>): Int {
        // Step 1: Calculate the diameter of the first tree using `findTreeDiameter`.
        val edge1Diameter = findTreeDiameter(edges1)

        // Step 2: Calculate the diameter of the second tree using `findTreeDiameter`.
        val edge2Diameter = findTreeDiameter(edges2)

        // Step 3: Calculate the possible diameters after merging:
        // - Case 1: Connecting the two trees with a single edge.
        //   Each tree contributes half its diameter (rounded up) plus 1 for the connecting edge.
        val mergedDiameter = ((edge1Diameter + 1) / 2) + ((edge2Diameter + 1) / 2) + 1

        // - Case 2: The maximum diameter of either of the two trees remains as the final diameter.
        return maxOf(mergedDiameter, edge2Diameter, edge1Diameter)
    }

    private fun findTreeDiameter(edges: Array<IntArray>): Int {
        // Total number of nodes in the tree is one more than the number of edges
        val n = edges.size + 1

        // Create adjacency list representation of the tree
        val adj = Array<MutableList<Int>>(n) { mutableListOf() }
        for ((u, v) in edges) {
            adj[u].add(v) // Add edge u -> v
            adj[v].add(u) // Add edge v -> u (because it's an undirected tree)
        }

        // Function to perform BFS and return the farthest node and its distance
        fun bfs(start: Int): Pair<Int, Int> {
            val q: Queue<Pair<Int, Int>> = LinkedList() // Queue for BFS: stores pairs (node, distance)
            q.offer(start to 0) // Start BFS from the 'start' node with distance 0
            val visited = BooleanArray(n) { false } // Array to track visited nodes
            visited[start] = true // Mark the start node as visited
            var farthestNode = start // Track the farthest node found
            var maxDistance = 0 // Track the maximum distance from the start node

            // Perform BFS
            while (q.isNotEmpty()) {
                val (node, distance) = q.poll() // Dequeue the current node and its distance

                // Update the farthest node and its distance if the current distance is greater
                if (distance > maxDistance) {
                    farthestNode = node
                    maxDistance = distance
                }

                // Traverse all unvisited neighbors of the current node
                for (neighbor in adj[node]) {
                    if (!visited[neighbor]) { // If the neighbor has not been visited
                        visited[neighbor] = true // Mark it as visited
                        q.offer(neighbor to distance + 1) // Add it to the queue with an updated distance
                    }
                }
            }

            // Return the farthest node found and its distance
            return farthestNode to maxDistance
        }

        // Step 1: Perform BFS from an arbitrary node (node 0) to find the farthest node from it
        val (farthestNode, _) = bfs(0)

        // Step 2: Perform BFS from the farthest node found in step 1 to find the diameter
        val (_, diameter) = bfs(farthestNode)

        // Return the diameter of the tree
        return diameter
    }

}