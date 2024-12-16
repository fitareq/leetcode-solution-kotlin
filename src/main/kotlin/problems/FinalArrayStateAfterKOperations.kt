package problems

import java.util.PriorityQueue

/**
 * 3264. Final Array State After K Multiplication Operations I
 * https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/
 *
 * You are given an integer array nums, an integer k, and an integer multiplier.
 *
 * You need to perform k operations on nums. In each operation:
 * 1. Find the minimum value x in nums. If there are multiple occurrences of the minimum value,
 *    select the one that appears first.
 * 2. Replace the selected minimum value x with x * multiplier.
 *
 * Return an integer array denoting the final state of nums after performing all k operations.
 *
 * Example 1:
 * Input: nums = [2,1,3,5,6], k = 5, multiplier = 2
 * Output: [8,4,6,5,6]
 * Explanation:
 * Operation   Result
 * After op 1: [2,2,3,5,6]
 * After op 2: [4,2,3,5,6]
 * After op 3: [4,4,3,5,6]
 * After op 4: [4,4,6,5,6]
 * After op 5: [8,4,6,5,6]
 *
 * Example 2:
 * Input: nums = [1,2], k = 3, multiplier = 4
 * Output: [16,8]
 * Explanation:
 * Operation   Result
 * After op 1: [4,2]
 * After op 2: [4,8]
 * After op 3: [16,8]
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^9
 * - 1 <= k <= 10^5
 * - 1 <= multiplier <= 100
 */
class FinalArrayStateAfterKOperations {
    /**
     * Time Complexity: O((n + k) log n)
     * - Initial heap creation: O(n log n) for adding n elements to priority queue
     * - K operations: O(k log n) for k poll() and offer() operations
     * Where n is the array length and k is the number of operations
     *
     * Space Complexity: O(n)
     * - Priority Queue stores n pairs of (value, index)
     * - No additional space used besides the priority queue
     */
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        // Create a min heap that stores pairs of (value, index)
        // We include index to handle duplicate values and maintain original order
        val pq = PriorityQueue(compareBy<Pair<Int, Int>>({ it.first }, { it.second }))
        
        // Initialize the priority queue with all numbers and their indices
        // This takes O(n log n) time as each insertion is O(log n)
        nums.forEachIndexed { index, value -> pq.offer(Pair(value, index)) }
        
        // Perform k operations
        // Each operation takes O(log n) time for both poll and offer
        repeat(k) {
            // Get the minimum value and its index
            val (value, index) = pq.poll()
            
            // Calculate new value and update original array
            val multipliedValue = value * multiplier
            nums[index] = multipliedValue
            
            // Add the new value back to the queue with same index
            // This maintains the element's position for future operations
            pq.offer(Pair(multipliedValue, index))
        }
        
        return nums
    }
}
