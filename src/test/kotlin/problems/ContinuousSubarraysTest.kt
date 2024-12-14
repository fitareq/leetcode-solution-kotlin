package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ContinuousSubarraysTest {
    private val solution = ContinuousSubarrays()

    @Test
    fun `Example 1 - Basic case`() {
        val nums = intArrayOf(5,4,2,4)
        assertEquals(8, solution.continuousSubarrays(nums))
    }

    @Test
    fun `Example 2 - Array with larger differences`() {
        val nums = intArrayOf(1,2,3)
        assertEquals(6, solution.continuousSubarrays(nums))
    }

    @Test
    fun `Single element array`() {
        val nums = intArrayOf(42)
        assertEquals(1, solution.continuousSubarrays(nums))
    }

    @Test
    fun `Two elements within range`() {
        val nums = intArrayOf(1,2)
        assertEquals(3, solution.continuousSubarrays(nums))
    }

    @Test
    fun `Two elements outside range`() {
        val nums = intArrayOf(1,4)
        assertEquals(2, solution.continuousSubarrays(nums))
    }

    @Test
    fun `Array with all same elements`() {
        val nums = intArrayOf(3,3,3,3)
        assertEquals(10, solution.continuousSubarrays(nums))
    }

    @Test
    fun `Array with alternating values`() {
        val nums = intArrayOf(1,3,1,3,1)
        assertEquals(15, solution.continuousSubarrays(nums))
    }

    @Test
    fun `Array with increasing values`() {
        val nums = intArrayOf(1,2,3,4,5)
        assertEquals(12, solution.continuousSubarrays(nums))
    }

    @Test
    fun `Array with decreasing values`() {
        val nums = intArrayOf(5,4,3,2,1)
        assertEquals(12, solution.continuousSubarrays(nums))
    }

    @Test
    fun `Large values within range`() {
        val nums = intArrayOf(1000000,1000001,1000002)
        assertEquals(6, solution.continuousSubarrays(nums))
    }
}
