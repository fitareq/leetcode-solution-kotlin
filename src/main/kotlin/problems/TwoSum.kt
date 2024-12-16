package problems

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Explanation: Because nums[1] + nums[2] == 6, we return [1, 2].
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 6, we return [0, 1].
 *
 * Constraints:
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * - Only one valid answer exists.
 */
class TwoSum {
    /**
     * Time Complexity: O(n)
     * - Single pass through the array
     * - HashMap operations (put/get) are O(1) on average
     *
     * Space Complexity: O(n)
     * - HashMap can store at most n elements
     * - Where n is the length of the input array
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // Use HashMap to store complement values and their indices
        val numMap = mutableMapOf<Int, Int>()
        
        // Iterate through array once, checking if complement exists
        nums.forEachIndexed { index, num ->
            // Calculate the complement needed to reach target
            val complement = target - num
            
            // If complement exists in map, we found our pair
            if (numMap.containsKey(complement)) {
                return intArrayOf(numMap[complement]!!, index)
            }
            
            // Store current number and index for future lookups
            numMap[num] = index
        }
        
        // No solution found (though problem guarantees one exists)
        throw IllegalArgumentException("No solution exists")
    }
}
