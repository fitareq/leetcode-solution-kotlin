package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumBeautyAfterOperationTest {
    private val solution = MaximumBeautyAfterOperation()

    @Test
    fun `test case 1 - example from description`() {
        assertEquals(3, solution.maximumBeauty(intArrayOf(4,6,1,2), 2))
    }

    @Test
    fun `test case 2 - already equal elements`() {
        assertEquals(4, solution.maximumBeauty(intArrayOf(1,1,1,1), 10))
    }

    @Test
    fun `test case 3 - single element`() {
        assertEquals(1, solution.maximumBeauty(intArrayOf(5), 3))
    }

    @Test
    fun `test case 4 - k equals 0`() {
        assertEquals(2, solution.maximumBeauty(intArrayOf(1,1,2,2,3,3), 0))
    }

    @Test
    fun `test case 5 - large k value`() {
        assertEquals(5, solution.maximumBeauty(intArrayOf(1,2,3,4,5), 100000))
    }

    @Test
    fun `test case 6 - elements far apart`() {
        assertEquals(1, solution.maximumBeauty(intArrayOf(1,100000), 3))
    }

    @Test
    fun `test case 7 - multiple possible values`() {
        assertEquals(3, solution.maximumBeauty(intArrayOf(2,4,6,8), 2))
    }

    @Test
    fun `test case 8 - all zeros`() {
        assertEquals(5, solution.maximumBeauty(intArrayOf(0,0,0,0,0), 1))
    }

    @Test
    fun `test case 9 - alternating pattern`() {
        assertEquals(5, solution.maximumBeauty(intArrayOf(1,3,1,3,1), 1))
    }

    @Test
    fun `test case 10 - maximum constraints`() {
        val nums = IntArray(100000) { it }  // 0 to 99999
        assertEquals(100000, solution.maximumBeauty(nums, 100000))
    }
}
