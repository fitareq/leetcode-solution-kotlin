package problems

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * 2762. Continuous Subarrays
 * https://leetcode.com/problems/continuous-subarrays/
 *
 * You are given a 0-indexed integer array nums. A subarray of nums is called continuous if:
 * Let i, i + 1, ..., j be the indices in the subarray. For any two indices i <= k1, k2 <= j,
 * abs(nums[k1] - nums[k2]) <= 2.
 *
 * Return the total number of continuous subarrays.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example 1:
 * Input: nums = [5,4,2,4]
 * Output: 8
 * Explanation:
 * Continuous subarrays are:
 * - Length 1: [5], [4], [2], [4]
 * - Length 2: [5,4], [4,2], [2,4]
 * - Length 3: [4,2,4]
 * Total number of continuous subarrays = 8
 *
 * Example 2:
 * Input: nums = [1,2,3]
 * Output: 6
 * Explanation:
 * Continuous subarrays are:
 * - Length 1: [1], [2], [3]
 * - Length 2: [1,2], [2,3]
 * - Length 3: [1,2,3]
 * Total number of continuous subarrays = 6
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^9
 */
class ContinuousSubarrays {
    /**
     * Time Complexity: O(n)
     * - Single pass through the array using sliding window
     * - TreeMap operations (add/remove) are O(log k) where k is window size
     * - k is bounded by constant (max diff is 2), so operations are O(1)
     * - Total: O(n) where n is the length of input array
     *
     * Space Complexity: O(1)
     * - TreeMap size is bounded by constant (max diff is 2)
     * - Only constant extra space needed for variables
     */
    fun continuousSubarrays(nums: IntArray): Long {
        // Track frequency of numbers in current window
        val window = sortedMapOf<Int, Int>()
        var result = 0L
        var left = 0
        
        // Use sliding window to find all valid subarrays
        for (right in nums.indices) {
            // Add current number to window
            window[nums[right]] = window.getOrDefault(nums[right], 0) + 1
            
            // While window is invalid (max diff > 2), shrink from left
            while (window.lastKey() - window.firstKey() > 2) {
                // Remove leftmost number
                val count = window[nums[left]]!! - 1
                if (count == 0) {
                    window.remove(nums[left])
                } else {
                    window[nums[left]] = count
                }
                left++
            }
            
            // Add count of all valid subarrays ending at right
            result += right - left + 1
        }
        
        return result
    }
}
