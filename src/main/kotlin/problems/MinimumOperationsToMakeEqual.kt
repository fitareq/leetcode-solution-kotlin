package problems

import java.util.*

/**
 * 2998. Minimum Number of Operations to Make X and Y Equal
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-x-and-y-equal/
 *
 * You are given two positive integers x and y.
 *
 * In one operation, you can do one of the following:
 * 1. Decrement x by 1
 * 2. If x is divisible by 11, divide x by 11
 * 3. If x is divisible by 5, divide x by 5
 * 4. If x is divisible by 3, divide x by 3
 *
 * Return the minimum number of operations required to make x and y equal.
 *
 * Example 1:
 * Input: x = 26, y = 1
 * Output: 3
 * Explanation:
 * We can make 26 equal to 1 in 3 operations:
 * 1. Divide x by 13 since x is divisible by 13: 26 -> 2
 * 2. Decrement x by 1: 2 -> 1
 * Now x equals y
 *
 * Example 2:
 * Input: x = 54, y = 2
 * Output: 4
 * Explanation:
 * We can make 54 equal to 2 in 4 operations:
 * 1. Divide x by 3 since x is divisible by 3: 54 -> 18
 * 2. Divide x by 3 since x is divisible by 3: 18 -> 6
 * 3. Divide x by 3 since x is divisible by 3: 6 -> 2
 * Now x equals y
 *
 * Example 3:
 * Input: x = 25, y = 30
 * Output: 5
 * Explanation:
 * We can make 25 equal to 30 in 5 operations:
 * 1. Increment x by 1: 25 -> 26
 * 2. Increment x by 1: 26 -> 27
 * 3. Increment x by 1: 27 -> 28
 * 4. Increment x by 1: 28 -> 29
 * 5. Increment x by 1: 29 -> 30
 * Now x equals y
 *
 * Constraints:
 * - 1 <= x, y <= 10^4
 */
class MinimumOperationsToMakeEqual {
    /**
     * Time Complexity: O(n)
     * - Using BFS to explore all possible operations
     * - Each number is visited at most once
     * - Where n is the range of possible values (10^4)
     *
     * Space Complexity: O(n)
     * - Queue can store at most n numbers
     * - Set stores visited numbers
     * - Where n is the range of possible values (10^4)
     */
    fun minimumOperations(x: Int, y: Int): Int {
        // Queue to store numbers and their operation counts
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(Pair(x, 0))
        
        // Set to track visited numbers
        val visited = mutableSetOf<Int>()
        visited.add(x)
        
        // BFS to find shortest path to y
        while (queue.isNotEmpty()) {
            val (current, ops) = queue.poll()
            
            // If we found y, return operations count
            if (current == y) {
                return ops
            }
            
            // Try all possible operations
            
            // Operation 1: Decrement by 1
            tryOperation(current - 1, ops + 1, queue, visited)
            
            // Operation 2: Divide by 11 if divisible
            if (current % 11 == 0) {
                tryOperation(current / 11, ops + 1, queue, visited)
            }
            
            // Operation 3: Divide by 5 if divisible
            if (current % 5 == 0) {
                tryOperation(current / 5, ops + 1, queue, visited)
            }
            
            // Operation 4: Divide by 3 if divisible
            if (current % 3 == 0) {
                tryOperation(current / 3, ops + 1, queue, visited)
            }
        }
        
        return -1  // Should never reach here given constraints
    }
    
    /**
     * Helper function to try an operation if the resulting number is valid and unvisited
     */
    private fun tryOperation(
        next: Int,
        ops: Int,
        queue: Queue<Pair<Int, Int>>,
        visited: MutableSet<Int>
    ) {
        // Only process if number is positive and hasn't been visited
        if (next > 0 && next !in visited) {
            visited.add(next)
            queue.offer(Pair(next, ops))
        }
    }
}
