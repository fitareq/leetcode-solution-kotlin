package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class ReverseOddLevelsOfBinaryTreeTest {
    val solution = ReverseOddLevelsOfBinaryTree()

    @Test
    fun `case 1`() {
        val root = TreeNode(2).apply {
            left = TreeNode(3).apply {
                left = TreeNode(8)
                right = TreeNode(13)
            }
            right = TreeNode(5).apply {
                left = TreeNode(21)
                right = TreeNode(34)
            }
        }

        val result = solution.reverseOddLevels(root)
        val expected = TreeNode(2).apply {
            left = TreeNode(5).apply {
                left = TreeNode(8)
                right = TreeNode(13)
            }
            right = TreeNode(3).apply {
                left = TreeNode(21)
                right = TreeNode(34)
            }
        }

        assertTrue(areTreesEqual(result, expected))
    }


    private fun areTreesEqual(t1: TreeNode?, t2: TreeNode?): Boolean {
        if (t1 == null && t2 == null) return true
        if (t1 == null || t2 == null) return false
        return t1.`val` == t2.`val` &&
                areTreesEqual(t1.left, t2.left) &&
                areTreesEqual(t1.right, t2.right)
    }
}