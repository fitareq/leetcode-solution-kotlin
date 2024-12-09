package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class SpecialArrayIITest {
    private val solution = SpecialArrayII()

    @Test
    fun `test case 1 - example from problem`() {
        val nums = intArrayOf(3, 4, 1, 2, 6)
        val queries = arrayOf(intArrayOf(0, 4))
        assertContentEquals(
            booleanArrayOf(false),
            solution.isArraySpecial(nums, queries)
        )
    }

    @Test
    fun `test case 2 - multiple queries`() {
        val nums = intArrayOf(4, 3, 1, 6)
        val queries = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(2, 3)
        )
        assertContentEquals(
            booleanArrayOf(false, true),
            solution.isArraySpecial(nums, queries)
        )
    }

    @Test
    fun `test case 3 - single element queries`() {
        val nums = intArrayOf(1, 2, 3, 4)
        val queries = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 1),
            intArrayOf(2, 2)
        )
        assertContentEquals(
            booleanArrayOf(true, true, true),
            solution.isArraySpecial(nums, queries)
        )
    }

    @Test
    fun `test case 4 - all even numbers`() {
        val nums = intArrayOf(2, 4, 6, 8)
        val queries = arrayOf(intArrayOf(0, 3))
        assertContentEquals(
            booleanArrayOf(false),
            solution.isArraySpecial(nums, queries)
        )
    }

    @Test
    fun `test case 5 - all odd numbers`() {
        val nums = intArrayOf(1, 3, 5, 7)
        val queries = arrayOf(intArrayOf(0, 3))
        assertContentEquals(
            booleanArrayOf(false),
            solution.isArraySpecial(nums, queries)
        )
    }

    @Test
    fun `test case 6 - alternating parity`() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val queries = arrayOf(
            intArrayOf(0, 4),
            intArrayOf(1, 3)
        )
        assertContentEquals(
            booleanArrayOf(true, true),
            solution.isArraySpecial(nums, queries)
        )
    }

    @Test
    fun `test case 7 - overlapping queries`() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val queries = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 4)
        )
        assertContentEquals(
            booleanArrayOf(true, true, true),
            solution.isArraySpecial(nums, queries)
        )
    }

    @Test
    fun `test case 8 - large numbers`() {
        val nums = intArrayOf(100001, 100002, 100003, 100004)
        val queries = arrayOf(intArrayOf(0, 3))
        assertContentEquals(
            booleanArrayOf(true),
            solution.isArraySpecial(nums, queries)
        )
    }
}
