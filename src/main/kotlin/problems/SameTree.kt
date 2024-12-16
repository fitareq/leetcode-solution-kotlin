package problems

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have
 * the same value.
 *
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Explanation:
 * Both trees have the same structure and values:
 *    1        1
 *   / \      / \
 *  2   3    2   3
 *
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Explanation:
 * Trees have different structures:
 *    1        1
 *   /         \
 *  2           2
 *
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 * Explanation:
 * Trees have same structure but different values:
 *    1        1
 *   / \      / \
 *  2   1    1   2
 *
 * Constraints:
 * - The number of nodes in both trees is in the range [0, 100]
 * - -10^4 <= Node.val <= 10^4
 */
class SameTree {
    /**
     * Time Complexity: O(min(n, m))
     * - Recursively visit each node in both trees
     * - Where n and m are the number of nodes in trees p and q
     *
     * Space Complexity: O(min(h1, h2))
     * - Recursive call stack can go as deep as the tree height
     * - Where h1 and h2 are the heights of trees p and q
     */
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        // If both nodes are null, trees are same
        if (p == null && q == null) return true
        
        // If only one node is null, trees are different
        if (p == null || q == null) return false
        
        // Check if current nodes have same value
        // and recursively check left and right subtrees
        return p.`val` == q.`val` &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right)
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
