package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MovePiecesToObtainAStringTest {
    private val solution = MovePiecesToObtainAString()

    @Test
    fun `test case 1 - basic example`() {
        val start = "_L__R__R_"
        val target = "L______RR"
        assertTrue(solution.canChange(start, target))
    }

    @Test
    fun `test case 2 - impossible move`() {
        val start = "R_L_"
        val target = "__LR"
        assertFalse(solution.canChange(start, target))
    }

    @Test
    fun `test case 3 - no moves needed`() {
        val start = "LR"
        val target = "LR"
        assertTrue(solution.canChange(start, target))
    }

    @Test
    fun `test case 4 - only underscores`() {
        val start = "___"
        val target = "___"
        assertTrue(solution.canChange(start, target))
    }

    @Test
    fun `test case 6 - R cannot move left`() {
        val start = "_R"
        val target = "R_"
        assertFalse(solution.canChange(start, target))
    }

    @Test
    fun `test case 7 - L cannot move right`() {
        val start = "L_"
        val target = "_L"
        assertFalse(solution.canChange(start, target))
    }

    @Test
    fun `test case 8 - complex valid moves`() {
        val start = "L_____R"
        val target = "_L___R_"
        assertFalse(solution.canChange(start, target))
    }

    @Test
    fun `test case 9 - different order`() {
        val start = "LR"
        val target = "RL"
        assertFalse(solution.canChange(start, target))
    }

    @Test
    fun `test case 10 - different order`() {
        val start = "_L__R__R_L"
        val target = "L______RR_"
        assertFalse(solution.canChange(start, target))
    }
}