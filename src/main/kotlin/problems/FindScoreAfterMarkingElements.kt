package problems

import java.util.PriorityQueue
import kotlin.math.min

/**
 * Problem: 2593. Find Score of an Array After Marking All Elements
 * https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/
 *
 * You are given an array nums consisting of positive integers.
 * Starting with score = 0, apply the following algorithm:
 * 1. Choose the smallest integer of the array that is not marked. If there is a tie, choose the one with the smallest index.
 * 2. Add the value of the chosen integer to score.
 * 3. Mark the chosen element and its two adjacent elements if they exist.
 * 4. Repeat until all elements are marked.
 * Return the score you get after applying the above algorithm.
 *
 * Approach:
 * - Use PriorityQueue to always get the smallest unmarked element
 * - Use BooleanArray for O(1) marking of elements
 * - Process elements in order of value (and index for ties)
 * - Skip already marked elements when processing
 *
 * Example:
 * nums = [2,1,3,4,5,2]
 * Steps:
 * 1. Pick 1 (index 1): mark [2,1,3], score = 1
 * 2. Pick 2 (index 5): mark [2,1,3,4,5,2], score = 3
 * 3. Pick 4 (index 3): already marked
 * Final score = 3
 *
 * Time Complexity: O(n log n) for priority queue operations
 * Space Complexity: O(n) for priority queue and boolean array
 */
class FindScoreAfterMarkingElements {
    fun findScore(nums: IntArray): Long {
        var score = 0L
        val n = nums.size
        
        // Priority queue to get elements in order of value and index
        // Custom comparator handles ties by picking smaller index
        val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
            if (a.first != b.first) {
                a.first - b.first // Sort by value first
            } else {
                a.second - b.second // If values equal, sort by index
            }
        }
        
        // Add all elements with their indices to priority queue
        nums.forEachIndexed { index, value ->
            pq.offer(Pair(value, index))
        }
        
        // Boolean array to mark elements in O(1) time
        val marked = BooleanArray(n)
        
        // Process elements until queue is empty
        while (pq.isNotEmpty()) {
            val (value, idx) = pq.poll()
            // Only process if current element is not marked
            if (!marked[idx]) {
                score += value // Add current value to score
                marked[idx] = true // Mark current element
                // Mark adjacent elements if they exist
                if (idx + 1 < n) marked[idx + 1] = true // Right neighbor
                if (idx - 1 >= 0) marked[idx - 1] = true // Left neighbor
            }
        }
        
        return score
    }
}
