package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindLargestValueInEachTreeRowTest {
    val solution = FindLargestValueInEachTreeRow()

    @Test
    fun `case 1`() {
        val root = TreeNode(1).apply {
            left = TreeNode(3).apply {
                left = TreeNode(5)
                right = TreeNode(3)
            }
            right = TreeNode(2).apply {
                right = TreeNode(9)
            }
        }
        val expected = listOf(1, 3, 9)
        val result = solution.largestValues(root)

        assertEquals(expected, result)
    }

}