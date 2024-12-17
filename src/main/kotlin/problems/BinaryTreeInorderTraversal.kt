package problems

/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Explanation:
 *   1
 *    \
 *     2
 *    /
 *   3
 * Inorder traversal visits: left -> root -> right
 * So the path is: 1 -> 3 -> 2
 *
 * Example 2:
 * Input: root = []
 * Output: []
 * Explanation: Empty tree has no nodes to traverse
 *
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 * Explanation: Single node tree, just visit the root
 *
 * Constraints:
 * - The number of nodes in the tree is in the range [0, 100]
 * - -100 <= Node.val <= 100
 *
 * Follow up: Can you do it iteratively?
 */

class BinaryTreeInorderTraversal {


    /**
     * Recursive solution
     *
     * Time Complexity: O(n)
     * - Visit each node exactly once
     * - Each node requires constant time operations
     * - Where n is the number of nodes in the tree
     *
     * Space Complexity: O(h)
     * - Recursive call stack can go as deep as the height of tree
     * - Best case O(log n) for balanced tree
     * - Worst case O(n) for skewed tree
     * - Additional O(n) for result list
     */
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()

        // Helper function for recursive traversal
        fun inorder(node: TreeNode?) {
            // Base case: if node is null, return
            if (node == null) return

            // Inorder traversal: left -> root -> right
            inorder(node.left)        // Process left subtree
            result.add(node.`val`)    // Process current node
            inorder(node.right)       // Process right subtree
        }

        inorder(root)
        return result
    }

    /**
     * Iterative solution using stack
     *
     * Time Complexity: O(n)
     * - Visit each node exactly once
     * - Each node requires constant time stack operations
     * - Where n is the number of nodes in the tree
     *
     * Space Complexity: O(h)
     * - Stack can grow up to the height of tree
     * - Best case O(log n) for balanced tree
     * - Worst case O(n) for skewed tree
     * - Additional O(n) for result list
     */
    fun inorderTraversalIterative(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val stack = ArrayDeque<TreeNode>()
        var current = root

        // Continue while we have nodes to process or stack is not empty
        while (current != null || stack.isNotEmpty()) {
            // Traverse to leftmost node, pushing all nodes onto stack
            while (current != null) {
                stack.addLast(current)
                current = current.left
            }

            // Process current node (top of stack)
            current = stack.removeLast()
            result.add(current.`val`)

            // Move to right subtree
            current = current.right
        }

        return result
    }
}
