package problems

import java.util.LinkedList
import java.util.Queue

/**
 * Reverse Odd Levels of Binary Tree
 * https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description
 *
 * problem description:
 *
 * Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
 *
 * For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
 * Return the root of the reversed tree.
 *
 * A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
 *
 * The level of a node is the number of edges along the path between it and the root node.
 *
 * Example 1:
 *
 * Input: root = [2,3,5,8,13,21,34]
 * Output: [2,5,3,8,13,21,34]
 * Explanation:
 * The tree has only one odd level.
 * The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3
 *
 * Example 2:
 *
 * Input: root = [7,13,11]
 * Output: [7,11,13]
 * Explanation:
 * The nodes at level 1 are 13, 11, which are reversed and become 11, 13
 *
 * Example 3:
 *
 * Input: root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
 * Output: [0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
 * Explanation:
 * The odd levels have non-zero values.
 * The nodes at level 1 were 1, 2, and are 2, 1 after the reversal.
 * The nodes at level 3 were 1, 1, 1, 1, 2, 2, 2, 2, and are 2, 2, 2, 2, 1, 1, 1, 1 after the reversal.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 214].
 * 0 <= Node.val <= 105
 * root is a perfect binary tree.
 */
class ReverseOddLevelsOfBinaryTree {
    /**
     * Time Complexity: O(n)
     * - Each node is visited exactly once, and processing for reversing values at odd levels is linear in the number of nodes at that level.
     * - Total complexity is proportional to the total number of nodes, `n`.
     *
     * Space Complexity: O(w)
     * - `w` is the maximum width of the tree, which corresponds to the maximum number of nodes in the queue at any level.
     * - In a balanced binary tree, `w` is approximately `n/2` in the last level.
     */
    fun reverseOddLevels(root: TreeNode?): TreeNode? {
        // Queue to perform level-order traversal (BFS).
        val q: Queue<TreeNode> = LinkedList()
        q.offer(root) // Add the root node to the queue.

        var treeLevel = 0 // Tracks the current tree level (0-based indexing).

        // Perform BFS until all nodes are processed.
        while (q.isNotEmpty()) {
            val size = q.size // Number of nodes at the current level.
            val childNodes = arrayListOf<TreeNode>() // Stores nodes of the current level.

            // Process all nodes at the current level.
            repeat(size) {
                val curr = q.poll() // Remove the front node from the queue.
                childNodes.add(curr) // Add it to the current level's node list.

                // Add left and right children to the queue for the next level.
                if (curr.left != null) q.offer(curr.left)
                if (curr.right != null) q.offer(curr.right)
            }

            // Reverse the node values at odd levels.
            if (treeLevel and 1 == 1) { // Odd level check using bitwise AND.
                val n = childNodes.size
                for (i in 0 until n / 2) {
                    // Swap values between nodes at symmetrical positions.
                    childNodes[i].`val` =
                        childNodes[n - i - 1].`val`.also { childNodes[n - i - 1].`val` = childNodes[i].`val` }
                }
            }

            ++treeLevel // Increment the tree level after processing the current one.
        }

        return root // Return the root of the modified tree.
    }

}