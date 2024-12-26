package problems

import java.util.LinkedList
import java.util.Queue

/**
 * 515.Find Largest Value in Each Tree Row
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 *
 *
 * Example 2:
 *
 * Input: root = [1,2,3]
 * Output: [1,3]
 *
 *
 * Constraints:
 *
 * - The number of nodes in the tree will be in the range [0, 104].
 * - -231 <= Node.val <= 231 - 1
 */

class FindLargestValueInEachTreeRow {
    /**
     * Complexity Analysis:
     * - Time Complexity: O(N), where N is the number of nodes in the binary tree.
     *   Each node is visited exactly once during the BFS traversal.
     * - Space Complexity: O(N), where N is the maximum width of the binary tree.
     *   This is due to the queue storing nodes at the current level, and in the worst case,
     *   the width of the binary tree can be proportional to the number of nodes at the widest level.
     */
    fun largestValues(root: TreeNode?): List<Int> {
        // Create a queue for BFS traversal, initialized with the root node.
        val q: Queue<TreeNode> = LinkedList()
        q.offer(root)

        // List to store the largest values at each level of the binary tree.
        val result = mutableListOf<Int>()

        // Perform BFS while there are nodes to process in the queue.
        while (q.isNotEmpty()) {
            // Determine the number of nodes at the current level.
            val n = q.size

            // Initialize the maximum value for the current level.
            var levelMax = Int.MIN_VALUE

            // Traverse all nodes at the current level.
            for (i in 0 until n) {
                // Retrieve and remove the front node from the queue.
                val curr = q.poll()

                // Update the maximum value for the current level.
                if (curr.`val` > levelMax) levelMax = curr.`val`

                // Add the left child to the queue if it exists.
                if (curr.left != null) q.offer(curr.left)

                // Add the right child to the queue if it exists.
                if (curr.right != null) q.offer(curr.right)
            }

            // Add the maximum value for the current level to the result list.
            result.add(levelMax)
        }

        // Return the list of largest values from each level.
        return result
    }

}