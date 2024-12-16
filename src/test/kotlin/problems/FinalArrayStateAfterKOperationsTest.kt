package problems

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FinalArrayStateAfterKOperationsTest {
    private val solution = FinalArrayStateAfterKOperations()

    @Test
    fun example1() {
        val nums = intArrayOf(2, 1, 3, 5, 6)
        val k = 5
        val multiplier = 2
        val expected = intArrayOf(8, 4, 6, 5, 6)
        val result = solution.getFinalState(nums, k, multiplier)
        assertArrayEquals(expected, result)
    }

    @Test
    fun example2() {
        val nums = intArrayOf(1, 2)
        val k = 3
        val multiplier = 4
        val expected = intArrayOf(16, 8)
        val result = solution.getFinalState(nums, k, multiplier)
        assertArrayEquals(expected, result)
    }

    @Test
    fun singleElement() {
        val nums = intArrayOf(5)
        val k = 3
        val multiplier = 2
        val expected = intArrayOf(40) // 5 -> 10 -> 20 -> 40
        val result = solution.getFinalState(nums, k, multiplier)
        assertArrayEquals(expected, result)
    }

    @Test
    fun noOperations() {
        val nums = intArrayOf(1, 2, 3)
        val k = 0
        val multiplier = 2
        val expected = intArrayOf(1, 2, 3)
        val result = solution.getFinalState(nums, k, multiplier)
        assertArrayEquals(expected, result)
    }

    @Test
    fun duplicateMinimums() {
        val nums = intArrayOf(1, 3, 1, 2)
        val k = 2
        val multiplier = 3
        val expected = intArrayOf(3, 3, 3, 2) // First 1 becomes 3, then second 1 becomes 3
        val result = solution.getFinalState(nums, k, multiplier)
        assertArrayEquals(expected, result)
    }

    @Test
    fun allSameValues() {
        val nums = intArrayOf(2, 2, 2)
        val k = 2
        val multiplier = 2
        val expected = intArrayOf(4, 4, 2) // First two 2s become 4
        val result = solution.getFinalState(nums, k, multiplier)
        assertArrayEquals(expected, result)
    }
}
