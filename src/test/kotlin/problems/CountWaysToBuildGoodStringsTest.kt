package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountWaysToBuildGoodStringsTest {
    val solution = CountWaysToBuildGoodStrings()

    @Test
    fun `case 1`() {
        val low = 3
        val high = 3
        val zero = 1
        val one = 1
        val expected = 8
        val result = solution.countGoodStrings(low, high, zero, one)
        assertEquals(expected, result)
    }

    @Test
    fun `case 2`() {
        val low = 2
        val high = 3
        val zero = 1
        val one = 2
        val expected = 5
        val result = solution.countGoodStrings(low, high, zero, one)
        assertEquals(expected, result)
    }

    @Test
    fun `case 3`() {
        val low = 200
        val high = 200
        val zero = 10
        val one = 1
        val expected = 764262396
        val result = solution.countGoodStrings(low, high, zero, one)
        assertEquals(expected, result)
    }

    @Test
    fun `case 4`() {
        val low = 1
        val high = 100000
        val zero = 1
        val one = 1
        val expected = 215447031
        val result = solution.countGoodStrings(low, high, zero, one)
        assertEquals(expected, result)
    }
}