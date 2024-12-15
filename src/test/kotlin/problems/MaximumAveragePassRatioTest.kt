package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.abs

class MaximumAveragePassRatioTest {
    private val solution = MaximumAveragePassRatio()
    private val epsilon = 1e-5

    @Test
    fun example1() {
        val classes = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 5),
            intArrayOf(2, 2)
        )
        val extraStudents = 2
        val expected = 0.78333
        val result = solution.maxAverageRatio(classes, extraStudents)
        assert(abs(result - expected) < epsilon) {
            "Expected $expected but got $result"
        }
    }

    @Test
    fun example2() {
        val classes = arrayOf(
            intArrayOf(2, 4),
            intArrayOf(3, 9),
            intArrayOf(4, 5),
            intArrayOf(2, 10)
        )
        val extraStudents = 4
        val expected = 0.53485
        val result = solution.maxAverageRatio(classes, extraStudents)
        assert(abs(result - expected) < epsilon) {
            "Expected $expected but got $result"
        }
    }

    @Test
    fun singleClass() {
        val classes = arrayOf(intArrayOf(1, 2))
        val extraStudents = 1
        val expected = 0.66667
        val result = solution.maxAverageRatio(classes, extraStudents)
        assert(abs(result - expected) < epsilon) {
            "Expected $expected but got $result"
        }
    }

    @Test
    fun allClassesPerfect() {
        val classes = arrayOf(
            intArrayOf(2, 2),
            intArrayOf(4, 4),
            intArrayOf(3, 3)
        )
        val extraStudents = 5
        val expected = 1.0
        val result = solution.maxAverageRatio(classes, extraStudents)
        assert(abs(result - expected) < epsilon) {
            "Expected $expected but got $result"
        }
    }
}
