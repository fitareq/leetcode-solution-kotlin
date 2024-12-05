package problems

import java.util.Stack

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * */

/**
 * Problem: Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * Inorder traversal: left -> root -> right
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/*class BinaryTreeInorderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        inorder(root)
        return res
    }

    private val res = arrayListOf<Int>()
    private fun inorder(root: TreeNode?) {
        if (root == null) return
        inorder(root.left)
        res.add(root.`val`)
        inorder(root.right)
    }
}*/

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
