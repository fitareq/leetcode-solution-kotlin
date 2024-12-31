package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumCostForTicketsTest {
    val solution = MinimumCostForTickets()

    @Test
    fun `case 1`(){
        val days = intArrayOf(1,4,6,7,8,20)
        val costs = intArrayOf(2,7,15)
        val expected = 11

        val result = solution.mincostTickets(days, costs)
        assertEquals(expected, result)
    }
}