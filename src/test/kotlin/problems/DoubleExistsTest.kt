package problems

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DoubleExistsTest {
    private val solution = DoubleExists()

    @Test
    fun `test case 1 - basic example`() {
        val arr = intArrayOf(10, 2, 5, 3)
        assertTrue(solution.checkIfExist(arr))
    }

    @Test
    fun `test case 2 - no doubles exist`() {
        val arr = intArrayOf(3, 1, 7, 11)
        assertFalse(solution.checkIfExist(arr))
    }

    @Test
    fun `test case 3 - with zero`() {
        val arr = intArrayOf(7, 1, 14, 11)
        assertTrue(solution.checkIfExist(arr))
    }

    @Test
    fun `test case 4 - negative numbers`() {
        val arr = intArrayOf(-2, 0, 10, -19, 4, 6, -8)
        assertFalse(solution.checkIfExist(arr))
    }

    @Test
    fun `test case 5 - multiple zeros`() {
        val arr = intArrayOf(0, 0)
        assertTrue(solution.checkIfExist(arr))
    }

    @Test
    fun `test case 6 - single zero`() {
        val arr = intArrayOf(0)
        assertFalse(solution.checkIfExist(arr))
    }
}