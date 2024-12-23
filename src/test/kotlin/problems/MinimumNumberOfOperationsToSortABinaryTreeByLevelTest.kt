package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumNumberOfOperationsToSortABinaryTreeByLevelTest {
    val solution = MinimumNumberOfOperationsToSortABinaryTreeByLevel()

    @Test
    fun `case 1`() {
        val root = TreeNode(1).apply {
            left = TreeNode(4).apply {
                left = TreeNode(7)
                right = TreeNode(6)
            }
            right = TreeNode(3).apply {
                left = TreeNode(8).apply { left = TreeNode(9) }
                right = TreeNode(5).apply { left = TreeNode(10) }
            }
        }
        val expected = 3
        val result = solution.minimumOperations(root)
        assertEquals(expected, result)
    }

    @Test
    fun `case 2`() {
        val root = TreeNode(1).apply {
            left = TreeNode(3).apply {
                left = TreeNode(7)
                right = TreeNode(6)
            }
            right = TreeNode(2).apply {
                left = TreeNode(5)
                right = TreeNode(4)
            }
        }
        val expected = 3
        val result = solution.minimumOperations(root)
        assertEquals(expected, result)
    }

    @Test
    fun `case 3`() {
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(5)
            }
            right = TreeNode(3).apply {
                left = TreeNode(6)
            }
        }
        val expected = 0
        val result = solution.minimumOperations(root)
        assertEquals(expected, result)
    }
}