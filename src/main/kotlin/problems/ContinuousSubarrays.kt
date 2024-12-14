package problems

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * Problem: 2762. Continuous Subarrays
 * https://leetcode.com/problems/continuous-subarrays/
 *
 * You are given a 0-indexed integer array nums. A subarray of nums is called continuous if:
 * - Let i, i + 1, ..., j be the indices in the subarray. For any two indices i <= k1, k2 <= j,
 *   abs(nums[k1] - nums[k2]) <= 2.
 *
 * Return the total number of continuous subarrays.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Time Complexity: O(X)
 * Space Complexity: O(X)
 */

/**
 * Solution for finding the number of continuous subarrays where max difference between any two elements is at most 2
 * 
 * Approach:
 * - Uses sliding window technique where we maintain a window that satisfies the condition
 * - When the condition is violated (max-min > 2), we count the valid subarrays up to that point
 * - Then we reset the window and try to extend it backwards as much as possible
 */
class ContinuousSubarrays {
    /**
     * Counts the number of continuous subarrays where the maximum difference between any two elements is at most 2
     * 
     * @param nums Input array of integers
     * @return Long value representing the count of valid subarrays
     * 
     * Time Complexity: O(n) where n is the length of input array
     * Space Complexity: O(1) as we only use constant extra space
     */
    fun continuousSubarrays(nums: IntArray): Long {
        val n = nums.size
        var startIdx = 0          // Start of current valid window
        var endIdx = 0            // End of current valid window
        var maxVal = Int.MIN_VALUE // Maximum value in current window
        var minVal = Int.MAX_VALUE // Minimum value in current window
        var count = 0L            // Total count of valid subarrays
        
        while (endIdx < n) {
            // Update window boundaries
            maxVal = max(nums[endIdx], maxVal)
            minVal = min(nums[endIdx], minVal)

            // If current window violates the condition (max-min > 2)
            if (maxVal - minVal > 2) {
                // Add count of all valid subarrays up to this point
                count += getCount(startIdx, endIdx)
                
                // Reset window to current position
                startIdx = endIdx
                maxVal = nums[endIdx]
                minVal = nums[endIdx]

                // Try to extend window backwards as long as possible while maintaining the condition
                // Convert to Long to handle large integer differences safely
                while (startIdx > 0 && abs(nums[endIdx].toLong() - nums[startIdx - 1].toLong()) <= 2) {
                    startIdx--
                    maxVal = max(nums[startIdx], maxVal)
                    minVal = min(nums[startIdx], minVal)
                }

                // If we extended backwards, subtract the overcounted subarrays
                if (startIdx < endIdx) {
                    count -= getCount(startIdx, endIdx)
                }
            }
            ++endIdx
        }
        // Add count of valid subarrays in the final window
        count += getCount(startIdx, endIdx)
        return count
    }

    /**
     * Calculates the number of all possible subarrays between startIdx and endIdx
     * 
     * @param startIdx Start index of the window
     * @param endIdx End index of the window
     * @return Number of possible subarrays as Long to handle large numbers
     * 
     * Formula: n * (n + 1) / 2 where n is the size of the window
     * Convert to Long early to prevent integer overflow
     */
    private fun getCount(startIdx: Int, endIdx: Int): Long {
        val subSize = endIdx - startIdx
        return ((subSize.toLong() * (subSize + 1).toLong()) / 2)
    }
}
