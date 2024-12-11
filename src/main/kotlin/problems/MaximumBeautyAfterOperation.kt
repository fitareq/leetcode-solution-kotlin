package problems

import kotlin.math.max

/**
 * Problem: Maximum Beauty of an Array After Applying Operation
 * https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/
 *
 * You are given a 0-indexed array nums and a non-negative integer k.
 * In one operation, you can do the following:
 * - Choose an index i that hasn't been chosen before and increase or decrease nums[i] by k
 *
 * The beauty of the array is the length of the longest subsequence consisting of equal elements.
 * Return the maximum possible beauty of the array nums after applying the operation any number of times.
 *
 * Example 1:
 * Input: nums = [4,6,1,2], k = 2
 * Output: 3
 * Explanation: In this example, we can perform the operation on indices 1, 2, and 3
 * to make nums = [4,4,4,4]. The array will have a beauty of 4.
 * It can be proven that 4 is the maximum possible beauty we can achieve.
 *
 * Example 2:
 * Input: nums = [1,1,1,1], k = 10
 * Output: 4
 * Explanation: In this example, we don't need to perform any operations.
 * The array already has a beauty of 4.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 0 <= nums[i], k <= 10^5
 *
 * @param nums Array of integers
 * @param k Non-negative integer for increment/decrement
 * @return Maximum possible beauty of the array after operations
 */
class MaximumBeautyAfterOperation {
    /**
     * Solution using Sliding Window with Sorting
     *
     * Approach:
     * 1. Sort array to group potential equal numbers together
     * 2. Use sliding window to find the longest sequence that can be made equal
     * 3. For any two numbers to be made equal, their difference must be ≤ 2k
     *    (k steps up from smaller number, k steps down from larger number)
     *
     * Time: O(n log n) for sorting
     * Space: O(1) as sorting is in-place
     */
    fun maximumBeauty(nums: IntArray, k: Int): Int {
        val range = k * 2  // Maximum allowed difference between any two numbers
        val n = nums.size
        var maxBeauty = 0
        var start = 0  // Window start pointer
        var end = 0    // Window end pointer

        // Sort to group potential equal numbers together
        nums.sort()

        // Sliding window to find the longest sequence that can be made equal
        while (end in start..<n) {
            // If difference between max and min in window ≤ 2k,
            // all numbers in window can be made equal
            if (nums[end] - nums[start] <= range) {
                // Update max beauty with current window size
                maxBeauty = max(maxBeauty, (end - start) + 1)
                ++end  // Try to expand window
            } else {
                // Window too large, shrink from start
                ++start
            }
        }
        return maxBeauty
    }

    /**
     * Alternative solution using line sweep technique
     */
    fun maximumBeautyAlternative(nums: IntArray, k: Int): Int {
        // Create events for range boundaries
        val events = ArrayList<Pair<Int, Int>>()  // (position, +1/-1)
        
        // For each number, create start and end events
        for (num in nums) {
            events.add(Pair(num - k, 1))    // Start of range
            events.add(Pair(num + k + 1, -1))  // End of range + 1
        }
        
        // Sort events by position
        events.sortBy { it.first }
        
        var current = 0
        var maxBeauty = 0
        
        // Process events in order
        for ((_, delta) in events) {
            current += delta
            maxBeauty = max(maxBeauty, current)
        }
        
        return maxBeauty
    }
}
