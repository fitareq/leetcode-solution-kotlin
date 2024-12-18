package problems

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FinalPricesWithSpecialDiscountInAShopTest {
    val solution = FinalPricesWithSpecialDiscountInAShop()

    @Test
    fun `test case 1`() {
        val prices = intArrayOf(8, 4, 6, 2, 3)
        val expected = intArrayOf(4, 2, 4, 2, 3)
        assertArrayEquals(expected, solution.finalPrices(prices))
    }
    @Test
    fun `test case 2`() {
        val prices = intArrayOf(1,2,3,4,5)
        val expected = intArrayOf(1,2,3,4,5)
        assertArrayEquals(expected, solution.finalPrices(prices))
    }

    @Test
    fun `test case 3`() {
        val prices = intArrayOf(10,1,1,6)
        val expected = intArrayOf(9,0,1,6)
        assertArrayEquals(expected, solution.finalPrices(prices))
    }
}