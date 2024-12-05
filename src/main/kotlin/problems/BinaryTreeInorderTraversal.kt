package problems

import java.util.Stack

/**
 * Problem: Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * Inorder traversal visits nodes in the following order: left -> root -> right
 *
 * Example:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(h) where h is the height of the tree
 *
 * @param root Root node of the binary tree
 * @return List of node values in inorder traversal order
 * @see TreeNode
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinaryTreeInorderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val stack = ArrayDeque<TreeNode>()
        var current = root
        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.addLast(current)
                current = current.left
            }

            current = stack.removeLast()
            result.add(current.`val`)
            current = current.right
        }
        return result
    }
}
