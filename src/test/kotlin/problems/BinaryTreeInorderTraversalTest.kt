import org.junit.jupiter.api.Test
import problems.BinaryTreeInorderTraversal
import problems.TreeNode
import kotlin.test.assertEquals

class BinaryTreeInorderTraversalTest {
    private val solution = BinaryTreeInorderTraversal()

    @Test
    fun `test case 1 - basic tree`() {
        // Create tree: [1,null,2,3]
        //   1
        //    \
        //     2
        //    /
        //   3
        val root = TreeNode(1).apply {
            right = TreeNode(2).apply {
                left = TreeNode(3)
            }
        }

        assertEquals(listOf(1, 3, 2), solution.inorderTraversal(root))
    }

    @Test
    fun `test case 2 - empty tree`() {
        assertEquals(emptyList(), solution.inorderTraversal(null))
    }

    @Test
    fun `test case 3 - single node`() {
        val root = TreeNode(1)
        assertEquals(listOf(1), solution.inorderTraversal(root))
    }

    @Test
    fun `test case 4 - complete binary tree`() {
        // Create tree:
        //      1
        //    /   \
        //   2     3
        //  / \   / \
        // 4   5 6   7
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(5)
            }
            right = TreeNode(3).apply {
                left = TreeNode(6)
                right = TreeNode(7)
            }
        }

        assertEquals(listOf(4, 2, 5, 1, 6, 3, 7), solution.inorderTraversal(root))
    }

    @Test
    fun `test case 5 - left-heavy tree`() {
        // Create tree:
        //      1
        //     /
        //    2
        //   /
        //  3
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3)
            }
        }

        assertEquals(listOf(3, 2, 1), solution.inorderTraversal(root))
    }
}