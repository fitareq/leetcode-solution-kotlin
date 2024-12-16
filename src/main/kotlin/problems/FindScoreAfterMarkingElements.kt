package problems

/**
 * 2593. Find Score of an Array After Marking Elements
 * https://leetcode.com/problems/find-score-of-an-array-after-marking-elements/
 *
 * You are given an array nums consisting of positive integers.
 *
 * Starting with score = 0, apply the following algorithm:
 * 1. Choose the smallest unmarked element x in nums. If multiple such elements exist, choose the one with the smallest index.
 * 2. Add x to score.
 * 3. Mark x and all elements with values in the range [x - k, x + k] (inclusive).
 * 4. Repeat steps 1-3 until all elements in nums are marked.
 *
 * Return the score you get after applying the above algorithm.
 *
 * Example 1:
 * Input: nums = [2,1,3,4,5,2], k = 2
 * Output: 7
 * Explanation: Process elements as follows:
 * 1. Choose unmarked element 1. score = 1. Mark elements in range [1-2, 1+2] => Mark 1,2,3
 * 2. Choose unmarked element 4. score = 5. Mark elements in range [4-2, 4+2] => Mark 2,3,4,5,6
 * 3. Choose unmarked element 5. score = 10. Mark element 5
 * 4. Choose unmarked element 2. score = 12. Mark element 2
 * Final score = 7.
 *
 * Example 2:
 * Input: nums = [2,3,5,1,3,2], k = 3
 * Output: 5
 * Explanation: Process elements as follows:
 * 1. Choose unmarked element 1. score = 1. Mark elements in range [1-3, 1+3] => Mark 1,2,3,4
 * 2. Choose unmarked element 2. score = 3. Mark elements in range [2-3, 2+3] => Mark 0,1,2,3,4,5
 * 3. Choose unmarked element 3. score = 6. Mark elements in range [3-3, 3+3] => Mark 0,1,2,3,4,5,6
 * Final score = 5.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^6
 * - 0 <= k <= 10^6
 */
class FindScoreAfterMarkingElements {
    /**
     * Time Complexity: O(n log n)
     * - Creating and sorting pairs takes O(n log n)
     * - Marking elements in boolean array takes O(n)
     * - Where n is the length of input array
     *
     * Space Complexity: O(n)
     * - Array of pairs takes O(n)
     * - Boolean array takes O(n)
     * - Where n is the length of input array
     */
    fun findScore(nums: IntArray, k: Int): Long {
        // Create array of pairs (value, index) for sorting
        val pairs = Array(nums.size) { i -> Pair(nums[i], i) }
        // Sort by value first, then by index
        pairs.sortWith(compareBy({ it.first }, { it.second }))
        
        // Track marked elements
        val marked = BooleanArray(nums.size)
        var score = 0L
        
        // Process elements in sorted order
        for ((value, index) in pairs) {
            // Skip if already marked
            if (marked[index]) continue
            
            // Add current value to score
            score += value
            
            // Mark elements in range [index-k, index+k]
            val start = maxOf(0, index - k)
            val end = minOf(nums.size - 1, index + k)
            for (i in start..end) {
                marked[i] = true
            }
        }
        
        return score
    }
}
