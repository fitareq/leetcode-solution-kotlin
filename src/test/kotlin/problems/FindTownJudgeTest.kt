package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindTownJudgeTest {
    private val solution = FindTownJudge()

    @Test
    fun `test cases for n=1`() {
        // Case 1: Single person with no trust relationships
        assertEquals(1, solution.findJudge(1, arrayOf()))
    }

    @Test
    fun `test case 1 - basic example`() {
        val n = 2
        val trust = arrayOf(intArrayOf(1, 2))
        assertEquals(2, solution.findJudge(n, trust))
    }

    @Test
    fun `test case 2 - no judge`() {
        val n = 3
        val trust = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(3, 1)
        )
        assertEquals(-1, solution.findJudge(n, trust))
    }

    @Test
    fun `test case 3 - multiple candidates`() {
        val n = 3
        val trust = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3)
        )
        assertEquals(-1, solution.findJudge(n, trust))
    }

    @Test
    fun `test case 4 - single person`() {
        val n = 1
        val trust = arrayOf<IntArray>()
        assertEquals(1, solution.findJudge(n, trust))
    }

    @Test
    fun `test case 5 - everyone trusts judge`() {
        val n = 4
        val trust = arrayOf(
            intArrayOf(1, 4),
            intArrayOf(2, 4),
            intArrayOf(3, 4)
        )
        assertEquals(4, solution.findJudge(n, trust))
    }

    @Test
    fun `test case 6 - circular trust`() {
        val n = 3
        val trust = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 1)
        )
        assertEquals(-1, solution.findJudge(n, trust))
    }

    @Test
    fun `test case 7 - judge trusts someone`() {
        val n = 3
        val trust = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(3, 1)
        )
        assertEquals(-1, solution.findJudge(n, trust))
    }
}