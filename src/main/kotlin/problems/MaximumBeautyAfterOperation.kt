package problems

/**
 * 2779. Maximum Beauty of an Array After Applying Operation
 * https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/
 *
 * You are given a 0-indexed array nums and a non-negative integer k.
 *
 * In one operation, you can do the following:
 * - Choose an index i that hasn't been chosen before, and change nums[i] to any integer between
 *   nums[i] - k and nums[i] + k (inclusive).
 *
 * The beauty of the array is the length of the longest subsequence consisting of equal elements.
 *
 * Return the maximum possible beauty of the array nums after applying the operation any number of times.
 *
 * Note that you can apply the operation to each index only once.
 *
 * Example 1:
 * Input: nums = [4,6,1,2], k = 2
 * Output: 3
 * Explanation:
 * In this example, we can apply the following operations:
 * - Choose index 2 and change nums[2] to 3: [4,6,3,2]
 * - Choose index 3 and change nums[3] to 4: [4,6,3,4]
 * After the operations, the longest subsequence of equal elements is [4,4], with length 2.
 * It can be shown that 2 is the maximum possible beauty after applying any sequence of operations.
 *
 * Example 2:
 * Input: nums = [1,1,1,1], k = 10
 * Output: 4
 * Explanation:
 * The array is already perfect, and we don't need to apply any operations.
 * The longest subsequence of equal elements is [1,1,1,1], with length 4.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 0 <= nums[i], k <= 10^5
 */
class MaximumBeautyAfterOperation {
    /**
     * Time Complexity: O(n log n)
     * - Sorting the array takes O(n log n)
     * - Single pass through sorted array takes O(n)
     * - Where n is the length of nums array
     *
     * Space Complexity: O(n)
     * - Sorting may require O(n) extra space
     * - Where n is the length of nums array
     */
    fun maximumBeauty(nums: IntArray, k: Int): Int {
        // Sort array to group similar numbers together
        nums.sort()
        
        var maxBeauty = 0
        var left = 0
        
        // Use sliding window to find longest subsequence
        // that can be made equal with k operations
        for (right in nums.indices) {
            // While window is invalid (difference > 2k), shrink from left
            while (nums[right] - nums[left] > 2 * k) {
                left++
            }
            
            // Current window size is potential beauty value
            maxBeauty = maxOf(maxBeauty, right - left + 1)
        }
        
        return maxBeauty
    }
}
