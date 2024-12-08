package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TwoBestNonOverlappingEventsTest {
    private val solution = TwoBestNonOverlappingEvents()

    @Test
    fun `test case 1 - example from problem`() {
        val events = arrayOf(
            intArrayOf(1,3,2),
            intArrayOf(4,5,2),
            intArrayOf(2,4,3)
        )
        assertEquals(4, solution.maxTwoEvents(events))
    }

    @Test
    fun `test case 2 - single best event`() {
        val events = arrayOf(
            intArrayOf(1,3,2),
            intArrayOf(4,5,2),
            intArrayOf(1,5,5)
        )
        assertEquals(5, solution.maxTwoEvents(events))
    }

    @Test
    fun `test case 3 - non-overlapping high value events`() {
        val events = arrayOf(
            intArrayOf(1,5,3),
            intArrayOf(1,5,1),
            intArrayOf(6,6,5)
        )
        assertEquals(8, solution.maxTwoEvents(events))
    }

    @Test
    fun `test case 4 - all events overlap`() {
        val events = arrayOf(
            intArrayOf(1,5,3),
            intArrayOf(1,5,1),
            intArrayOf(1,5,2)
        )
        assertEquals(3, solution.maxTwoEvents(events))
    }

    @Test
    fun `test case 5 - large time gaps`() {
        val events = arrayOf(
            intArrayOf(1,2,4),
            intArrayOf(3,4,3),
            intArrayOf(10,11,5)
        )
        assertEquals(9, solution.maxTwoEvents(events))
    }

    @Test
    fun `test case 6 - minimum length array`() {
        val events = arrayOf(
            intArrayOf(1,2,1),
            intArrayOf(2,3,2)
        )
        assertEquals(2, solution.maxTwoEvents(events))
    }

    @Test
    fun `test case 7 - exactly two non-overlapping`() {
        val events = arrayOf(
            intArrayOf(1,2,1),
            intArrayOf(2,3,2),
            intArrayOf(3,4,3)
        )
        assertEquals(4, solution.maxTwoEvents(events))
    }

    @Test
    fun `test case 8 - high values`() {
        val events = arrayOf(
            intArrayOf(1,2,1000000),
            intArrayOf(2,3,1000000),
            intArrayOf(3,4,1000000)
        )
        assertEquals(2000000, solution.maxTwoEvents(events))
    }
    @Test
    fun `test case 9 - same values`() {
        val events = arrayOf(
            intArrayOf(1,1,1),
            intArrayOf(1,1,1)
        )
        assertEquals(1, solution.maxTwoEvents(events))
    }
    @Test
    fun `test case 10`() {
        val events = arrayOf(
            intArrayOf(2,1000000000,1000000),
            intArrayOf(1,1,1000000)
        )
        assertEquals(2000000, solution.maxTwoEvents(events))
    }
}
